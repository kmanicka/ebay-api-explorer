package controllers;

import play.*;
import play.cache.Cache;
import play.mvc.*;
import viewobjects.IndexView;
import viewobjects.SettingsView;

import java.net.URLEncoder;
import java.util.*;

import common.IConstants;
import common.Util;
import core.EBayCallContext;
import core.IeBayCallContext;
import core.shopping.calls.GeteBayTime;
import core.trading.calls.FetchToken;
import core.trading.calls.GetSessionID;
import core.trading.calls.GeteBayOfficialTime;
import models.*;

public class Application extends Controller implements IConstants {

	public static void index() {
		IndexView indexView = new IndexView();
		render(indexView);
	}

	public static void trading() {
		IeBayCallContext eBayCallContext = Application.geteBayCallContext();
		String eBayAuthToken = (String)Cache.get(session.getId() + "-eBayAuthToken");

		if(eBayAuthToken == null) {
			login(request.url);
		}
		
		GeteBayOfficialTime viewData = new GeteBayOfficialTime(eBayAuthToken);
		viewData.calleBay(eBayCallContext);
		render(viewData);
	}

	public static void shopping() {
		IeBayCallContext eBayCallContext = Application.geteBayCallContext();
		GeteBayTime viewData = new GeteBayTime();
		viewData.calleBay(eBayCallContext);
		flash.success("jhi");
		flash.error("errod");
		render(viewData);
	}
	
	
	public static void login(String returnUrl) {
		IeBayCallContext eBayCallContext = Application.geteBayCallContext();
		GetSessionID getSessionID = new GetSessionID();
		getSessionID.calleBay(eBayCallContext);
		String sessionID = getSessionID.getSessionID();
		
		Cache.set(session.getId() + "-sessionID", sessionID, "30mn");
		Cache.set(session.getId() + "-returnUrl", returnUrl, "30mn");
		
		String signInEndpoint = (eBayCallContext.isSandbox()) ? SANDBOX_SIGNIN_ENDPOINT : PRODUCTION_SIGNIN_ENDPOINT;

		String urlString = signInEndpoint + "runame=" + eBayCallContext.getRuName() + "&SessID="
				+ URLEncoder.encode(sessionID);

		System.out.println("Login.login()" + urlString);

		redirect(urlString);
	}

	public static void loginAccepted(String tknexp, String username) {
		System.out.println("Login.loginAccepted()");
		String sessionID = (String) Cache.get(session.getId() + "-sessionID");

		IeBayCallContext eBayCallContext = Application.geteBayCallContext();
		FetchToken fetchToken = new FetchToken();
		fetchToken.setSessionID(sessionID);

		fetchToken.calleBay(eBayCallContext);

		String eBayAuthToken = fetchToken.geteBayAuthToken();
		Cache.set(session.getId() + "-eBayAuthToken", eBayAuthToken);

		String returnUrl = (String) Cache.get(session.getId() + "-returnUrl");
		if(returnUrl == null || "".equals(returnUrl.trim())){
			returnUrl ="/";
		}
		flash.success("Welcome " + username);
		redirect(returnUrl);
	}

	public static void loginDeclined() {
		flash.error("Login Failed");
		index();
	}


	public static void settings() {		
		SettingsView settingsView = new SettingsView();
		render(settingsView);
	}

	public static void about() {
		render();
	}

	// Package access only
	static IeBayCallContext geteBayCallContext() {
		EBayCallContext eBayCallContext = new EBayCallContext();

		String envIsSandbox = Util.getEnvVariable(ENV_SANDBOX);
		if (envIsSandbox != null && "true".equals(envIsSandbox.trim().toLowerCase())) {
			eBayCallContext.setSandbox(true);
		} else {
			eBayCallContext.setSandbox(false);
		}

		eBayCallContext.setDevName(Util.getEnvVariable(ENV_DEVID));

		eBayCallContext.setAppName(Util.getEnvVariable(ENV_APPID));

		eBayCallContext.setCertName(Util.getEnvVariable(ENV_CERTID));

		eBayCallContext.setRuName(Util.getEnvVariable(ENV_RUNAME));

		return (IeBayCallContext) eBayCallContext;
	}

}
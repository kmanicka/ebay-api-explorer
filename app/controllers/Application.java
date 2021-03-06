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
import core.trading.calls.GetUser;
import core.trading.calls.GeteBayOfficialTime;
import models.*;

public class Application extends Controller implements IConstants {

	public static void index() {
		IndexView indexView = new IndexView();
		render(indexView);
	}

	public static void trading() {
		IeBayCallContext eBayCallContext = Application.geteBayCallContext();
		String eBayAuthToken = eBayCallContext.getAuthToken();

		if (eBayAuthToken == null) {
			login(request.url);
		}

		GeteBayOfficialTime viewData = new GeteBayOfficialTime();
		viewData.calleBay(eBayCallContext);
		render(viewData);
	}

	public static void shopping() {
		IeBayCallContext eBayCallContext = Application.geteBayCallContext();
		GeteBayTime viewData = new GeteBayTime();
		viewData.calleBay(eBayCallContext);
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
		System.out.println("Application.login()" + urlString);
		redirect(urlString);
	}

	// this is called by eBay when User Logs in via eBay and Accepts
	public static void loginAcceptedCallback() {
		System.out.println("Application.loginAcceptedCallback()");

		String sessionID = (String) Cache.get(session.getId() + "-sessionID");

		IeBayCallContext eBayCallContext = Application.geteBayCallContext();
		FetchToken fetchToken = new FetchToken();
		fetchToken.setSessionID(sessionID);
		fetchToken.calleBay(eBayCallContext);

		String eBayAuthToken = fetchToken.geteBayAuthToken();

		if (eBayAuthToken == null) {
			System.err.println("Application.loginAcceptedCallback() : AuthToken is Null");
			flash.error("Login Failed : could not fetch auth token");
			index();
		} else {
			loginComplete(eBayAuthToken);
		}

	}

	public static void loginComplete(String eBayAuthToken) {

		EBayCallContext eBayCallContext = (EBayCallContext) Application.geteBayCallContext();
		eBayCallContext.setAuthToken(eBayAuthToken);

		GetUser getUser = new GetUser();
		getUser.calleBay(eBayCallContext);

		String username = getUser.getUsername();

		if (username == null) {
			System.err.println("Application.loginComplete() : Invalid AuthToken");
			flash.error("Login Failed : Invalid AuthToken");
			index();
		}

		session.put("username", username);
		Cache.set(session.getId() + "-eBayAuthToken", eBayAuthToken);

		String returnUrl = (String) Cache.get(session.getId() + "-returnUrl");
		if (returnUrl == null || "".equals(returnUrl.trim())) {
			returnUrl = "/";
		}

		flash.success("Welcome " + username);
		redirect(returnUrl);
	}

	public static void loginDeclinedCallback() {
		flash.error("Login Failed : User declined to provide eBay Credentials");
		redirect("/");
	}

	public static void logout() {
		session.remove("username");
		Cache.delete(session.getId() + "-eBayAuthToken");

		flash.success("Logout Successfull");
		redirect("/");
	}

	// Package access only
	public static EBayCallContext geteBayCallContext() {

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

		if (session != null) {
			eBayCallContext.setAuthToken(Cache.get(session.getId() + "-eBayAuthToken", String.class));
		}
		
		return eBayCallContext;
	}

	public static void settings() {
		
		IeBayCallContext eBayCallContext = Application.geteBayCallContext();

		
		
		GeteBayTime geteBayTime = new GeteBayTime();
		geteBayTime.calleBay(eBayCallContext);
		
		GeteBayOfficialTime geteBayOfficialTime = new GeteBayOfficialTime();
		geteBayOfficialTime.calleBay(eBayCallContext);
		
		SettingsView settingsView = new SettingsView(eBayCallContext,geteBayTime,geteBayOfficialTime);
				
		render(settingsView);
	}

	public static void about() {
		render();
	}

}
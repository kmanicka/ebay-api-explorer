package controllers;

import play.*;
import play.cache.Cache;
import play.mvc.*;
import viewobjects.IndexView;
import viewobjects.SettingsView;

import java.util.*;

import common.IConstants;
import common.Util;
import core.EBayCallContext;
import core.IeBayCallContext;
import core.shopping.calls.GeteBayTime;
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
			Login.login();
		}
		
		GeteBayOfficialTime viewData = new GeteBayOfficialTime(eBayAuthToken);
		viewData.calleBay(eBayCallContext);
		render(viewData);
	}

	public static void shopping() {
		IeBayCallContext eBayCallContext = Application.geteBayCallContext();
		GeteBayTime viewData = new GeteBayTime();
		viewData.calleBay(eBayCallContext);
		render(viewData);
	}

	public static void settings() {

//		GeteBayTime time = new GeteBayTime();
//		time.calleBay();
//
//		GeteBayOfficialTime officialTime = new GeteBayOfficialTime(null);
//		officialTime.calleBay();
//
//		SettingsView settingsView = new SettingsView();
//		settingsView.time = time.getTime();
//		settingsView.shoppingCallAck = time.getAck();
//		settingsView.shoppingCallResponse = time.getResponseString();
//
//		settingsView.officialTime = officialTime.getTime();
//		settingsView.tradingCallAck = officialTime.getAck();
//		settingsView.tradingCallResponse = officialTime.getResponseString();
//
//		render(settingsView);
		
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
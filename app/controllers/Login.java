package controllers;


import java.net.URLEncoder;

import common.IConstants;
import common.Util;
import core.trading.calls.FetchToken;
import core.trading.calls.GetSessionID;
import play.cache.Cache;
import play.mvc.Controller;

public class Login extends Controller implements IConstants {

	public static void login() {
		GetSessionID getSessionID = new GetSessionID(true);
		getSessionID.calleBay();
		String sessionID = getSessionID.getSessionID();
		Cache.set(session.getId() + "-sessionID", sessionID, "30mn");
		
		String urlString = PRODUCTION_SIGNIN_ENDPOINT + "runame=" + Util.getEnvVariable(ENV_PRODUCTION_RUNAME)
				+ "&SessID=" + URLEncoder.encode(sessionID);

		System.out.println("Login.login()" + urlString);
		
		redirect(urlString);
	}

	public static void loginAccepted(String tknexp, String username) {
		System.out.println("Login.loginAccepted()"); 
		String sessionID = (String)Cache.get(session.getId() + "-sessionID");
		
		FetchToken fetchToken = new FetchToken(true);
		fetchToken.setSessionID(sessionID);
		
		fetchToken.calleBay();
		
		String eBayAuthToken = fetchToken.geteBayAuthToken();
		Cache.set(session.getId() + "-eBayAuthToken", eBayAuthToken);
		
		renderText("login accepted " + username + " :: "+ eBayAuthToken);
	}

	public static void loginDeclined() {
		System.out.println("Login.loginDeclinec()");
		renderText("login declined");
	}
}
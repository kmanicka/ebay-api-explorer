package core;

import common.IConstants;
import common.Util;

public class EBayCallContext implements IeBayCallContext, IConstants {

	private Boolean sandbox;
	private String devName;
	private String appName;
	private String certName;
	private String ruName;
	private String authToken;

	public Boolean isSandbox() {
		return sandbox;
	}

	public void setSandbox(Boolean sandbox) {
		this.sandbox = sandbox;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public void setRuName(String ruName) {
		this.ruName = ruName;
	}

	public String getDevName() {
		return devName;
	}

	public String getAppName() {
		return appName;
	}

	public String getCertName() {
		return certName;
	}

	public String getRuName() {
		return ruName;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

}

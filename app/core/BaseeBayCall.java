package core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import common.IConstants;
import common.Util;
import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.libs.WS.WSRequest;
import play.libs.XML;
import play.libs.XPath;

public abstract class BaseeBayCall implements IConstants, IeBayCall {
	
	protected Boolean isProduction;
	private String responseString;
	private Document responseXml;
	private String ack;
	private List<String> errors;

	public BaseeBayCall() {
		this(false);
	}

	public BaseeBayCall(Boolean isProduction) {
		super();
		this.isProduction = isProduction;
	}

	protected String getEnvVariable(String name) {
		return Util.getEnvVariable(name); 
	}

	protected String getDevName() {
		return (isProduction) ? getEnvVariable(ENV_PRODUCTION_DEVID) : getEnvVariable(ENV_SANDBOX_DEVID);
	}

	protected String getAppName() {
		return (isProduction) ? getEnvVariable(ENV_PRODUCTION_APPID) : getEnvVariable(ENV_SANDBOX_APPID);
	}

	protected String getCertName() {
		return (isProduction) ? getEnvVariable(ENV_PRODUCTION_CERTID) : getEnvVariable(ENV_SANDBOX_CERTID);
	}

	public void calleBay() {
		try {
			System.out.println("BaseeBayCall.calleBay()");
			WSRequest request = WS.url(getEndPoint());
			String requestString = getRequestBody();

			System.out.println("Request >>>>>>");
			System.out.println(getApiHeaders().toString());
			System.out.println(requestString);
			

			request.headers(getApiHeaders());
			request.body(requestString);
			HttpResponse res = request.post();
			this.responseString = res.getString();

			System.out.println("Response >>>>>>");
			System.out.println(responseString);

			this.responseXml = XML.getDocument(this.responseString);
			this.ack = XPath.selectText("//Ack", this.responseXml);
			processResponse();
		} catch (Exception e) {
			errors.add(e.getMessage());
		}
	}

	public String getResponseString() {
		return responseString;
	}

	public String getAck() {
		return ack;
	}

	public Document getResponseXml() {
		return responseXml;
	}

	public List<String> getErros() {
		return errors;
	}

	protected abstract String getEndPoint();
	
	protected abstract Map<String, String> getApiHeaders();

	protected abstract String getCallName();

	protected abstract String getRequestBody() throws Exception;

	protected abstract void processResponse() throws Exception;

}

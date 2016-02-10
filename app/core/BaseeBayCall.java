package core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.libs.WS.WSRequest;
import play.libs.XML;

public abstract class BaseeBayCall implements IeBayCall {
	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
	
	public static final String SANDBOX_DEVID = "SANDBOX_DEVID";
	public static final String SANDBOX_APPID = "SANDBOX_APPID";
	public static final String SANDBOX_CERTID = "SANDBOX_CERTID";

	public static final String PRODUCTION_DEVID = "PRODUCTION_DEVID";
	public static final String PRODUCTION_APPID = "PRODUCTION_APPID";
	public static final String PRODUCTION_CERTID = "PRODUCTION_CERTID";

	public static final String SANDBOX_ENDPOINT = "https://api.sandbox.ebay.com/ws/api.dll";
	public static final String PRODUCTION_ENDPOINT = "https://api.ebay.com/ws/api.dll";

	protected Boolean isProduction;
	private String responseString;
	private Document responseXml;
	private List<String> errors;

	public BaseeBayCall() {
		this(false);
	}

	public BaseeBayCall(Boolean isProduction) {
		super();
		this.isProduction = isProduction;
	}

	protected String getEnvVariable(String name) {
		return System.getenv(name);
	}

	protected String getDevName() {
		return (isProduction) ? getEnvVariable(PRODUCTION_DEVID) : getEnvVariable(SANDBOX_DEVID);
	}

	protected String getAppName() {
		return (isProduction) ? getEnvVariable(PRODUCTION_APPID) : getEnvVariable(SANDBOX_APPID);
	}

	protected String getCertName() {
		return (isProduction) ? getEnvVariable(PRODUCTION_CERTID) : getEnvVariable(SANDBOX_CERTID);
	}

	public void calleBay() {
		try {
			System.out.println("BaseeBayCall.calleBay()");
			WSRequest request = WS.url((isProduction) ? PRODUCTION_ENDPOINT : SANDBOX_ENDPOINT);
			String requestString = getRequestBody();

			System.out.println("Request >>>>>>");
			System.out.println(requestString);

			request.headers(getApiHeaders());
			request.body(requestString);
			HttpResponse res = request.post();
			this.responseString = res.getString();

			System.out.println("Response >>>>>>");
			System.out.println(responseString);

			this.responseXml = XML.getDocument(this.responseString);
			processResponse();
		} catch (Exception e) {
			errors.add(e.getMessage());
		}
	}

	public String getResponseString() {
		return responseString;
	}

	public Document getResponseXml() {
		return responseXml;
	}

	public List<String> getErros() {
		return errors;
	}

	protected abstract Map<String, String> getApiHeaders();

	protected abstract String getCallName();

	protected abstract String getRequestBody() throws Exception;

	protected abstract void processResponse() throws Exception;

}

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

	private IeBayCallContext eBayCallContext;
	private Map<String, String> headers;
	private String requestString;
	private String responseString;
	private Document responseXml;
	private String ack;
	private List<String> errors;

	protected Boolean isSandbox() {
		return eBayCallContext.isSandbox();
	}

	protected Boolean isProduction() {
		return !(isSandbox());
	}

	protected String getDevName() {
		return eBayCallContext.getDevName();
	}

	protected String getAppName() {
		return eBayCallContext.getAppName();
	}

	protected String getCertName() {
		return eBayCallContext.getCertName();
	}

	protected String getRuName() {
		return eBayCallContext.getRuName();
	}

	public void calleBay(IeBayCallContext eBayCallContext) {
		this.eBayCallContext = eBayCallContext;
		try {
			System.out.println("BaseeBayCall.calleBay()");

			WSRequest request = WS.url(getEndPoint());
			String unformatedRequestString = getRequestBody();
			this.requestString = Util.prettyXml(unformatedRequestString);
			this.headers = getApiHeaders();

			System.out.println("Request >>>>>>");
			System.out.println(getEndPoint());
			System.out.println(this.headers.toString());
			System.out.println(this.requestString);

			request.headers(this.headers);
			request.body(this.requestString);
			HttpResponse res = request.post();

			String unformatedResponseString = res.getString();
			this.responseXml = XML.getDocument(unformatedResponseString);
			this.responseString = Util.prettyXml(this.responseXml);

			System.out.println("Response >>>>>>");
			System.out.println(this.responseString);

			this.ack = XPath.selectText("//Ack", this.responseXml);

			processResponse();
		} catch (Exception e) {
			errors.add(e.getMessage());
		}
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public String getRequestString() {
		return requestString;
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

	protected abstract Map<String, String> getApiHeaders();

	protected abstract String getEndPoint();

	protected abstract String getCallName();

	protected abstract String getRequestBody() throws Exception;

	protected abstract void processResponse() throws Exception;
}

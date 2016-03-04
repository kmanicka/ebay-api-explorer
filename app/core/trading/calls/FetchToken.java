package core.trading.calls;

import core.trading.BaseeBayTradingCall;
import play.libs.XPath;

public class FetchToken  extends BaseeBayTradingCall{
	public String sessionID;
	public String eBayAuthToken;
	
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public String geteBayAuthToken() {
		return eBayAuthToken;
	}
	
	@Override
	protected String getCallName() {
		final String CALL_NAME = "FetchToken";
		return CALL_NAME;
	}

	@Override
	protected String getRequestBody() throws Exception {
		return XML_HEADER
				+ "<FetchTokenRequest xmlns=\"urn:ebay:apis:eBLBaseComponents\">" 
				+ "<SessionID>" + sessionID + "</SessionID>" 
				+ "</FetchTokenRequest>";	
	}

	@Override
	protected void processResponse() throws Exception {
		this.eBayAuthToken = XPath.selectText("//eBayAuthToken", super.getResponseXml());		
	}
}

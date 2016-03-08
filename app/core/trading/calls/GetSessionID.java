package core.trading.calls;

import core.trading.BaseeBayTradingCall;
import play.libs.XPath;

public class GetSessionID extends BaseeBayTradingCall {
	private String sessionID;

	public String getSessionID() {
		return sessionID;
	}

	@Override
	protected String getCallName() {
		final String CALL_NAME = "GetSessionID";
		return CALL_NAME;
	}

	@Override
	protected String getRequestBody() throws Exception {
		return XML_HEADER + "<GetSessionIDRequest xmlns=\"urn:ebay:apis:eBLBaseComponents\">" + "<RuName>" + getRuName()
				+ "</RuName>" + "</GetSessionIDRequest>";
	}

	@Override
	protected void processResponse() throws Exception {
		this.sessionID = XPath.selectText("//SessionID", super.getResponseXml());
	}

}

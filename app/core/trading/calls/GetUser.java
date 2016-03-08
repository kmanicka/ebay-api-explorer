package core.trading.calls;

import core.trading.BaseeBayTradingCall;
import play.libs.XPath;

public class GetUser extends BaseeBayTradingCall {
	private String username;

	public String getUsername() {
		return username;
	}

	@Override
	protected String getCallName() {
		final String CALL_NAME = "GetUser";
		return CALL_NAME;
	}

	@Override
	protected String getRequestBody() throws Exception {
		return XML_HEADER + "<GetUserRequest xmlns=\"urn:ebay:apis:eBLBaseComponents\">" + getRequestCred()
				+ "</GetUserRequest>";
	}

	@Override
	protected void processResponse() throws Exception {
		this.username = XPath.selectText("//UserID", super.getResponseXml());
	}

}

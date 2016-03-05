package core.trading.calls;

import core.trading.BaseeBayTradingCall;
import play.libs.XPath;

public class GeteBayOfficialTime extends BaseeBayTradingCall {

	public String time;

	public GeteBayOfficialTime(String authToken) {
		super(authToken);
	}

	public String getTime() {
		return time;
	}

	@Override
	protected String getCallName() {
		final String CALL_NAME = "GeteBayOfficialTime";
		return CALL_NAME;
	}

	@Override
	protected String getRequestBody() throws Exception {
		return XML_HEADER + "<GeteBayOfficialTimeRequest xmlns=\"urn:ebay:apis:eBLBaseComponents\">" + getRequestCred()
				+ "</GeteBayOfficialTimeRequest>";
	}

	@Override
	protected void processResponse() throws Exception {
		this.time = XPath.selectText("//Timestamp", super.getResponseXml());
	}

}

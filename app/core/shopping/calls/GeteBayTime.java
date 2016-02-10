package core.shopping.calls;

import core.shopping.BaseeBayShoppingCall;
import play.libs.XPath;

public class GeteBayTime extends BaseeBayShoppingCall {
	public String time;

	public String getTime() {
		return time;
	}

	@Override
	protected String getCallName() {
		final String CALL_NAME = "GeteBayTime";
		return CALL_NAME;
	}

	@Override
	protected String getRequestBody() throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(XML_HEADER);
		stringBuilder.append("<GeteBayTimeRequest xmlns=\"urn:ebay:apis:eBLBaseComponents\">");
		stringBuilder.append("</GeteBayTimeRequest>");
		return stringBuilder.toString();
	}

	@Override
	protected void processResponse() throws Exception {
		this.time = XPath.selectText("//Timestamp", super.getResponseXml());
	}
}

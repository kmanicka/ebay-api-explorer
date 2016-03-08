package core.shopping.calls;

import core.shopping.BaseeBayShoppingCall;
import play.libs.XPath;

public class GetSingleItem extends BaseeBayShoppingCall{
	String itemid;
	String title;
	
	public GetSingleItem(String itemid) {
		this.itemid = itemid;
	}
	
	public String getItemId(){
		return itemid;
	}

	public String getTitle() {
		return title;
	}

	@Override
	protected String getCallName() {
		final String CALL_NAME = "GetSingleItem";
		return CALL_NAME;
	}

	@Override
	protected String getRequestBody() throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(XML_HEADER);
		stringBuilder.append("<GetSingleItemRequest xmlns=\"urn:ebay:apis:eBLBaseComponents\">");
		stringBuilder.append("<ItemID>" + itemid + "</ItemID>");
		stringBuilder.append("</GetSingleItemRequest>");
		return stringBuilder.toString();
	}

	@Override
	protected void processResponse() throws Exception {
		this.title = XPath.selectText("//Title", super.getResponseXml());
	}


}

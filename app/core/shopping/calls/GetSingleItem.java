package core.shopping.calls;

import core.shopping.BaseeBayShoppingCall;
import play.libs.XPath;

public class GetSingleItem extends BaseeBayShoppingCall {
	String image;

	String title;
	String cost;
	String quantity;
	String sold;
	String shipsFrom;

	String seller;
	String sellerFeedback;
	String sellerFeedbackPercent;
	String itemid;
	String category;
	String store;

	String description;

	public GetSingleItem(String itemid) {
		this.itemid = itemid;
	}

	public String getItemId() {
		return itemid;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public String getCost() {
		return cost;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getSold() {
		return sold;
	}

	public String getShipsFrom() {
		return shipsFrom;
	}

	public String getSeller() {
		return seller;
	}

	public String getSellerFeedback() {
		return sellerFeedback;
	}

	public String getSellerFeedbackPercent() {
		return sellerFeedbackPercent;
	}

	public String getItemid() {
		return itemid;
	}

	public String getCategory() {
		return category;
	}

	public String getStore() {
		return store;
	}

	public String getDescription() {
		return description;
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
		stringBuilder.append("<IncludeSelector>Details,Description</IncludeSelector>");
		stringBuilder.append("</GetSingleItemRequest>");
		return stringBuilder.toString();
	}

	@Override
	protected void processResponse() throws Exception {
		this.image = XPath.selectText("//PictureURL", super.getResponseXml());

		this.title = XPath.selectText("//Title", super.getResponseXml());
		this.cost = XPath.selectText("//CurrentPrice", super.getResponseXml());
		this.quantity = XPath.selectText("//Quantity", super.getResponseXml());
		this.sold = XPath.selectText("//QuantitySold", super.getResponseXml());
		this.shipsFrom = XPath.selectText("//Location", super.getResponseXml());

		this.seller = XPath.selectText("//UserID", super.getResponseXml());
		this.sellerFeedback = XPath.selectText("//FeedbackScore", super.getResponseXml());
		this.sellerFeedbackPercent = XPath.selectText("//PositiveFeedbackPercent", super.getResponseXml());
		this.category = XPath.selectText("//PrimaryCategoryName", super.getResponseXml());
		this.store = XPath.selectText("//StoreName", super.getResponseXml());

		this.description = XPath.selectText("//Description", super.getResponseXml());

	}

}

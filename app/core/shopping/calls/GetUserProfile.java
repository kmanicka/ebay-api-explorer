package core.shopping.calls;

import core.shopping.BaseeBayShoppingCall;
import play.libs.XPath;

public class GetUserProfile extends BaseeBayShoppingCall {
	String userId;
	String aboutMeUrl;
	String feedbackDetailsURL;
	
	public GetUserProfile(String userId) {
		this.userId = userId;
	}

	public String getAboutMeUrl() {
		return aboutMeUrl;
	}

	public String getFeedbackDetailsURL() {
		return feedbackDetailsURL;
	}

	@Override
	protected String getCallName() {
		final String CALL_NAME = "GetUserProfile";
		return CALL_NAME;
	}

	@Override
	protected String getRequestBody() throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(XML_HEADER);
		stringBuilder.append("<GetUserProfileRequest xmlns=\"urn:ebay:apis:eBLBaseComponents\">");
		stringBuilder.append("<UserID>" + userId + "</UserID>");
		stringBuilder.append("</GetUserProfileRequest>");
		return stringBuilder.toString();
	}

	@Override
	protected void processResponse() throws Exception {
		this.aboutMeUrl = XPath.selectText("//AboutMeURL", super.getResponseXml());
		this.feedbackDetailsURL = XPath.selectText("//FeedbackDetailsURL", super.getResponseXml());
	}

}

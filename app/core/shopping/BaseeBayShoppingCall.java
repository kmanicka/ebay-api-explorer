package core.shopping;

import java.util.HashMap;
import java.util.Map;

import core.BaseeBayCall;

public abstract class BaseeBayShoppingCall extends BaseeBayCall {

	@Override
	protected String getEndPoint() {
		return (isProduction) ? SHOPPING_PRODUCTION_ENDPOINT : SHOPPING_SANDBOX_ENDPOINT;
	}


	protected Map<String, String> getApiHeaders() {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-EBAY-API-VERSION", "943");
		headers.put("X-EBAY-API-SITE-ID", "0");
		headers.put("X-EBAY-API-APP-ID", getAppName());
		headers.put("X-EBAY-API-CALL-NAME", getCallName());
		headers.put("X-EBAY-API-REQUEST-ENCODING", "XML");
		return headers;
	}

}

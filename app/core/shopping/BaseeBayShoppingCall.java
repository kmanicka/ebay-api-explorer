package core.shopping;

import java.util.HashMap;
import java.util.Map;

import core.BaseeBayCall;

public abstract class BaseeBayShoppingCall extends BaseeBayCall {
	protected Map<String, String> getApiHeaders() {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-EBAY-API-VERSION", "951");
		headers.put("X-EBAY-API-APP-ID", getAppName());
		headers.put("X-EBAY-API-CALL-NAME", getCallName());
		return headers;
	}

}

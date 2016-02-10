package core.trading;

import java.util.HashMap;
import java.util.Map;

import core.BaseeBayCall;

public abstract class BaseeBayTradingCall extends BaseeBayCall {

	protected Map<String, String> getApiHeaders() {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-EBAY-API-COMPATIBILITY-LEVEL", "951");
		headers.put("X-EBAY-API-DEV-NAME", getDevName());
		headers.put("X-EBAY-API-APP-NAME", getAppName());
		headers.put("X-EBAY-API-CERT-NAME", getCertName());
		headers.put("X-EBAY-API-SITEID", "0");
		headers.put("X-EBAY-API-CALL-NAME", getCallName());

		return headers;
	}

	protected String getRequestCred() {
		return "<RequesterCredentials><eBayAuthToken>" + "TBD" + "</eBayAuthToken></RequesterCredentials>";
	}
}

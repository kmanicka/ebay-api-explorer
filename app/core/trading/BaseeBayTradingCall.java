package core.trading;

import java.util.HashMap;
import java.util.Map;

import core.BaseeBayCall;

public abstract class BaseeBayTradingCall extends BaseeBayCall {


	@Override
	protected String getEndPoint() {
		return (isProduction) ? TRADING_PRODUCTION_ENDPOINT : TRADING_SANDBOX_ENDPOINT;
	}

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
		String authToken = null;
		if (!isProduction) {
			authToken = getEnvVariable(ENV_SANDBOX_AUTH_TOKEN);
		}else{
			authToken = "TBD";
		}
		return "<RequesterCredentials><eBayAuthToken>" + authToken + "</eBayAuthToken></RequesterCredentials>";
	}
}

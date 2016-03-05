package viewobjects;

import common.IConstants;
import common.Util;

public class SettingsView implements IConstants {
	public String time;
	public String shoppingCallAck;
	public String shoppingCallResponse;
	
	public String officialTime;
	public String tradingCallAck;
	public String tradingCallResponse;
	
	public String sandboxDevId;
	public String sandboxAppId;
	public String sandboxCert;
	public String sandboxAuthToken;
	public String producitonDevId;
	public String producitonAppId;
	public String producitonCert;
	public String productionAuthToken;
	public String shoppingSandboxEndpoint;
	public String shoppingProductionEndpoint;
	public String tradingSandboxEndpoint;
	public String tradingProductionEndpoint;

	private String isSet(String env) {
		String value = Util.getEnvVariable(env);
		if (value == null || "".equals(value.trim()) || "NULL".equals(value.trim().toUpperCase())) {
			value = "NULL";
		} else {
			value = "SET";
		}
		return value;
	}

	public SettingsView() {
//		sandboxDevId = isSet(ENV_SANDBOX_DEVID);
//		sandboxAppId = isSet(ENV_SANDBOX_APPID);
//		sandboxCert = isSet(ENV_SANDBOX_CERTID);
//		sandboxAuthToken = isSet(ENV_SANDBOX_AUTH_TOKEN);
//
//		producitonDevId = isSet(ENV_PRODUCTION_DEVID);
//		producitonAppId = isSet(ENV_PRODUCTION_APPID);
//		producitonCert = isSet(ENV_PRODUCTION_CERTID);
//		productionAuthToken = isSet(ENV_PRODUCTION_AUTH_TOKEN);

		shoppingSandboxEndpoint = SHOPPING_SANDBOX_ENDPOINT;
		shoppingProductionEndpoint = SHOPPING_PRODUCTION_ENDPOINT;

		tradingSandboxEndpoint = TRADING_SANDBOX_ENDPOINT;
		tradingProductionEndpoint = TRADING_PRODUCTION_ENDPOINT;
	}
}

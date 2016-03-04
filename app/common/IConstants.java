package common;

public interface IConstants {
	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
	
	public static final String ENV_SANDBOX_DEVID = "SANDBOX_DEVID";
	public static final String ENV_SANDBOX_APPID = "SANDBOX_APPID";
	public static final String ENV_SANDBOX_CERTID = "SANDBOX_CERTID";
	public static final String ENV_SANDBOX_RUNAME = "SANDBOX_RUNAME";

	public static final String ENV_PRODUCTION_DEVID = "PRODUCTION_DEVID";
	public static final String ENV_PRODUCTION_APPID = "PRODUCTION_APPID";
	public static final String ENV_PRODUCTION_CERTID = "PRODUCTION_CERTID";
	public static final String ENV_PRODUCTION_RUNAME = "PRODUCTION_RUNAME";

	public static final String ENV_SANDBOX_AUTH_TOKEN = "SANDBOX_AUTH_TOKEN";
	public static final String ENV_PRODUCTION_AUTH_TOKEN = "PRODUCTION_AUTH_TOKEN";

	public static final String SHOPPING_SANDBOX_ENDPOINT = "http://open.api.sandbox.ebay.com/shopping?";
	public static final String SHOPPING_PRODUCTION_ENDPOINT = "http://open.api.ebay.com/shopping?";

	public static final String TRADING_SANDBOX_ENDPOINT = "https://api.sandbox.ebay.com/ws/api.dll";
	public static final String TRADING_PRODUCTION_ENDPOINT = "https://api.ebay.com/ws/api.dll";
	
	public static final String SANDBOX_SIGNIN_ENDPOINT = "https://signin.sandbox.ebay.com/ws/eBayISAPI.dll?SignIn&";
	public static final String PRODUCTION_SIGNIN_ENDPOINT = "https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&";

}

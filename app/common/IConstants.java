package common;

public interface IConstants {
	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";

	public static final String ENV_SANDBOX = "SANDBOX";

	public static final String ENV_DEVID = "DEVID";
	public static final String ENV_APPID = "APPID";
	public static final String ENV_CERTID = "CERTID";
	public static final String ENV_RUNAME = "RUNAME";
	
	public static final String SHOPPING_SANDBOX_ENDPOINT = "http://open.api.sandbox.ebay.com/shopping?";
	public static final String SHOPPING_PRODUCTION_ENDPOINT = "http://open.api.ebay.com/shopping?";

	public static final String TRADING_SANDBOX_ENDPOINT = "https://api.sandbox.ebay.com/ws/api.dll";
	public static final String TRADING_PRODUCTION_ENDPOINT = "https://api.ebay.com/ws/api.dll";
	
	public static final String SANDBOX_SIGNIN_ENDPOINT = "https://signin.sandbox.ebay.com/ws/eBayISAPI.dll?SignIn&";
	public static final String PRODUCTION_SIGNIN_ENDPOINT = "https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&";

}

package viewobjects;

import common.IConstants;
import common.Util;
import core.IeBayCallContext;

public class SettingsView implements IConstants {
	public String time;
	public String shoppingCallAck;
	public String shoppingCallResponse;
	
	public String officialTime;
	public String tradingCallAck;
	public String tradingCallResponse;
	
	
	public IeBayCallContext ieBayCallContext;


	public SettingsView(IeBayCallContext ieBayCallContext) {
		super();
		this.ieBayCallContext = ieBayCallContext;
	}

}

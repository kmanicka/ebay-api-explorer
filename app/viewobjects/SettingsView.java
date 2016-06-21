package viewobjects;

import common.IConstants;
import common.Util;
import core.IeBayCallContext;
import core.shopping.calls.GeteBayTime;
import core.trading.calls.GeteBayOfficialTime;

public class SettingsView implements IConstants {
	public IeBayCallContext ieBayCallContext;
	public GeteBayTime geteBayTime;
	public GeteBayOfficialTime geteBayOfficialTime;


	public SettingsView(IeBayCallContext eBayCallContext, GeteBayTime geteBayTime,
			GeteBayOfficialTime geteBayOfficialTime) {
		super();
		this.ieBayCallContext = eBayCallContext; 
		this.geteBayTime = geteBayTime;
		this.geteBayOfficialTime = geteBayOfficialTime;
	}

}

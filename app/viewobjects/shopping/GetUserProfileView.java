package viewobjects.shopping;

import core.shopping.BaseeBayShoppingCall;
import core.shopping.calls.GetUserProfile;

public class GetUserProfileView extends BaseShoppingView{	
	public String getUserId(){
		if (baseeBayCall == null) return null;

		return ((GetUserProfile)baseeBayCall).getUserId();
	}
	
	public String getAboutMeUrl() {
		if (baseeBayCall == null) return null;

		return ((GetUserProfile)baseeBayCall).getAboutMeUrl();
	}

	public String getFeedbackDetailsURL() {
		if (baseeBayCall == null) return null;

		return ((GetUserProfile)baseeBayCall).getFeedbackDetailsURL();
	}

}

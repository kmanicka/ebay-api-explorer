package controllers;

import core.IeBayCallContext;
import core.shopping.calls.GetSingleItem;
import core.shopping.calls.GetUserProfile;
import play.mvc.Controller;
import viewobjects.shopping.GetSingleItemView;
import viewobjects.shopping.GetUserProfileView;

public class Shopping extends Controller {

	// FindHalfProducts
	// FindProducts
	// FindReviewsAndGuides
	// GetCategoryInfo
	// GetItemStatus
	// GetMultipleItems
	// GetShippingCosts
	// GetSingleItem
	// GetUserProfile

	public static void GetSingleItem(String itemid) {
		GetSingleItemView viewObject = new GetSingleItemView();

		if (itemid != null) {
			IeBayCallContext eBayCallContext = Application.geteBayCallContext();
			GetSingleItem getSingleItem = new GetSingleItem(itemid);
			getSingleItem.calleBay(eBayCallContext);

			viewObject.setBaseApiView(getSingleItem);
		}

		render(viewObject);

	}

	public static void GetUserProfile(String username) {
		GetUserProfileView viewObject = new GetUserProfileView();

		if (username != null) {
			IeBayCallContext eBayCallContext = Application.geteBayCallContext();
			GetUserProfile getUserProfile = new GetUserProfile(username);
			getUserProfile.calleBay(eBayCallContext);

			viewObject.setBaseApiView(getUserProfile);
		}
			
		render(viewObject);

	}

}

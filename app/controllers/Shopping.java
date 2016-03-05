package controllers;

import core.IeBayCallContext;
import core.shopping.calls.GetSingleItem;
import core.shopping.calls.GetUserProfile;
import play.mvc.Controller;
import viewobjects.shopping.GetItemView;
import viewobjects.shopping.GetUserView;

public class Shopping extends Controller {
	
//	FindHalfProducts
//	FindProducts
//	FindReviewsAndGuides
//	GetCategoryInfo
//	GetItemStatus
//	GetMultipleItems
//	GetShippingCosts
//	GetSingleItem
//	GetUserProfile	

	
	public static void GetSingleItem(String itemid) {
		IeBayCallContext eBayCallContext = Application.geteBayCallContext();
		GetItemView getItemView = new GetItemView();

		if (itemid != null) {
			getItemView.itemid = itemid;
			GetSingleItem getSingleItem = new GetSingleItem(itemid);

			getSingleItem.calleBay(eBayCallContext);

			getItemView.title = getSingleItem.getTitle();

			getItemView.requestString = getSingleItem.getRequestString();
			getItemView.responseString = getSingleItem.getResponseString();
		}

		render(getItemView);
	}

	public static void GetUserProfile(String username) {
		IeBayCallContext eBayCallContext = Application.geteBayCallContext();

		GetUserView getUserView = new GetUserView();

		if (username != null) {
			getUserView.username = username;
			GetUserProfile getUserProfile = new GetUserProfile(username);

			getUserProfile.calleBay(eBayCallContext);

			getUserView.aboutMeUrl = getUserProfile.getAboutMeUrl();
			getUserView.feedbackDetailsURL = getUserProfile.getFeedbackDetailsURL();

			getUserView.requestString = getUserProfile.getRequestString();
			getUserView.responseString = getUserProfile.getResponseString();
		}

		render(getUserView);
	}
}

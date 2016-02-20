package controllers;

import core.shopping.calls.GetSingleItem;
import core.shopping.calls.GetUserProfile;
import play.mvc.Controller;
import viewobjects.shopping.GetItemView;
import viewobjects.shopping.GetUserView;

public class Shopping extends Controller {
	public static void getItem(String itemid) {
		GetItemView getItemView = new GetItemView();

		if (itemid != null) {
			getItemView.itemid = itemid;
			GetSingleItem getSingleItem = new GetSingleItem(true, itemid);

			getSingleItem.calleBay();

			getItemView.title = getSingleItem.getTitle();

			getItemView.requestString = getSingleItem.getRequestString();
			getItemView.responseString = getSingleItem.getResponseString();
		}

		render(getItemView);
	}

	public static void getUser(String username) {
		GetUserView getUserView = new GetUserView();

		if (username != null) {
			getUserView.username = username;
			GetUserProfile getUserProfile = new GetUserProfile(true, username);

			getUserProfile.calleBay();

			getUserView.aboutMeUrl = getUserProfile.getAboutMeUrl();
			getUserView.feedbackDetailsURL = getUserProfile.getFeedbackDetailsURL();

			getUserView.requestString = getUserProfile.getRequestString();
			getUserView.responseString = getUserProfile.getResponseString();
		}

		render(getUserView);
	}
}

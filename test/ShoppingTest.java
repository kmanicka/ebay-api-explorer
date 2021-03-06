import org.junit.Test;

import play.mvc.Http.Response;
import play.test.FunctionalTest;

public class ShoppingTest extends FunctionalTest{

	   @Test
	    public void testThatShoppingItemPageWorks() {
	        Response response = GET("/shopping/getsingleitem");
	        assertIsOk(response);
	        assertContentType("text/html", response);
	        assertCharset(play.Play.defaultWebEncoding, response);
	    }

	   @Test
	    public void testThatShoppingUserPageWorks() {
	        Response response = GET("/shopping/getuserprofile");
	        assertIsOk(response);
	        assertContentType("text/html", response);
	        assertCharset(play.Play.defaultWebEncoding, response);
	    }

}

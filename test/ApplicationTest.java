import org.junit.*;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;

public class ApplicationTest extends FunctionalTest {

	@Test
	public void testThatIndexPageWorks() {
		Response response = GET("/");
		assertIsOk(response);
		assertContentType("text/html", response);
		assertCharset(play.Play.defaultWebEncoding, response);
	}

	
	@Test
	public void testLoginRedirect() {
		Response response = GET("/login");

		System.out.println("ApplicationTest.testLoginRedirectTest() " + response.status);
		System.out.println("ApplicationTest.testLoginRedirectTest() " + response.headers);

		assertTrue("Assert that we got a Http Redirect",response.status.equals(302));
		
		String location = response.getHeader("Location");
		assertTrue("Assert that we got a valid Redirect Url", location != null && !"".equals(location.trim()));

		assertTrue("Assert that location has the runame", location.contains("runame"));
		assertTrue("Assert that location has the runame", location.contains("SessID"));

		Response response1 = GET(location);		
		System.out.println("ApplicationTest.testLoginRedirectTest() " + response1.status);
		System.out.println("ApplicationTest.testLoginRedirectTest() " + response1.headers);
		
		assertIsOk(response1);		
	}
	
}
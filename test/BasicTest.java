import org.junit.*;

import controllers.Application;
import core.IeBayCallContext;

import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

	@Test
	public void environment(){
		IeBayCallContext eBayCallContext= Application.geteBayCallContext();
		assertNotNull("AppName is not null", eBayCallContext.getAppName());
		assertNotNull("DevName is not null", eBayCallContext.getDevName());
		assertNotNull("CertName is not null", eBayCallContext.getCertName());
		assertNotNull("RuName is not null", eBayCallContext.getRuName());		
		assertNull("AuthToken is Null", eBayCallContext.getAuthToken());
	}
	

}

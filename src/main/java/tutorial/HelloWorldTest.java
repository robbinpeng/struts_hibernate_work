package tutorial;

import junit.framework.TestCase;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldTest extends TestCase {
	public void testHelloWorld() throws Exception {
		
		HelloWorld hello_world = new HelloWorld();
		String result = hello_world.execute();
				
		assertTrue("Excepted a success result!",
			ActionSupport.SUCCESS.equals(result));
		
	    assertTrue("Exceped the default message!",
	    	HelloWorld.MESSAGE.equals(hello_world.getMessage()));
	}
}

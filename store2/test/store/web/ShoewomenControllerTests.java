package store.web;

import org.springframework.web.servlet.ModelAndView;

import store.web.ShoewomenController;

import junit.framework.TestCase;

public class ShoewomenControllerTests extends TestCase{

	public void testHandleRequestView() throws Exception{
	  ShoewomenController controller = new ShoewomenController();
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("shoewomen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  String nowValue = (String) modelAndView.getModel().get("now");
	  assertNotNull(nowValue);
	}	
}

package store.web;

import org.springframework.web.servlet.ModelAndView;

import store.web.AccessorymenController;

import junit.framework.TestCase;

public class AccessorymenControllerTests extends TestCase{

	public void testHandleRequestView() throws Exception{
	  AccessorymenController controller = new AccessorymenController();
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("accessorymen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  String nowValue = (String) modelAndView.getModel().get("now");
	  assertNotNull(nowValue);
	}	
}

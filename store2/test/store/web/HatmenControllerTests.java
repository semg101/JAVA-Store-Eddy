package store.web;

import org.springframework.web.servlet.ModelAndView;

import store.web.HatmenController;

import junit.framework.TestCase;

public class HatmenControllerTests extends TestCase{

	public void testHandleRequestView() throws Exception{
	  HatmenController controller = new HatmenController();
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("hatmen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  String nowValue = (String) modelAndView.getModel().get("now");
	  assertNotNull(nowValue);
	}	
}

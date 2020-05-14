package store.web;

import org.springframework.web.servlet.ModelAndView;

import store.web.TrousermenController;

import junit.framework.TestCase;

public class TrousermenControllerTests extends TestCase{

	public void testHandleRequestView() throws Exception{
	  TrousermenController controller = new TrousermenController();
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("trousermen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  String nowValue = (String) modelAndView.getModel().get("now");
	  assertNotNull(nowValue);
	}	
}

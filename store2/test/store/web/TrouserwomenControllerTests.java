package store.web;

import org.springframework.web.servlet.ModelAndView;

import store.web.TrouserwomenController;

import junit.framework.TestCase;

public class TrouserwomenControllerTests extends TestCase{

	public void testHandleRequestView() throws Exception{
	  TrouserwomenController controller = new TrouserwomenController();
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("trouserwomen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  String nowValue = (String) modelAndView.getModel().get("now");
	  assertNotNull(nowValue);
	}	
}

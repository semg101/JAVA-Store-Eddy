package store.web;

import org.springframework.web.servlet.ModelAndView;

import store.web.ShoemenController;

import junit.framework.TestCase;

public class ShoemenControllerTests extends TestCase{

	public void testHandleRequestView() throws Exception{
	  ShoemenController controller = new ShoemenController();
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("shoemen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  String nowValue = (String) modelAndView.getModel().get("now");
	  assertNotNull(nowValue);
	}	
}

package store.web;

import org.springframework.web.servlet.ModelAndView;

import store.web.TeeshirtmenController;

import junit.framework.TestCase;

public class TeeshirtmenControllerTests extends TestCase{

	public void testHandleRequestView() throws Exception{
	  TeeshirtmenController controller = new TeeshirtmenController();
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("teeshirtmen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  String nowValue = (String) modelAndView.getModel().get("now");
	  assertNotNull(nowValue);
	}	
}

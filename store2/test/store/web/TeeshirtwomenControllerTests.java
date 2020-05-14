package store.web;

import org.springframework.web.servlet.ModelAndView;

import store.web.TeeshirtwomenController;

import junit.framework.TestCase;

public class TeeshirtwomenControllerTests extends TestCase{

	public void testHandleRequestView() throws Exception{
	  TeeshirtwomenController controller = new TeeshirtwomenController();
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("teeshirtwomen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  String nowValue = (String) modelAndView.getModel().get("now");
	  assertNotNull(nowValue);
	}	
}

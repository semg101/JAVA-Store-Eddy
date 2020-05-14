package store.web;

import org.springframework.web.servlet.ModelAndView;

import store.web.HatwomenController;

import junit.framework.TestCase;

public class HatwomenControllerTests extends TestCase{

	public void testHandleRequestView() throws Exception{
	  HatwomenController controller = new HatwomenController();
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("hatwomen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  String nowValue = (String) modelAndView.getModel().get("now");
	  assertNotNull(nowValue);
	}	
}

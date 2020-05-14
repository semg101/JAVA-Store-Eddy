package store.web;

import org.springframework.web.servlet.ModelAndView;

import store.web.AccessorywomenController;

import junit.framework.TestCase;

public class AccessorywomenControllerTests extends TestCase{

	public void testHandleRequestView() throws Exception{
	  AccessorywomenController controller = new AccessorywomenController();
	  ModelAndView modelAndView = controller.handleRequest(null, null);
	  assertEquals("accessorywomen", modelAndView.getViewName());
	  assertNotNull(modelAndView.getModel());
	  String nowValue = (String) modelAndView.getModel().get("now");
	  assertNotNull(nowValue);
	}	
}

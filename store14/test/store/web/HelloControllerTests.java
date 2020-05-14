package store.web;
/**
import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import junit.framework.TestCase;
import store.domain.Product;
import store.repository.InMemoryProductDao;
import store.service.SimpleProductManager;**/
import junit.framework.TestCase;
public class HelloControllerTests extends TestCase {
  
 /** @SuppressWarnings("rawtypes")
  public void testHandleRequestView() throws Exception{
    //HelloController controller = new HelloController();
    //SimpleProductManager spm = new SimpleProductManager();
    //spm.setProductDao(new InMemoryProductDao(new ArrayList<Product>()));
    //controller.setProductManager(spm);
    //controller.setProductManager(new SimpleProductManager());
    //ModelAndView modelAndView = controller.handleRequest(null, null);
    assertEquals("index_product", modelAndView.getViewName());
    assertNotNull(modelAndView.getModel());
    Map modelMap = (Map) modelAndView.getModel().get("model");
    String nowValue = (String) modelMap.get("now");
    assertNotNull(nowValue);
  }**/
}
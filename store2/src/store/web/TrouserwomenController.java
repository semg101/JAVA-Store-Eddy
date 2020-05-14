package store.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TrouserwomenController implements Controller{
  
  protected final Log logger = LogFactory.getLog(getClass());

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
		  throws ServletException, IOException {
    String now = (new Date()).toString();
	logger.info("Returning trouserwomen view with " + now);
	return new ModelAndView("trouserwomen", "now", now);
  }
}

package ch.jstollutions;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
  @EJB
  TestStatelessEjb testStatelessEjb;

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) {
    testStatelessEjb.sayHello("Stackify Reader");
  }
}
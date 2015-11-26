package ws.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for the status page.
 *
 * @see ResourceConstant
 */
@RestController
public class StatusRestController {


  /**
   * Constructor.
   *
   */
  public StatusRestController() {
  }

  /**
   * Dummy request.
   * @param name
   * @return the value.
   */
  @RequestMapping(ResourceConstant.DUMMY_STATUS)
  @ResponseBody
  public Message dummyStatus(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
    return null; //new Message(1, "P2X Management Console Service reporting for duty. " + name);
  }

}

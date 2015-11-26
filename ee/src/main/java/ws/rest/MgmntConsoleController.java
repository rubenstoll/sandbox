package ws.rest;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * dummy controller
 */

@RestController
// @RestController
// @RequestMapping("/mgmntConsole")
public class MgmntConsoleController {

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  // private EnvironmentDetails environmentDetails = new EnvironmentDetails();

  public MgmntConsoleController() {
  }

  @RequestMapping("/status")
  @ResponseBody
  public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
    model.addAttribute("name", name);
    return "P2X Management Console Service reporting for duty";
  }

  @RequestMapping(value = "/status/{name}", method = RequestMethod.GET, produces = "application/json")
  public String envStatus(@PathVariable String name) {

    // environmentDetails.setOsName(name);
    // environmentDetails.setOsVersion("11.1");
    return null;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String hello(ModelMap model) {

    model.addAttribute("name", "P2X Management Console Service reporting for duty");
    // model.addAttribute("name", "JCG Hello World!");
    // return "mgmntConsole";
    return "P2X Management Console Service reporting for duty";

  }

  @RequestMapping("/hello/{player}")
  public Message message(@PathVariable String player) {

    Message msg = new Message(player, "Hello " + player);
    return msg;
  }

}

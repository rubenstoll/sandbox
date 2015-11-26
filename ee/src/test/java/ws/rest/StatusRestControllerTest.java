package ws.rest;

import static junit.framework.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test for the status rest services.
 */
public class StatusRestControllerTest extends AbstractRestControllerTest {

  /**
   * Test the dummy Rest.
   * @throws Exception
   */
  @Test
  public void testDummyStatus() throws Exception {
    String expectedMsg = "P2X Management Console Service reporting for duty. World";
    MvcResult result = getMockMvc().perform(get(ResourceConstant.DUMMY_STATUS).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();

    DummyStatusTO statusTO = new ObjectMapper().readValue(result.getResponse().getContentAsString(), DummyStatusTO.class);
    assertEquals(statusTO.getStatusCode(), new Integer(1));
    assertEquals(statusTO.getMessage(), expectedMsg);

    result = getMockMvc().perform(get(ResourceConstant.DUMMY_STATUS + "?name=trala").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
    expectedMsg = "P2X Management Console Service reporting for duty. trala";
    statusTO = new ObjectMapper().readValue(result.getResponse().getContentAsString(), DummyStatusTO.class);
    assertEquals(statusTO.getMessage(), expectedMsg);
  }
}
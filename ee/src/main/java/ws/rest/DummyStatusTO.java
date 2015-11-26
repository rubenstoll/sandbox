package ws.rest;

/**
 *
 */
public class DummyStatusTO {

  private Integer statusCode;
  private String message;

  /**
   * Default Constructor.
   */
  public DummyStatusTO() {
  }

  /**
   * Constructor.
   *
   * @param statusCode
   * @param message
   */
  public DummyStatusTO(Integer statusCode, String message) {
    this.statusCode = statusCode;
    this.message = message;
  }

  /**
   * @return the code.
   */
  public Integer getStatusCode() {
    return statusCode;
  }

  /**
   * @param statusCode
   */
  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  /**
   * @return the message.
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message
   */
  public void setMessage(String message) {
    this.message = message;
  }
}

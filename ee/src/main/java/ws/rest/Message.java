package ws.rest;

/**
 * Created by tk3sy on 25.11.2015.
 */
public class Message {

  String name;
  String text;

  public Message(String name, String text) {
    this.name = name;
    this.text = text;
  }

  public String getName() {
    return name;
  }

  public String getText() {
    return text;
  }
}

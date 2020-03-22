package ch.jstollutions;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/TestQueue")
public class TestMessageDrivenBean implements MessageListener {
  @Resource
  MessageDrivenContext messageDrivenContext;

  public void onMessage(Message message) {
    try {
      if (message instanceof TextMessage) {
        TextMessage msg = (TextMessage) message;
        msg.getText();
      }
    } catch (JMSException e) {
      messageDrivenContext.setRollbackOnly();
    }
  }
}
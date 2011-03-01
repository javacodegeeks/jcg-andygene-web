#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.jms;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("myQueueSender")
public class MyQueueSender {
	
	private Logger log = LoggerFactory.getLogger(MyQueueSender.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(final String myMessage) {
		MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session)
	            {
	                TextMessage message = null;
	                try 
	                {
	                    message = session.createTextMessage();
	                    message.setText(myMessage);
	                }
	                catch (JMSException e)
	                {
	                    log.error("Error Sending Message",e);
	                }
	                return message;
	        }


		};
		jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
		jmsTemplate.send("myDestination", messageCreator);
		log.info("Message Send");
	}

}

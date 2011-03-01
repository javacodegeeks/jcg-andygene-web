#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class MyQueueListener {
	private Logger log = LoggerFactory.getLogger(MyQueueListener.class);
	
    public void onMessage(Object message) {
    	log.info("JMS message received: {}" , message);
    }
}

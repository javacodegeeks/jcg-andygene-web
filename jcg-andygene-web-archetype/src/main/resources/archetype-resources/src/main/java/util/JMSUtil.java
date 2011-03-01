#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import javax.validation.constraints.Pattern;

public class JMSUtil {
	@Pattern(regexp = ".+", message = "Message must not be empty!")
	private String message;
	
	private String reply;
	
	public JMSUtil() {
		
	}

	public JMSUtil(String message,String reply) {
		super();
		this.message = message;
		this.reply = reply;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
	
	
	

}

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

public class FormatUtil {
	private String format;
	
	public FormatUtil() {
		
	}

	public FormatUtil(String format) {
		super();
		this.format = format;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	
}

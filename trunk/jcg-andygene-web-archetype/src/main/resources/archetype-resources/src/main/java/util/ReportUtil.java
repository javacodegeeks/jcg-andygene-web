#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ReportUtil {
	@NotNull
	@Min(1)  
	private Long number;
	
	public ReportUtil() {
		
	}

	public ReportUtil(Long number) {
		super();
		this.number = number;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	
	

}

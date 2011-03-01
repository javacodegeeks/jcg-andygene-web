#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.drools;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

public class MyDomain implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Pattern(regexp = ".+", message = "Name must not be empty!")
	private String name;
	@Pattern(regexp = ".+", message = "Last Name must not be empty!")
	private String lastName;
	private String description;
	
	public MyDomain() {
		
	}

	public MyDomain(String name, String lastName, String description) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return "MyDomain [name=" + name + ", lastName=" + lastName
				+ ", description=" + description + "]";
	}
	
	

}

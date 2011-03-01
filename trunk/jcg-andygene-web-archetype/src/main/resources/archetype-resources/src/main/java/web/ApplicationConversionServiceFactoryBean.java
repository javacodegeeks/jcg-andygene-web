#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web;


import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import ${package}.domain.MyEntity;



public class ApplicationConversionServiceFactoryBean extends
		FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);

	}

	Converter<MyEntity, String> getMyEntityConverter() {
		return new Converter<MyEntity, String>() {
			public String convert(MyEntity source) {
				return new StringBuilder().append(source.getName()).toString();
			}
		};
	}

	public void installLabelConverters(FormatterRegistry registry) {
		registry.addConverter(getMyEntityConverter());
	}

	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		installLabelConverters(getObject());
	}

}

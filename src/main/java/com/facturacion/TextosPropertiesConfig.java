package com.facturacion;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	
	@PropertySource("classpath:texto.properties")
})
public class TextosPropertiesConfig {

}

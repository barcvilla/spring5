package com.bolsadeideas.springboot.app;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
		
		/*Construimos la ruta abosulta desde C:// hasta la carpeta uploads en la raiz del proyecto. Le 
		 *  adiciona el uri (file:/) */
		String resourcePath = Paths.get("uploads").toAbsolutePath().toString().toString();
		
		registry.addResourceHandler("/uploads/**")
		.addResourceLocations("resourcePath");
	}
	
	
}

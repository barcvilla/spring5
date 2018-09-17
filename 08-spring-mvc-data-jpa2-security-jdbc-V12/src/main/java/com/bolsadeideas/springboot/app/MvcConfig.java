package com.bolsadeideas.springboot.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase donde configuramos los recursos estaticos
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	/**
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
		
		//Construimos la ruta abosulta desde C:// hasta la carpeta uploads en la raiz del proyecto. Le 
		//adiciona el uri (file:/)
		String resourcePath = Paths.get("uploads").toAbsolutePath().toString().toString();
		
		registry.addResourceHandler("/uploads/**")
		.addResourceLocations("resourcePath");
	}
	*/
	
	/**
	 * Implementacion de un controlador Parametrizable ViewController que carge la vista
	 * Metodo que registra el controlador de vista
	 */
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/error_403").setViewName("error_403");;
	}
	
	
}

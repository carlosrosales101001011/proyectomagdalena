package com.proyectomagdalena;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProductoimgConfig implements WebMvcConfigurer {
	@Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
	       WebMvcConfigurer.super.addResourceHandlers(registry);
	       
	       registry.addResourceHandler("/recursos**").addResourceLocations("file:/D:/Producto/recursos");
		} 
}

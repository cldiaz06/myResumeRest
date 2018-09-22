package com.cldiaz.myResumeRest.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@ComponentScan("com.cldiaz.myResumeRest")
public class WebAppConfig implements WebMvcConfigurer{
	
//	@Override
//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		configurer
//				.defaultContentType(MediaType.APPLICATION_JSON)
//				.favorPathExtension(true);
//	}
//	
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		
		resolver.setContentNegotiationManager(manager);
		
		List<ViewResolver> resolvers = new ArrayList<>();
		
		//resolvers.add(pdfViewResolver());
		resolvers.add(jspViewResolver());
		
		resolver.setViewResolvers(resolvers);
		return resolver;
	}
	
//	@Bean
//	public ViewResolver pdfViewResolver() {
//		return new ViewResolver;//PdfViewResolver();
//	}
//	

	
	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
}

//package com.cldiaz.myResumeRest.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//
//import com.cldiaz.myResumeRest.dataImport.JsonGetResume;
//import com.cldiaz.myResumeRest.dataImport.XmlGetResume;
//import com.cldiaz.myResumeRest.interfaces.GetResume;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan("com.cldiaz.myResumeRest")
//public class WebAppConfig implements WebMvcConfigurer{
//	
//	@Autowired
//	private ApplicationContext applicationContext;
//	
//	@Bean
//	public SpringResourceTemplateResolver templateResolver() {
//		
//		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//		templateResolver.setApplicationContext(applicationContext);
//		templateResolver.setPrefix("/WEB-INF/views/html/");
//		//templateResolver.setPrefix("/templates/html/");
//		templateResolver.setSuffix(".html");
//		return templateResolver;
//		
//	}
//	
//	@Bean
//	public SpringTemplateEngine templateEngine() {
//		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.setTemplateResolver(templateResolver());
//		templateEngine.setEnableSpringELCompiler(true);
//		return templateEngine;
//	}
//	
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//		resolver.setTemplateEngine(templateEngine());
//		registry.viewResolver(resolver);
//	}
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/webjars/**")
//				.addResourceLocations("classpath:/META-INF/resources/webjars/");
//	}
//	
//}

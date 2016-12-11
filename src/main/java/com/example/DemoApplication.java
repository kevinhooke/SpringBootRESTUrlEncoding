package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UrlPathHelper;

/**
 * Spring Boot app configured with a custom PathcMatchConfigurer to support
 * HTTP requests with URL Encoded values in the path.
 * 
 * @author kev
 *
 */
@SpringBootApplication(scanBasePackages = "com.example.rest")
public class DemoApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		
		/*
		 * Without this system property, running as a standalone app with the embedded
		 * Tomcat does not support %3f encoded '/' chararacters (appears to silently
		 * fail wihtout passing requests through to controller
		 */
		System.setProperty("org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH", "true");
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * Overriding configurePathMatch() allows support for values in URL
	 * using %2f encoding for '/'. Without this by default you get a 404
	 * as the Request Mappings fail to match.
	 */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setUrlDecode(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
}

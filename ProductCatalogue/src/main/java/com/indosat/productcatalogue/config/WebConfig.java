package com.indosat.productcatalogue.config;

import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@ComponentScan("com.indosat.productcatalogue")
@EnableSwagger2
public class WebConfig extends WebMvcConfigurerAdapter
{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) 
    {
        registry.addResourceHandler("swagger-ui.html")
          .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
          .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public Logger loggger()
    {
    	Logger logger = null;
    	FileHandler fileHandler = null;
    	try
    	{
    		fileHandler = new FileHandler("file path", true);
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	SimpleFormatter fmt = new SimpleFormatter()	
    	{
    		@Override
    		public String format(LogRecord record)
    		{
    			StringBuilder sb = new StringBuilder(1000);
    			LocalDateTime now = LocalDateTime.now();
    			String s = now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth() + " " + now.getHour() + ":" + now.getMinute() + ":" + now.getSecond() + "|" + record.getMessage() + "\n";
    			sb.append(s);
    			return sb.toString();
    		}
    	};
	handler.setFormatter(formatter);
	logger = Logger.getLogger("productcatalogue.ProductCatalogue");
	logger.addHandler(handler);
    	return logger;
    }
}

package edu.mvc.config;

import edu.mvc.ambiguousBeansExample.AmbiguousBeansScanMarker;
import edu.mvc.ambiguousBeansExample.beans.Cookies;
import edu.mvc.ambiguousBeansExample.beans.Dessert;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration  //Configuring ambiguous beans to show how to handle those cases
@ComponentScan(basePackageClasses = AmbiguousBeansScanMarker.class)
@PropertySource("classpath:example.properties")
public class AmbiguousBeansConfig {

    private final Logger logger;

    @Autowired
    public AmbiguousBeansConfig(Logger logger) {
        this.logger = logger;
    }

    @Bean //Value -> 1. @Resource + PropertyResolver or Environment object
    public Dessert cookies(@Value("${cookie.name}") String cookieName) {
        logger.info("Property found : " + cookieName);
        return new Cookies(cookieName);
    }

    @Bean //Obtaining class bean from Math class using Spring expression language
    public Class mathBean(@Value("#{T(java.lang.Math)}") Class clazz) throws Exception{
        double e = clazz.getField("E").getDouble(null);
        logger.info("Value obtained  : " + e);
        return clazz;
    }
}

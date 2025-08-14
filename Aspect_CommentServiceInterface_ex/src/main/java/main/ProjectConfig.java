package main;

import aop.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "main, service, aop")
@EnableAspectJAutoProxy
public class ProjectConfig {
    // Auto Di

    @Bean
    LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}

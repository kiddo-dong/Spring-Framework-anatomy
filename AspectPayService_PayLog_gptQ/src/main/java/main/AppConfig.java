package main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "main, service, aspect")
@EnableAspectJAutoProxy
public class AppConfig {
    // Auto DI
}

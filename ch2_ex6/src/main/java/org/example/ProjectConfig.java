package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "org.example")// main 디렉토리에 해당하는 모든 @Component를 읽어옴
public class ProjectConfig {

}

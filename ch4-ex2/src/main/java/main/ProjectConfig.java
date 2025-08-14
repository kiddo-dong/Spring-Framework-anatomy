package main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "proxy, repository, service")
public class ProjectConfig {
    //Componet 사용으로 Scan만 하면 자동 객체 생성이 이루어짐


}

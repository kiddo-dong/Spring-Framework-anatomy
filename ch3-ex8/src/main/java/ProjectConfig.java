import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    @Primary // Primary 지정으로 기본으로 설정
    public Parrot parrot1(){
        Parrot p = new Parrot();
        p.setName("kiki-1");
        return p;
    }

    @Bean
    public Parrot parrot2(){
        Parrot p = new Parrot();
        p.setName("mimi-2");
        return p;
    }

    @Bean
    public Parrot parrot3(){
        Parrot p = new Parrot();
        p.setName("ella-3");
        return p;
    }

    /*
    @Bean
    public Person person(@Qualifier("parrot2") Parrot parrot) { //Qualifire로 parrot2 Bean DI
        Person p = new Person();
        p.setName("dh");
        p.setParrot(parrot);
        return p;

    }
    */

    @Bean
    public Person person(Parrot parrot) {
        Person p = new Person();
        p.setName("dh");
        p.setParrot(parrot);
        return p;
    }

}

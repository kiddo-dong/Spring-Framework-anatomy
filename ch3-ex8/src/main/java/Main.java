import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // BeanList
        String BeanList[] = context.getBeanDefinitionNames();
        for(String name : BeanList){
            System.out.println(name);
        }

        Person person = context.getBean(Person.class);
        System.out.println(person.getParrot().getName());


    }
}

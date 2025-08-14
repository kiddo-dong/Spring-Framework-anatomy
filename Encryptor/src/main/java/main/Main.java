package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.EncryptionInterface;
import service.EncryptionService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        EncryptionService encryptionService = context.getBean(EncryptionService.class);

        encryptionService.encryptData("aes", "aes 암호 맞음");
        encryptionService.encryptData("sha", "sha 암호 맞음");
        encryptionService.encryptData("sdasdasd", "adaadadadas");
    }
}
package service;

import org.springframework.stereotype.Component;

@Component("sha")
public class ShaCryptService implements EncryptionInterface{
    @Override
    public void crypto(String data) {
        System.out.println("SHA : " + data);
    }
}

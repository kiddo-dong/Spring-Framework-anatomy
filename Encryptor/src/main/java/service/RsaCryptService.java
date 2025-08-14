package service;

import org.springframework.stereotype.Component;

@Component("rsa")
public class RsaCryptService implements EncryptionInterface{
    @Override
    public void crypto(String data) {
        System.out.println("RSA : " + data);
    }
}

package service;

import org.springframework.stereotype.Component;

@Component("aes")
public class AesCryptService implements EncryptionInterface{
    @Override
    public void crypto(String data) {
        System.out.println("AES : " + data);
    }
}

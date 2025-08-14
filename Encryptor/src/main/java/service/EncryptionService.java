package service;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EncryptionService {
    private final Map<String, EncryptionInterface> encryptionInterfaceMap;

    public EncryptionService(Map<String, EncryptionInterface> encryptionInterfaceMap) {
        this.encryptionInterfaceMap = encryptionInterfaceMap;
    }

    public void encryptData(String type, String data){
        EncryptionInterface encryptionInterface = encryptionInterfaceMap.get(type);
        if (encryptionInterface != null){
            encryptionInterface.crypto(data);
        } else {
            System.out.println("잘못된 암호화");
        }
    }
}

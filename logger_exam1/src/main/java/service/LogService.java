package service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LogService {
    private final Map<String, LogLevel> logLevelMap;

    public LogService(Map<String, LogLevel> logLevelMap) {
        this.logLevelMap = logLevelMap;
    }
    
    public void logPrint(String type){
        LogService logService = logLevelMap.get(type).logLevel();
    }
}

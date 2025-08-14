package service;

import io.micrometer.common.util.internal.logging.Slf4JLoggerFactory;

import java.util.logging.Logger;

public class TraceLogger implements LogLevel{
    private static final Logger logger = System.LoggerFinder.getLoggerFinder()

    @Override
    public void logLevel() {
        logger.trace(){

        }
    }
}

package com.todo.mapper;

import com.todo.log.LoggingService;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author caoxin
 */
public class LoggerTest extends TestCase {

    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    public LoggerTest(String name) {
        super(name);
    }

     @Override
    protected void setUp() throws Exception {
        super.setUp();
        LoggingService loggingService = new LoggingService();
        loggingService.setLoggerConfigFile("web/WEB-INF/config/log4j.xml");
        loggingService.init();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testLogger() {
        logger.error("If this sentence save the file console");
    }
}
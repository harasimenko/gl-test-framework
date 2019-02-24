package src.test.java.tests;

import src.test.java.commonLibs.configReaders.EnvironmentConfigReader;

import java.io.IOException;
import java.util.logging.Logger;

abstract class BaseTest {
    protected static final Logger log = Logger.getLogger("my.logger");
    private String envName = System.getProperty("env");
    protected EnvironmentConfigReader configReader;

    {
        try {
            configReader = new EnvironmentConfigReader(envName);
        } catch (IOException e) {
            log.info(String.format("Cannot read properties for '%s' environment", envName));
        }
    }
}

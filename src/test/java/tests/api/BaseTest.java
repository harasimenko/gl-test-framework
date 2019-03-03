package tests.api;

import com.github.javafaker.Faker;
import commonLibs.configReaders.EnvironmentConfigReader;

import java.io.IOException;
import java.util.logging.Logger;

public class BaseTest {
    Faker faker = new Faker();
    public static final Logger log = Logger.getLogger("my.logger");
    private String envName = System.getProperty("env");
    public static EnvironmentConfigReader configReader;

    {
        try {
            if (envName != null) {
                configReader = new EnvironmentConfigReader(envName);
            } else
                configReader = new EnvironmentConfigReader("Dev");
        } catch (IOException e) {
            log.info(String.format("Cannot read properties for '%s' environment", envName));
        }
    }
}

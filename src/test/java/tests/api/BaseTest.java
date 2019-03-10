package tests.api;

import com.github.javafaker.Faker;
import commonLibs.configReaders.EnvironmentConfigReader;
import listeners.BaseListener;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.util.logging.Logger;

@Listeners(BaseListener.class)
public class BaseTest {
    Faker faker = new Faker();
    public static final Logger log = Logger.getLogger("my.logger");

    public static EnvironmentConfigReader configReader;

    static {
        try {
            configReader = new EnvironmentConfigReader();
        } catch (IOException e) {
            log.info("Cannot read properties for the environment");
        }
    }
}

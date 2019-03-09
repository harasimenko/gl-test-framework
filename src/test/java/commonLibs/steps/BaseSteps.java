package commonLibs.steps;

import com.github.javafaker.Faker;
import commonLibs.configReaders.EnvironmentConfigReader;

import java.io.IOException;

public abstract class BaseSteps {
    public static Faker faker;

    public BaseSteps() {
        faker = new Faker();
    }

    EnvironmentConfigReader configReader;

    {
        try {
            configReader = new EnvironmentConfigReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

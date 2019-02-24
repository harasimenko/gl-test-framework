package src.test.java.commonLibs.configReaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentConfigReader {

    private Properties appProps;

    public String getAppUrl() {
        return appProps.getProperty("url");
    }

    public EnvironmentConfigReader(String environment) throws IOException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        String appConfigPath;

        if (environment != null) {
            appConfigPath = rootPath +
                    String.format("src/main/java/resources/configs/%s_env.properties", environment);
        } else {
            appConfigPath = rootPath + "src/main/java/resources/configs/Dev_env.properties";
        }

        appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));
    }
}
package commonLibs.configReaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentConfigReader {
    private Properties appProps;

    public String getAppUrl() {
        return appProps.getProperty("app.url");
    }

    public String getPostsUrl() {
        return appProps.getProperty("posts.url");
    }

    public EnvironmentConfigReader() throws IOException {
        String envName = System.getProperty("env");
        String environment;
        if (envName != null) {
            environment = envName;
        } else {
            environment = "Dev";
        }

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        String appConfigPath;

        appConfigPath = rootPath +
                String.format("src/main/java/resources/configs/%s_env.properties", environment);

        appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));
    }
}
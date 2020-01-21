package helper;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class LoadConfigFile {

    private static LoadConfigFile loadConfig;
    private Config conf;

    private LoadConfigFile() {
        conf = ConfigFactory.load("application.conf");
    }

    public static LoadConfigFile getInstance() {
        if (loadConfig == null) {
            return new LoadConfigFile();
        }
        return loadConfig;
    }

    public String getProperty(String key) {
        String chosenEnv = System.getProperty("env");
        if (chosenEnv == null) {
            chosenEnv = "qa";
        }
        Config env = conf.getConfig(chosenEnv);
        return env.getString(key);
    }
}

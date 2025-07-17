package com.properties_api.properties;

import com.constants.Constants;
import com.report.ExtentFactory;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoadeer_api {
    private Logger logger = LogManager.getLogger(ConfigLoadeer_api.class);

    @Getter
    private static ConfigLoadeer_api instance;

    static {
        try {
            instance = new ConfigLoadeer_api();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Properties prop;

    private ConfigLoadeer_api() throws IOException {
        FileReader reader =null;

        try{
            reader = new FileReader(Constants.CONFIG_FILE_PATH_API);

        } catch (FileNotFoundException e) {
           logger.error("Execption occured while reading file from config");
            ExtentFactory.failTest("Execption occured while reading file from config");
        }

       prop = new Properties();

        try{
            prop.load(reader);
        } catch (IOException e) {
           e.printStackTrace();
        }

        Constants.EXECUTION_ENV_API = getPropertyValue("environment_api");
    }

    public String getPropertyValue(String key){
        return prop.getProperty(key);
    }

}

package com.properties_api.properties;

import com.constants.Constants;
import com.report.ExtentFactory;
import lombok.Getter;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataLoader_api {

    private static Properties prop;

    private TestDataLoader_api() throws IOException {
        ConfigLoadeer_api.getInstance();
        String env = Constants.EXECUTION_ENV_API;

        System.out.println(env);

        String filePath;

        switch (env.toLowerCase()) {
            case "test":
                filePath = Constants.TEST_ENV_QA_DATA_FILE;
                break;
            case "uat":
                filePath = Constants.TEST_ENV_UAT_DATA_FILE;
                break;
            case "api_uat":
                filePath = Constants.TEST_ENV_UAT_API_DATA_FILE;
                break;
            default:
                throw new IllegalArgumentException("Unknown environment: " + env);
        }

        System.out.println("Loading properties for environment: " + env);
        System.out.println("Using file: " + filePath);

        loadFile(filePath);
    }

    @Getter
    private static TestDataLoader_api instance;

    static {
        try {
            instance = new TestDataLoader_api();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize TestDataLoader: " + e.getMessage(), e);
        }
    }

    private static void loadFile(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            prop = new Properties();
            prop.load(reader);
        } catch (IOException e) {
            ExtentFactory.failTest("Exception occurred while reading test data file: " + e.getMessage());
            throw e; // Rethrow to ensure the loader fails
        }
    }

    private String getPropertyValue(String key) {
        return prop.getProperty(key);
    }

    public String getAppUrl() {
        return getPropertyValue("app_url");
    }

    public String getUsername() {
        return getPropertyValue("username");
    }

    public String getPassword() {
        return getPropertyValue("password");
    }

    public String getAPI_username() {
        return getPropertyValue("API_username");
    }

    public String getAPI_password() {
        return getPropertyValue("API_password");
    }

    public String getAPI_URI() {
        return getPropertyValue("baseURI");
    }
}

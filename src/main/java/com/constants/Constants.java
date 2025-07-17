package com.constants;

public class Constants {

    public static final String CURRENT_DIR = System.getProperty("user.dir");

    public static final String EXECUTION_REPORT_PATH=".//reports";
    public static final int EXPLICIT_WAIT_TIME=30;
    public static final int IMPLICIT_WAIT_TIME=30;

    public static final String CONFIG_FILE_PATH=CURRENT_DIR+"/src/test/resources/execution/config.properties";
    public static final String CONFIG_FILE_PATH_API=CURRENT_DIR+"/src/test/resources/execution/config_api.properties";

    public static String EXECUTION_ENV;
    public static String EXECUTION_ENV_API;

    public static final String TEST_ENV_QA_DATA_FILE=CURRENT_DIR+"/src/test/resources/testData/test_qa_data.properties";
    public static final String TEST_ENV_UAT_DATA_FILE=CURRENT_DIR+"/src/test/resources/testData/test_UAT_data.properties";
    public static final String TEST_ENV_UAT_API_DATA_FILE=CURRENT_DIR+"/src/test/resources/testData/test_data_API.properties";

}

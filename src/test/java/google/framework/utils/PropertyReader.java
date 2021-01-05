package google.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public final static String BACKSLASH = "\\\\";
    public final static String SLASH = "/";

    private static final String COMMON_PATH = StringUtil
            .replaceWithRegExp(System.getProperty("user.dir"), BACKSLASH, SLASH);
    private static final String CONFIG_PATH = "/src/test/resources/config.properties";
    private static final String WAITER_CONSTANTS_PATH = "/src/test/resources/waiterConstants.properties";

    private static Properties loadProperties(String filePath) {
        Properties properties = null;
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            LogUtil.error("File read error.");
        }
        return properties;
    }

    public static String getConfigValue(String key) {
        LogUtil.info(String.format("Reading configuration data - \"%s\".",key));
        return loadProperties(COMMON_PATH.concat(CONFIG_PATH)).getProperty(key);
    }

    public static String getWaiterConstant(String key) {
        LogUtil.info(String.format("Reading test data - \"%s\".", key));
        return loadProperties(COMMON_PATH.concat(WAITER_CONSTANTS_PATH)).getProperty(key);
    }
}

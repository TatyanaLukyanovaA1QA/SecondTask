package google.framework.utils;

import org.apache.log4j.Logger;

public class LogUtil {
    private static final Logger LOGGER = Logger.getLogger(LogUtil.class.getName());

    public static void step(int number, String massage){
        LOGGER.info(String.format("Step number %s : ",number, massage));
    }

    public static void info(String massage){
        LOGGER.info(massage);
    }

    public static void error(String massage){
        LOGGER.error(massage);
    }
}

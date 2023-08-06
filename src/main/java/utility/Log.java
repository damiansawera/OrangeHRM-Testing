package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    public static Logger logger = LogManager.getLogger(Log.class.getName());

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message) {
        logger.error(message);
    }
    public static void startTestCase(String testCaseName) {
        logger.info("======== Start Test Case: " + testCaseName + " ========");
    }

    public static void endTestCase(String testCaseName) {
        logger.info("======== End Test Case: " + testCaseName + " ========");
    }
}

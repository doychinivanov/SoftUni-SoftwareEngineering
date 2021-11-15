package logger;

import logger.appenders.ConsoleAppender;
import logger.appenders.FileAppender;
import logger.appenders.LogFile;
import logger.impl.MessageLogger;
import logger.impl.SimpleLayout;
import logger.interfaces.Appender;
import logger.interfaces.File;
import logger.interfaces.Layout;
import logger.interfaces.Logger;

public class Main {
    public static void main(String[] args) {
//        Layout simpleLayout = new SimpleLayout();
//        Appender consoleAppender = new ConsoleAppender(simpleLayout);
//        Logger logger = new MessageLogger(consoleAppender);
//
//        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
//        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);

        File file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);

        Logger logger = new MessageLogger(consoleAppender, fileAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");


    }
}

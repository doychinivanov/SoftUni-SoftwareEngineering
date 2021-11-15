package logger.appenders;

import logger.interfaces.Appender;
import logger.interfaces.Layout;

public abstract class BaseAppender implements Appender {
    Layout layout;

    public BaseAppender(Layout layout){
        this.layout = layout;
    }
}

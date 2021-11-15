package logger.impl;

import logger.enums.ReportLevel;
import logger.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s", time, reportLevel, message);
    }
}

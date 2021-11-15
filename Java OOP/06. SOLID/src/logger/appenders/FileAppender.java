package logger.appenders;

import logger.enums.ReportLevel;
import logger.interfaces.File;
import logger.interfaces.Layout;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, String fileName) {
        this(layout);
        this.file = new LogFile(fileName);
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        String output = this.layout.format(time, message, reportLevel);

        file.append(output);
    }

    public void setFile(File file) {
        this.file = file;
    }
}

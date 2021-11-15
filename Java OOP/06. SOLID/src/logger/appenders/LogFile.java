package logger.appenders;

import logger.interfaces.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogFile implements File {
    private static final String DEFAULT_FILE_NAME = "default.txt";

    private final StringBuilder text;
    private final int size;
    private final String fileName;

    public LogFile(){
        this(DEFAULT_FILE_NAME);
    }

    public LogFile(String fileName){
        this.text = new StringBuilder();
        this.size = 0;
        this.fileName = fileName;
    }

    @Override
    public int getSize() {
        return calculateSize(size);
    }

    @Override
    public boolean write(String text) {
        try{
            Files.write(Paths.get(this.fileName), text.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void append(String text) {
        text = makeTextPretty(text);
        this.text.append(text);
        this.write(text);
    }

    private int calculateSize(int size) {
        for(char c : this.text.toString().toCharArray()){
            if(Character.isAlphabetic(c)){
                size += c;
            }
        }
        return size;
    }

    private String makeTextPretty(String text) {
        StringBuilder result = new StringBuilder(text);
        result.append(System.lineSeparator());

        return result.toString();
    }
}

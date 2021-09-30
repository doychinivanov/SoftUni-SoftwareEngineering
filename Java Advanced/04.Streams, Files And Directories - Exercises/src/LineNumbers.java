import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        String readPath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\inputLineNumbers.txt";
        String writePath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\line-numbers.txt";

        try {
            BufferedReader readFs = new BufferedReader(new FileReader(readPath));
            BufferedWriter writeFs = new BufferedWriter(new FileWriter(writePath));

            int currentLineCount = 1;
            String currentLine = readFs.readLine();

            while(currentLine != null){

                writeFs.write(String.format("%d. %s" + System.lineSeparator(), currentLineCount, currentLine));

                currentLineCount++;
                currentLine = readFs.readLine();
            }

            writeFs.flush();
            writeFs.close();
            readFs.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

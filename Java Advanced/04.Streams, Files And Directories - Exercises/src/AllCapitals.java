import java.io.*;
import java.util.Locale;

public class AllCapitals {
    public static void main(String[] args) {
        String readPath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\input.txt";
        String writePath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\capitals.txt";

        try{
            BufferedReader readFs = new BufferedReader(new FileReader(readPath));
            BufferedWriter writeFs = new BufferedWriter(new FileWriter(writePath));

            String currentLine = readFs.readLine();

            while(currentLine != null){

                writeFs.write(currentLine.toUpperCase(Locale.ROOT) + System.lineSeparator());

                currentLine = readFs.readLine();
            }

            writeFs.flush();
            writeFs.close();
            readFs.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String readPath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\inputOne.txt";
        String secondReadPath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\inputTwo.txt";
        String mergedFile = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\merged.txt";

        List<String> content = new ArrayList<>();

        extractContent(content, readPath);
        extractContent(content, secondReadPath);

        try{
            BufferedWriter writeFs = new BufferedWriter(new FileWriter(mergedFile));

            writeFs.write(String.join(System.lineSeparator(), content));
            writeFs.flush();
            writeFs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extractContent(List<String> content, String path) {
        try{
            BufferedReader readFs = new BufferedReader(new FileReader(path));

            String currentLine = readFs.readLine();

            while(currentLine != null){
                content.add(currentLine);

                currentLine = readFs.readLine();
            }

            readFs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

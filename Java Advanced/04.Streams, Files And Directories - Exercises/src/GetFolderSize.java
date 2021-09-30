import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Path;

public class GetFolderSize {
    public static void main(String[] args) throws FileNotFoundException {
        String writePath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\folder-size.txt";
        Path folderPath = Path.of("D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\Exercises Resources");

        File folder = new File(String.valueOf(folderPath));

        int size = 0;
        File[] allFiles = folder.listFiles();

        for (File file: allFiles) {
            size += file.length();
        }

        PrintStream writeFs = new PrintStream(writePath);
        writeFs.println(String.format("Folder size: %d", size));

        writeFs.close();
    }
}

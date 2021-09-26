import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        BufferedWriter writeFs = new BufferedWriter(new FileWriter("D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\files.txt"));

        Path path = Path.of("D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\Files-and-Streams");
        File folder = new File(String.valueOf(path));

        File[] files = folder.listFiles();

        for (File file: files) {
            if(!file.isDirectory()){
                writeFs.write(String.format("%s: [%s]" + System.lineSeparator(), file.getName(), file.length()));
            }
        }

        writeFs.flush();
        writeFs.close();
    }
}

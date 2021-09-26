import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\input.txt";

        String writePath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\sorted-lines.txt";

        BufferedWriter writeFs = new BufferedWriter(new FileWriter(writePath));

        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);

        Collections.sort(lines);

        writeFs.write(String.join(System.lineSeparator(), lines));

        writeFs.flush();
        writeFs.close();
    }
}

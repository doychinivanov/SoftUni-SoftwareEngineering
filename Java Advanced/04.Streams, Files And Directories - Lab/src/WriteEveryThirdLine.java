import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\input.txt";

        String writePath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\3thlines.txt";

        PrintStream writeFs = new PrintStream(writePath);

        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);

        for (int i = 0; i < lines.size(); i++) {
            if(( i + 1) % 3 == 0){
                writeFs.println(lines.get(i));
            }
        }

    }
}

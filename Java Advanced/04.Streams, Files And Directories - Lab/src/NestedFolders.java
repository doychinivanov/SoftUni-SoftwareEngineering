import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NestedFolders {
    public static void main(String[] args) throws IOException {
        BufferedWriter writeFs = new BufferedWriter(new FileWriter("D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\folders-list.txt"));
        File file = new File("D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\Files-and-Streams");

        ArrayDeque<File> files = new ArrayDeque<>();
        List<String> folderList = new ArrayList<>();

        files.offer(file);

        while(!files.isEmpty()){
            File innerFile = files.poll();

            for (File f: Objects.requireNonNull(innerFile.listFiles())) {
                if(f.isDirectory()){
                    files.offer(f);
                }
            }

            folderList.add(innerFile.getName());
        }

        writeFs.write(String.join(System.lineSeparator(), folderList));
        writeFs.write(String.format("\n%d folders", folderList.size()));
        writeFs.flush();
        writeFs.close();
    }
}

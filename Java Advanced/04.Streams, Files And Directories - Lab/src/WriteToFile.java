import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class WriteToFile {
    public static void main(String[] args) throws FileNotFoundException {
        String readPath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\input.txt";

        String writePath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\output.txt";

        HashSet<Character> punctuation = new HashSet<>(Arrays.asList(',', '.', '!', '?'));

        try{
            FileInputStream readFs = new FileInputStream(readPath);
            FileOutputStream writeFs = new FileOutputStream(writePath);

            int oneByte = readFs.read();

            while(oneByte != -1){
                if(!punctuation.contains((char) oneByte)){
                    writeFs.write(oneByte);
                }

                oneByte = readFs.read();
            }

            readFs.close();
            writeFs.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

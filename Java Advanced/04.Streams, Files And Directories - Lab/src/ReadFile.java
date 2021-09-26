import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\input.txt";

        try{
            FileInputStream fs = new FileInputStream(path);
            int oneByte = fs.read();

            while(oneByte != -1){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));

                oneByte = fs.read();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

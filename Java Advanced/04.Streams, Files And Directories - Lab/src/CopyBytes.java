import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class CopyBytes {
    public static void main(String[] args) throws FileNotFoundException {
        String readPath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\input.txt";

        String writePath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\copied-bytes.txt";

        try{
            FileInputStream readFs = new FileInputStream(readPath);
            PrintStream writeFs = new PrintStream(writePath);

            int oneByte = readFs.read();

            while(oneByte != -1){
                if(oneByte == ' '){
                    writeFs.print((char) oneByte);
                } else if( oneByte == 10){
                    writeFs.println();
                } else {
                    writeFs.print(oneByte);
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

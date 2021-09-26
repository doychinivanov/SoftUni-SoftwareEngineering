import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String path = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\input.txt";

        String outPut = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Lab\\docs\\integers.txt";

        try{
            FileInputStream readFs = new FileInputStream(path);
            PrintStream writeFs = new PrintStream(outPut);
            Scanner scan = new Scanner(readFs);

            while(scan.hasNext()){
                if(scan.hasNextInt()){
                    writeFs.println(scan.nextInt());
                }

                scan.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

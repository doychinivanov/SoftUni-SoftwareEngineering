import java.io.*;

public class SumLines {
    public static void main(String[] args) {
        String readPath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\input.txt";
        String writePath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\sum-lines.txt";

        try{
            BufferedReader readFs = new BufferedReader(new FileReader(readPath));
            BufferedWriter writeFs = new BufferedWriter(new FileWriter(writePath));

            String currentLine = readFs.readLine();

            while(currentLine != null){
                int sum = getASCIISum(currentLine);

                writeFs.write(String.valueOf(sum) + System.lineSeparator());
                currentLine = readFs.readLine();
            }

            writeFs.flush();
            writeFs.close();
            readFs.close();
        } catch (IOException err){
            err.printStackTrace();
        }
    }

    private static int getASCIISum(String currentLine) {
        int sum = 0;

        for (int i = 0; i < currentLine.length(); i++) {
            sum += currentLine.charAt(i);
        }

        return sum;
    }
}

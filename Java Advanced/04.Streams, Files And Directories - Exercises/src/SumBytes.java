import java.io.*;

public class SumBytes {
    public static void main(String[] args) {
        String readPath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\input.txt";
        String writePath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\sum-bytes.txt";
        int totalSum = 0;

        try{
            BufferedReader readFs = new BufferedReader(new FileReader(readPath));
            BufferedWriter writeFs = new BufferedWriter(new FileWriter(writePath));

            String currentLine = readFs.readLine();

            while(currentLine != null){
                int sum = getASCIISum(currentLine);

                totalSum += sum;

                currentLine = readFs.readLine();
            }

            writeFs.write(String.valueOf(totalSum) + System.lineSeparator());
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

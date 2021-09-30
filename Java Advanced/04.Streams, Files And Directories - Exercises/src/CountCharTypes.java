import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class CountCharTypes {
    public static void main(String[] args) {
        String readPath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\input.txt";
        String writePath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\char-types.txt";

        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        HashSet<Character> punctuation = new HashSet<>(Arrays.asList('!', ',', '.', '?'));

        int vowelsCount = 0;
        int punctuationCount = 0;
        int consonantsCount = 0;

        try{
            BufferedReader readFs = new BufferedReader(new FileReader(readPath));
            BufferedWriter writeFs = new BufferedWriter(new FileWriter(writePath));

            int oneByte = readFs.read();

            while (oneByte != -1){
                char currentChar = (char) oneByte;

                if(currentChar == ' ' || currentChar == '\n' || currentChar=='\r'){
                    oneByte = readFs.read();
                    continue;
                }

                if(vowels.contains(currentChar)){
                    vowelsCount++;
                } else if(punctuation.contains(currentChar)){
                    punctuationCount++;
                } else {
                    consonantsCount++;
                }

                oneByte = readFs.read();
            }

            writeFs.write(String.format("Vowels: %d" + System.lineSeparator(), vowelsCount));
            writeFs.write(String.format("Consonants: %d" + System.lineSeparator(), consonantsCount));
            writeFs.write(String.format("Punctuation: %d" + System.lineSeparator(), punctuationCount));

            readFs.close();
            writeFs.flush();
            writeFs.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

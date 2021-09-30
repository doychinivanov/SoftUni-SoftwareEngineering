import java.io.*;
import java.util.LinkedHashMap;

public class WordCount {
    public static void main(String[] args) {
        String templatePath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\words.txt";
        String writePath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\words-count.txt";
        String readPath = "D:\\coding\\GitHubRepos\\SoftUni-SoftwareEngineering\\Java Advanced\\04.Streams, Files And Directories - Exercises\\docs\\text.txt";

        LinkedHashMap<String, Integer> wordAppearanceCount = populateWordAppearanceWithTemplates(templatePath);

        checkIfWordsAppearInText(readPath, wordAppearanceCount);

        writeResultInFile(writePath, wordAppearanceCount);
    }

    private static void writeResultInFile(String writePath, LinkedHashMap<String, Integer> wordAppearanceCount) {
        try{
            BufferedWriter writeFs = new BufferedWriter(new FileWriter(writePath));

            wordAppearanceCount.forEach((key, value) -> {
                try {
                    writeFs.write(String.format("%s - %d" + System.lineSeparator(), key, value));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            writeFs.flush();
            writeFs.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void checkIfWordsAppearInText(String readPath, LinkedHashMap<String, Integer> wordAppearanceCount) {
        try{
            BufferedReader readFs = new BufferedReader(new FileReader(readPath));

            String currentLine = readFs.readLine();

            while (currentLine != null){
                String[] wordsInCurrentLine = currentLine.split("\\s+");

                for(String word: wordsInCurrentLine){
                    if(wordAppearanceCount.containsKey(word)){
                        wordAppearanceCount.put(word, wordAppearanceCount.get(word) + 1);
                    }
                }

                currentLine = readFs.readLine();
            }

            readFs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static LinkedHashMap<String, Integer> populateWordAppearanceWithTemplates(String templatePath) {
        LinkedHashMap<String, Integer> wordAppearanceCount = new LinkedHashMap<>();

        try{
            BufferedReader readFs = new BufferedReader(new FileReader(templatePath));

            String currentLine = readFs.readLine();

            while(currentLine != null){
                String[] words = currentLine.split("\\s+");

                for (String word: words) {
                    wordAppearanceCount.putIfAbsent(word, 0);
                }

                currentLine = readFs.readLine();
            }

            readFs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordAppearanceCount;
    }
}

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String url = scan.nextLine();
        String[] urlData = url.split("\\\\");
        String[] fileData = urlData[urlData.length-1].split("\\.");

        System.out.printf("File name: %s\nFile extension: %s", fileData[0], fileData[1]);
    }
}

import java.util.Scanner;

public class RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sizeOfDrawing = Integer.parseInt(scan.nextLine());

        drawFigure(sizeOfDrawing);
    }

    private static void drawFigure(int sizeOfDrawing) {
        if(sizeOfDrawing == 0) {
            return;
        }

        System.out.println(getOneLineOfDrawing(sizeOfDrawing, '*'));

        drawFigure(sizeOfDrawing - 1);

        System.out.println(getOneLineOfDrawing(sizeOfDrawing, '#'));

    }

    private static StringBuilder getOneLineOfDrawing(int length, char symbol){
        StringBuilder result = new StringBuilder();

        if(length == 0){
            return result;
        }

        result.append(symbol);

        return result.append(getOneLineOfDrawing(length - 1, symbol));
    }
}

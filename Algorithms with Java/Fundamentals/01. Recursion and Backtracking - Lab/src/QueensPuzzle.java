public class QueensPuzzle {

    public static final int BOARD_SIZE = 8;

    public static final char QUEEN = '*';

    public static final char EMPTY_SQUARE = '-';

    public static char[][] chesBoard = {
            {EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE},
            {EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE},
            {EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE},
            {EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE},
            {EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE},
            {EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE},
            {EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE},
            {EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE,EMPTY_SQUARE, EMPTY_SQUARE},
    };

    public static void main(String[] args) {

        findQueenPositions(0);

    }

    private static void findQueenPositions(int row) {
        if(row == BOARD_SIZE) {
            printSolution();
            return;
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            if(canPlaceQueen(row, col)){
                putQueen(row, col);
                findQueenPositions(row + 1);
                removeQueen(row, col);
            }
        }
    }

    private static void removeQueen(int row, int col) {
        chesBoard[row][col] = EMPTY_SQUARE;
    }

    private static void putQueen(int row, int col) {
        chesBoard[row][col] = QUEEN;

    }

    private static boolean canPlaceQueen(int row, int col) {
        for (int c = 0; c < BOARD_SIZE; c++) {
            if(chesBoard[row][c] == QUEEN) return false;
        }

        for (int r = 0; r < BOARD_SIZE; r++) {
            if(chesBoard[r][col] == QUEEN) return false;

        }

        int r = row - 1, c = col - 1;

        while(r >= 0 && c >= 0) {
            if(chesBoard[r--][c--] == QUEEN) return false;

        }

        r = row + 1;
        c = col + 1;

        while(r < BOARD_SIZE && c < BOARD_SIZE) {
            if(chesBoard[r++][c++] == QUEEN) return false;

        }

        r = row - 1;
        c = col + 1;

        while(r >= 0 && c < BOARD_SIZE) {
            if(chesBoard[r--][c++] == QUEEN) return false;
        }

        r = row + 1;
        c = col - 1;


        while(r < BOARD_SIZE && c >= 0) {
            if(chesBoard[r++][c--] == QUEEN) return false;
        }

        return true;
    }

    private static void printSolution() {
        for (char[] chars : chesBoard) {
            for (char symbol : chars) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}

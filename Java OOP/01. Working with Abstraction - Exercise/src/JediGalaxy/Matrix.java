package JediGalaxy;

import java.util.function.Predicate;

public class Matrix {
    private final int[][] matrix;
    private long sum = 0;

    public Matrix(int row, int col){
        this.matrix = createMatrix(row, col);
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    public int[][] createMatrix(int row, int col) {
        int[][] matrix = new int[row][col];

        int value = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }

    public int getMatrixLength(){
        return this.matrix.length;
    }

    public void movePlayer(int playerRow, int playerCol) {
        while (playerRow >= 0 && playerCol < this.getMatrix()[1].length) {
            if (this.positionIsInMatrix(playerRow, playerCol)) {
                this.increaseSum(this.getMatrix()[playerRow][playerCol]);
            }

            playerCol++;
            playerRow--;
        }
    }

    public void moveVillain(int villainRow, int villainCol) {
        while (villainRow >= 0 && villainCol >= 0) {
            if (this.positionIsInMatrix(villainRow, villainCol)) {
                this.getMatrix()[villainRow][villainCol] = 0;
            }
            villainRow--;
            villainCol--;
        }
    }

    public boolean positionIsInMatrix(int playerRow, int playerCol ) {
        return playerRow >= 0 && playerRow < matrix.length && playerCol >= 0 && playerCol < this.matrix[0].length;
    }

    public void increaseSum(long n){
        this.sum += n;
    }

    public long getSum() {
        return this.sum;
    }
}

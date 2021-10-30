package jediGalaxy;


public class CommandHandler {
    public static void startSystem(){
        int[] dimensions = Reader.readIntArray("\\s+");
        int row = dimensions[0];
        int col = dimensions[1];

        Matrix matrix = new Matrix(row, col);

        String command = Reader.readLine();

        while (!command.equals("Let the Force be with you")) {
            int[] playerPosition = Reader.readIntArrayFromString(command, "\\s+");
            int[] villainPosition = Reader.readIntArray("\\s+");

            int villainRow = villainPosition[0];
            int villainCol = villainPosition[1];

            int playerRow = playerPosition[0];
            int playerCol = playerPosition[1];

            matrix.moveVillain( villainRow, villainCol);

            matrix.movePlayer(playerRow, playerCol);

            command = Reader.readLine();
        }

        System.out.println(matrix.getSum());
    }
}

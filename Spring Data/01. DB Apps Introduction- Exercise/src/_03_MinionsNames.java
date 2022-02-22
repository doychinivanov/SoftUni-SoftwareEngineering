import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_MinionsNames {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int targetId = Integer.parseInt(reader.readLine());

        DBConnection db = new DBConnection("root", "your-password");
        Connection connection = db.setConnection();

        boolean hasVillain = villainExists(targetId, connection);

        if (!hasVillain) return;

        PreparedStatement statement = connection.prepareStatement("" +
                "SELECT m.name, m.age FROM villains AS v" +
                " JOIN minions_villains AS mv" +
                " ON v.id = mv.villain_id" +
                " JOIN minions AS m" +
                " ON mv.minion_id = m.id" +
                " WHERE v.id = ?;");

        statement.setInt(1, targetId);

        ResultSet resultSet = statement.executeQuery();

        printResult(resultSet);

        connection.close();
    }

    private static boolean villainExists(int targetId, Connection connection) throws SQLException {
        PreparedStatement villainStatement = connection.prepareStatement(
                "SELECT name FROM villains WHERE id = ?");
        villainStatement.setInt(1, targetId);

        ResultSet villainSet = villainStatement.executeQuery();

        if (!villainSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.", targetId);
            return false;
        } else {
            String villainName = villainSet.getString("name");
            System.out.println("Villain: " + villainName);
            return true;
        }
    }

    private static void printResult(ResultSet resultSet) throws SQLException {
        StringBuilder result = new StringBuilder();
        for (int i = 1; resultSet.next(); i++) {
            String minionName = resultSet.getString("name");
            int minionAge = resultSet.getInt("age");

            result.append(String.format("%d. %s %d" + System.lineSeparator(), i, minionName, minionAge));
        }

        System.out.println(result.toString());
    }
}

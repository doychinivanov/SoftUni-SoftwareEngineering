import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;

public class _08_IncreaseMinionAge {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ids = Arrays
                .stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        DBConnection db = new DBConnection("root", "your-password");
        Connection connection = db.setConnection();

        updateMinions(ids, connection);

        printResult(connection);

    }

    private static void printResult(Connection connection) throws SQLException {
        PreparedStatement allMinionsStatement = connection.prepareStatement("SELECT name, age FROM minions;");
        ResultSet resultSet = allMinionsStatement.executeQuery();

        StringBuilder result = new StringBuilder();
        while (resultSet.next()) {
            result.append(resultSet.getString("name")).append(" ").append(resultSet.getInt("age")).append(System.lineSeparator());
        }
        System.out.println(result);
    }

    private static void updateMinions(int[] ids, Connection connection) throws SQLException {
        for (int i = 0; i < ids.length; i++) {
            PreparedStatement updateMinionsStatement = connection.prepareStatement("UPDATE minions" +
                    " SET name = LOWER(name)," +
                    " age = age + 1" +
                    " WHERE id = ?;");

            updateMinionsStatement.setInt(1, ids[i]);
            updateMinionsStatement.executeUpdate();
        }
    }
}
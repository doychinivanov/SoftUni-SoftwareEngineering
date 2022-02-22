import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _05_ChangeTownCasing {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        DBConnection db = new DBConnection("root", "your-password");
        Connection connection = db.setConnection();

        String countryName = reader.readLine();

        int updates = updateTownCasing(connection, countryName);

        if (updates == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        printResult(connection, countryName, updates);

        connection.close();
    }

    private static int updateTownCasing(Connection connection, String countryName) throws SQLException {
        PreparedStatement updateCasingStatement = connection.prepareStatement("" +
                "UPDATE towns AS t" +
                " SET t.name = UPPER(t.name)" +
                " WHERE t.country = ?;");

        updateCasingStatement.setString(1, countryName);
        int updates = updateCasingStatement.executeUpdate();
        return updates;
    }

    private static void printResult(Connection connection, String countryName, int updates) throws SQLException {
        StringBuilder result = new StringBuilder();

        PreparedStatement selectAllTowns = connection.prepareStatement(
                "SELECT name FROM towns WHERE country = ?"
        );
        selectAllTowns.setString(1, countryName);
        ResultSet townsSet = selectAllTowns.executeQuery();

        List<String> towns = new ArrayList<>();

        while (townsSet.next()) {
            String townName = townsSet.getString("name");
            towns.add(townName);
        }

        result.append(updates).append(" town names were affected.").append(System.lineSeparator());
        result.append(towns);

        System.out.println(result);
    }
}

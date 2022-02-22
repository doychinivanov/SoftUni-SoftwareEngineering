import java.sql.*;

public class _02_VillainsNames {
    public static void main(String[] args) throws SQLException {
        DBConnection db = new DBConnection("root", "add-your-password");
        Connection connection = db.setConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT name, COUNT(DISTINCT mv.minion_id) AS count\n" +
                " FROM villains AS v" +
                " JOIN minions_villains AS mv" +
                " ON v.id = mv.villain_id" +
                " GROUP BY v.id" +
                " HAVING count > 15" +
                " ORDER BY count DESC;");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String villainName = resultSet.getString("name");
            int minionsCount = resultSet.getInt("count");

            System.out.printf("%s %d" + System.lineSeparator(), villainName, minionsCount);
        }

        connection.close();
    }
}

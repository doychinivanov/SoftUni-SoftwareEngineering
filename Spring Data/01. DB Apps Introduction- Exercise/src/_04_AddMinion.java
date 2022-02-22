import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_AddMinion {
    private static String minionTown;
    private static String villainName;

    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        DBConnection db = new DBConnection("root", "your-password");
        Connection connection = db.setConnection();

        String[] minionData = reader.readLine().split("\\s+");
        String minionName = minionData[1];
        int minionAge = Integer.parseInt(minionData[2]);
        minionTown = minionData[3];
        villainName = reader.readLine().split("\\s+")[1];

        int townId = getTownId(connection);
        int villainId = getVillainId(connection);

        PreparedStatement insertMinion = connection.prepareStatement(
                "INSERT INTO minions(name, age, town_id) VALUES(?, ?, ?)");
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);
        insertMinion.setInt(3, townId);
        insertMinion.executeUpdate();

        PreparedStatement getLastMinion = connection.prepareStatement(
                "SELECT id FROM minions ORDER BY id DESC LIMIT 1");
        ResultSet addedMinionSet = getLastMinion.executeQuery();
        addedMinionSet.next();
        int addedMinionId = addedMinionSet.getInt("id");

        PreparedStatement insertMinionsVillains = connection.prepareStatement(
                "INSERT INTO minions_villains VALUES (?, ?)"
        );
        insertMinionsVillains.setInt(1, addedMinionId);
        insertMinionsVillains.setInt(2, villainId);
        insertMinionsVillains.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s.",
                minionName, villainName);

        connection.close();
    }

    private static int getVillainId (Connection connection) throws SQLException {
        PreparedStatement selectVillain = connection.prepareStatement(
                "SELECT id FROM villains WHERE name = ?");
        selectVillain.setString(1, villainName);

        ResultSet villainSet = selectVillain.executeQuery();

        int villainId = 0;
        if (!villainSet.next()) {
            PreparedStatement insertVillain = connection.prepareStatement(
                    "INSERT INTO villains(name, evilness_factor) VALUES(?, ?)");
            insertVillain.setString(1, villainName);
            insertVillain.setString(2, "evil");

            insertVillain.executeUpdate();

            ResultSet newVillainSet = selectVillain.executeQuery();
            newVillainSet.next();
            villainId = newVillainSet.getInt("id");
            System.out.printf("Villain %s was added to the database.%n", villainName);
        } else {
            villainId = villainSet.getInt("id");
        }

        return villainId;
    }

    private static int getTownId (Connection connection) throws SQLException {
        PreparedStatement selectTown = connection.prepareStatement(
                "SELECT id FROM towns WHERE name = ?");
        selectTown.setString(1, minionTown);

        ResultSet townSet = selectTown.executeQuery();

        int townId = 0;
        if (!townSet.next()) {
            PreparedStatement insertTown = connection.prepareStatement(
                    "INSERT INTO towns(name) VALUES (?);");
            insertTown.setString(1, minionTown);
            insertTown.executeUpdate();

            ResultSet newTownSet = selectTown.executeQuery();
            newTownSet.next();
            townId = newTownSet.getInt("id");
            System.out.printf("Town %s was added to the database.%n", minionTown);
        } else {
            townId = townSet.getInt("id");
        }

        return townId;
    }
}

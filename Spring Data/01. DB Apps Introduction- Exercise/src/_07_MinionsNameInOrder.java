import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _07_MinionsNameInOrder {
    public static void main(String[] args) throws SQLException {
        List<String> namesInOriginalOrder = new ArrayList<>();
        List<String> namesOrdered = new ArrayList<>();

        DBConnection db = new DBConnection("root", "your-password");
        Connection connection = db.setConnection();

        getMinionsNamesInNaturalOrder(namesInOriginalOrder, connection);

        orderNames(0, namesOrdered, namesInOriginalOrder);

        System.out.println(String.join(System.lineSeparator(), namesOrdered));
    }

    private static void orderNames(int index, List<String> namesOrdered, List<String> namesInOriginalOrder) {
        if (index >= namesInOriginalOrder.size() / 2) return;

        namesOrdered.add(namesInOriginalOrder.get(index));
        namesOrdered.add(namesInOriginalOrder.get(namesInOriginalOrder.size() - 1 - index));

        orderNames(index + 1, namesOrdered, namesInOriginalOrder);
    }

    private static void getMinionsNamesInNaturalOrder(List<String> namesInOriginalOrder, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("" +
                "SELECT name FROM minions;"
        );
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            String minionName = resultSet.getString("name");
            namesInOriginalOrder.add(minionName);
        }
    }
}

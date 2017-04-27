import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by arahis on 4/26/17.
 */
public class ConnectionUtil {
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/apartmentsdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            if (connection == null) throw new RuntimeException("cannot get connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void dbInit() throws SQLException {
        executeSql("DROP TABLE IF EXISTS Apartments");
        executeSql("CREATE TABLE Apartments "
                + "("
                + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "price INT, "
                + "area INT, "
                + "rooms INT, "
                + "address VARCHAR(50), "
                + "region VARCHAR(30)"
                + ")"
        );
        fillDb();
    }

    private static void fillDb() throws SQLException {
        executeSql("INSERT INTO Apartments (price, area, rooms, address, region) " +
                "VALUES(420, 50, 1, 'Dank St., 1', 'One')");
        executeSql("INSERT INTO Apartments (price, area, rooms, address, region) " +
                "VALUES(422, 52, 1, 'Dank St., 2', 'One')");
        executeSql("INSERT INTO Apartments (price, area, rooms, address, region) " +
                "VALUES(423, 69, 2, 'Dank St., 3', 'Two')");
        executeSql("INSERT INTO Apartments (price, area, rooms, address, region) " +
                "VALUES(420, 80, 3, 'Dank St., 3', 'One')");
        executeSql("INSERT INTO Apartments (price, area, rooms, address, region) " +
                "VALUES(420, 80, 3, 'Dank St., 12', 'Five')");
    }

    private static void executeSql(String sqlQuery) throws SQLException {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement
                         = connection.prepareStatement(sqlQuery)) {
                statement.execute();
            }
        }
    }
}

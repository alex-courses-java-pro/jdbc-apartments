import java.sql.SQLException;
import java.util.List;

/**
 * Created by arahis on 4/26/17.
 */
public interface ApartmentsDao {

    public List<Apartment> getByPrice(int price) throws SQLException;

    public List<Apartment> getByRoomsQuantity(int quantity) throws SQLException;

    public List<Apartment> getByArea(int area) throws SQLException;

    public List<Apartment> getByAddress(String address) throws SQLException;

    public List<Apartment> getByRegion(String region) throws SQLException;

    public List<Apartment> getAll() throws SQLException;

}

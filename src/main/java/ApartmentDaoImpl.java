import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arahis on 4/26/17.
 */
public class ApartmentDaoImpl implements ApartmentsDao {

    public List<Apartment> getByPrice(int price) throws SQLException {
        List<Apartment> apartmentsList = new ArrayList<>();
        String selectSQL = "SELECT * FROM Apartments WHERE price = ?";
        try (Connection conn = ConnectionUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(selectSQL);
            ps.setInt(1, price);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                apartmentsList.add(getApartmentFromResultSet(rs));
            }
        }
        return apartmentsList;
    }

    public List<Apartment> getByRoomsQuantity(int quantity) throws SQLException {
        List<Apartment> apartmentsList = new ArrayList<>();
        String selectSQL = "SELECT * FROM Apartments WHERE rooms = ?";
        try (Connection conn = ConnectionUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(selectSQL);
            ps.setInt(1, quantity);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                apartmentsList.add(getApartmentFromResultSet(rs));
            }
        }
        return apartmentsList;
    }

    public List<Apartment> getByArea(int area) throws SQLException {
        List<Apartment> apartmentsList = new ArrayList<>();
        String selectSQL = "SELECT * FROM Apartments WHERE area = ?";
        try (Connection conn = ConnectionUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(selectSQL);
            ps.setInt(1, area);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                apartmentsList.add(getApartmentFromResultSet(rs));
            }
        }
        return apartmentsList;
    }

    public List<Apartment> getByAddress(String address) throws SQLException {
        List<Apartment> apartmentsList = new ArrayList<>();
        String selectSQL = "SELECT * FROM Apartments WHERE address = ?";
        try (Connection conn = ConnectionUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(selectSQL);
            ps.setString(1, address);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                apartmentsList.add(getApartmentFromResultSet(rs));
            }
        }
        return apartmentsList;
    }

    public List<Apartment> getByRegion(String region) throws SQLException {
        List<Apartment> apartmentsList = new ArrayList<>();
        String selectSQL = "SELECT * FROM Apartments WHERE region = ?";
        try (Connection conn = ConnectionUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(selectSQL);
            ps.setString(1, region);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                apartmentsList.add(getApartmentFromResultSet(rs));
            }
        }
        return apartmentsList;
    }

    @Override public List<Apartment> getAll() throws SQLException {
        List<Apartment> apartmentsList = new ArrayList<>();
        String selectSQL = "SELECT * FROM Apartments";
        try (Connection conn = ConnectionUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                apartmentsList.add(getApartmentFromResultSet(rs));
            }
        }
        return apartmentsList;
    }

    private Apartment getApartmentFromResultSet(ResultSet rs) throws SQLException {
        Apartment apartment = new Apartment();
        apartment.setAddress(rs.getString("address"));
        apartment.setRegion(rs.getString("region"));
        apartment.setPrice(rs.getInt("price"));
        apartment.setArea(rs.getInt("area"));
        apartment.setRoomsQuantity(rs.getInt("rooms"));
        return apartment;
    }
}

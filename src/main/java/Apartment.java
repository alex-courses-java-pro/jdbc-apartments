import lombok.Data;

/**
 * Created by arahis on 4/26/17.
 */
public @Data class Apartment {
    private int price;
    private int roomsQuantity;
    private int area; // m^2
    private String address;
    private String region;
}

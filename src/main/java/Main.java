import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by arahis on 4/26/17.
 */
public class Main {
    public static ApartmentsDao apartmentsDao = new ApartmentDaoImpl();


    public static void main(String[] args) throws SQLException {
        ConnectionUtil.dbInit();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("0: print all");
                System.out.println("1: get apartments by price");
                System.out.println("2: get apartments by area");
                System.out.println("3: get apartments by rooms quantity");
                System.out.println("4: get apartments by region");
                System.out.println("5: get apartments by address");
                System.out.print("-> ");
                int menuOption = Integer.parseInt(scanner.nextLine());
                handleInput(menuOption, scanner);
            }
        }
    }

    private static void handleInput(int option, Scanner scanner) throws SQLException {
        switch (option) {
            case 0:
                for (Apartment a : apartmentsDao.getAll())
                    System.out.println(a);
                break;
            case 1:
                System.out.println("price: ");
                String price = scanner.nextLine();
                for (Apartment a : apartmentsDao.getByPrice(Integer.parseInt(price)))
                    System.out.println(a);
                break;
            case 2:
                System.out.println("area: ");
                String area = scanner.nextLine();
                for (Apartment a : apartmentsDao.getByArea(Integer.parseInt(area)))
                    System.out.println(a);
                break;
            case 3:
                System.out.println("quantity: ");
                String quantity = scanner.nextLine();
                for (Apartment a : apartmentsDao.getByRoomsQuantity(Integer.parseInt(quantity)))
                    System.out.println(a);
                break;
            case 4:
                System.out.println("region: ");
                String region = scanner.nextLine();
                for (Apartment a : apartmentsDao.getByRegion(region))
                    System.out.println(a);
                break;
            case 5:
                System.out.println("address: ");
                String address = scanner.nextLine();
                for (Apartment a : apartmentsDao.getByAddress(address))
                    System.out.println(a);
                break;
            default:
                return;
        }
    }
}

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class CommandLine {
    private ProductDatabase productDatabase;

    public CommandLine(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Enter a command: (createProduct, displayProduct, displayProductCount, " +
                    "displayProductToRefill, displayProductToRefill [ProductID], displayProductsExpiryDate, " +
                    "displayProductsExpiryDate [ProductID], displayExpiredProducts, exit)");
            String command = scanner.nextLine();

            switch (command) {
                case "createProduct":
                    handleCreateProductCommand(scanner);
                    break;
                case "displayProduct":
                    handleDisplayProductCommand(scanner);
                    break;
                case "displayProductCount":
                    handleDisplayProductCountCommand(scanner);
                    break;
                case "displayProductToRefill":
                    productDatabase.displayProductToRefill();
                    break;
                case "displayProductToRefill [ProductID]":
                    handleDisplayProductToRefillByIDCommand(scanner);
                    break;
                case "displayProductsExpiryDate":
                    productDatabase.displayProductsExpireDate();
                    break;
                case "displayProductsExpiryDate [ProductID]":
                    handleDisplayProductsExpiryDateByIDCommand(scanner);
                    break;
                case "displayExpiredProducts":
                    productDatabase.displayExpiredProducts();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    private void handleCreateProductCommand(Scanner scanner) {
        System.out.print("Enter ProductID: ");
        int productID = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter Expiry Date (yyyy-MM-dd): ");
        Date expiryDate = parseDate(scanner.nextLine());

        System.out.print("Enter Time Duration for MarkDown (days): ");
        int timeDurationForMarkDown = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Number/Weight: ");
        int numberOrWeight = Integer.parseInt(scanner.nextLine());

        productDatabase.createProduct(productID, productName, expiryDate, timeDurationForMarkDown, numberOrWeight);
    }

    private void handleDisplayProductCommand(Scanner scanner) {
        System.out.print("Enter Product Name (or press Enter for all): ");
        String productName = scanner.nextLine();

        System.out.print("Enter ProductID (or 0 for all): ");
        int productID = Integer.parseInt(scanner.nextLine());

        productDatabase.displayProduct(productName.isEmpty() ? null : productName, productID);
    }

    private void handleDisplayProductCountCommand(Scanner scanner) {
        System.out.print("Enter Product Name (or press Enter for all): ");
        String productName = scanner.nextLine();

        System.out.print("Enter ProductID (or 0 for all): ");
        int productID = Integer.parseInt(scanner.nextLine());

        productDatabase.displayProductCount(productName.isEmpty() ? null : productName, productID);
    }

    private void handleDisplayProductToRefillByIDCommand(Scanner scanner) {
        System.out.print("Enter ProductID: ");
        int productID = Integer.parseInt(scanner.nextLine());

        productDatabase.displayProductToRefill(productID);
    }

    private void handleDisplayProductsExpiryDateByIDCommand(Scanner scanner) {
        System.out.print("Enter ProductID: ");
        int productID = Integer.parseInt(scanner.nextLine());

        productDatabase.displayProductsExpireDate(productID);
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd format.");
            return null;
        }
    }
}

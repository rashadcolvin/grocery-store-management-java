import java.util.ArrayList;
import java.util.Date;

public class ProductDatabase {
    private final ArrayList<Product> products;

    public ProductDatabase() {
        products = new ArrayList<>();
    }

    public void createProduct(int productID, String productName, Date expireDate, int timeDurationForMarkDown, int numberOrWeight) {
        if (!isProductIDUnique(productID)) {
            System.out.println("ProductID should have a unique ID. The ProductID already exists with the same unique ID.");
            return;
        }

        Product product = new Product(productID, productName, expireDate, timeDurationForMarkDown, numberOrWeight);
        products.add(product);
        System.out.println(productName + " with ProductID " + productID + " created successfully.");
    }

    public boolean isProductIDUnique(int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                return false;
            }
        }
        return true;
    }

    public void displayProduct(String productName, int productID) {
        for (Product product : products) {
            if (productID == 0 || product.getProductID() == productID) {
                System.out.println("ProductID: " + product.getProductID());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Expire Date: " + product.getExpireDate());
                System.out.println("Time Duration for MarkDown: " + product.getTimeDurationForMarkDown());
                System.out.println("Number/Weight: " + product.getNumberOrWeight());
                System.out.println("------------------------------");
            } else {
                System.out.println("Product doesn't need to be replenished at this time.");
            }
        }
    }

    public void displayProductCount(String productName, int productID) {
        for (Product product : products) {
            if (productID == 0 || product.getProductID() == productID) {
                System.out.println("ProductID: " + product.getProductID());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Number/Weight on Shelf: " + product.getNumberOrWeight());
                System.out.println("------------------------------");
            }
        }
    }

    public void displayProductToRefill() {
        boolean needRefill = false;
        for (Product product : products) {
            if (product.getNumberOrWeight() <= 10) {
                System.out.println("ProductID: " + product.getProductID());
                System.out.println("Product Name: " + product.getProductName());
                int quantityToReplenish = 45 - product.getNumberOrWeight(); // Adjust max limit
                System.out.println("Quantity/Weight to Replenish: " + quantityToReplenish);
                System.out.println("------------------------------");
                needRefill = true;
            }
        }

        if (!needRefill) {
            System.out.println("No products need replenishing at this time.");
        }
    }

    public void displayProductToRefill(int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                int quantityToReplenish = 45 - product.getNumberOrWeight(); // Adjust max limit
                if (quantityToReplenish > 0) {
                    System.out.println("ProductID: " + product.getProductID());
                    System.out.println("Product Name: " + product.getProductName());
                    System.out.println("Quantity/Weight to Replenish: " + quantityToReplenish);
                } else {
                    System.out.println("Product doesn't need replenishing at this time.");
                }
            }
        }
    }

    public void displayProductsExpireDate(int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                System.out.println("ProductID: " + product.getProductID());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Expire Date: " + product.getExpireDate());
                System.out.println("Current Date: " + new Date());
            }
        }
    }

    public void displayProductsExpireDate() {
        for (Product product : products) {
            System.out.println("ProductID: " + product.getProductID());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Expiry Date: " + product.getExpireDate());
            System.out.println("------------------------------");
        }
    }

    public void displayExpiredProducts() {
        boolean foundExpired = false;
        for (Product product : products) {
            if (product.getExpireDate().before(new Date())) {
                System.out.println("ProductID: " + product.getProductID());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Expiry Date: " + product.getExpireDate());
                System.out.println("------------------------------");
                foundExpired = true;
            }
        }

        if (!foundExpired) {
            System.out.println("No expired products on the shelf.");
        }
    }
}

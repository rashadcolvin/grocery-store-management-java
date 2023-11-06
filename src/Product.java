import java.util.Date;

public class Product {
    private int productID;
    private String productName;
    private Date expireDate;
    private int timeDurationForMarkDown;
    private int numberOrWeight;

    public Product(int productID, String productName, Date expireDate, int timeDurationForMarkDown, int numberOrWeight) {
        this.productID = productID;
        this.productName = productName;
        this.expireDate = expireDate;
        this.timeDurationForMarkDown = timeDurationForMarkDown;
        this.numberOrWeight = numberOrWeight;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public int getTimeDurationForMarkDown() {
        return timeDurationForMarkDown;
    }

    public int getNumberOrWeight() {
        return numberOrWeight;
    }
}

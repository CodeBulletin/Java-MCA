import java.util.ArrayList;
import java.util.List;

public class DP6 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        try {
            products.add(new Product("Product 1", 10));
            products.add(new Product("Product 2", 20));
            // This will throw an InvalidProductException
            products.add(new Product("", 30));
        } catch (InvalidProductException e) {
            System.out.println(e.getMessage());
        }
        for (Product product : products) {
            System.out.println(product.getName() + ": " + product.getPrice());
        }
    }
}

class Product {
    private String name;
    private int price;

    public Product(String name, int price) throws InvalidProductException {
        if (name == null || name.isEmpty()) {
            throw new InvalidProductException("Invalid product name");
        }
        if (price <= 0) {
            throw new InvalidProductException("Invalid product price");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class InvalidProductException extends Exception {
    public InvalidProductException() {
        super();
    }

    public InvalidProductException(String message) {
        super(message);
    }

    public InvalidProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProductException(Throwable cause) {
        super(cause);
    }
}
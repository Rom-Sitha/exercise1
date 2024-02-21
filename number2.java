// Interface for DiscountRate
import java.util.Scanner;
interface DiscountRate {
    double getServiceDiscountRate(String type);
    double getProductDiscountRate(String type);
}

// Sale class
class Sale implements DiscountRate {
    @Override
    public double getServiceDiscountRate(String type) {
        switch(type.toLowerCase()) {
            case "premium":
                return 0.20;
            case "gold":
                return 0.15;
            case "silver":
                return 0.10;
            case "normal":
                return 0.0;
            default:
                return 0.0;
        }
    }

    @Override
    public double getProductDiscountRate(String type) {
        switch(type.toLowerCase()) {
            case "premium":
            case "gold":
            case "silver":
                return 0.10;
            case "normal":
                return 0.0;
            default:
                return 0.0;
        }
    }
}

// Customer class
class Customer implements DiscountRate {
    @Override
    public double getServiceDiscountRate(String type) {
        return new Sale().getServiceDiscountRate(type);
    }

    @Override
    public double getProductDiscountRate(String type) {
        return new Sale().getProductDiscountRate(type);
    }
}

// Main class


public class exam4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input customer type
        System.out.print("Enter customer type (Premium/Gold/Silver/Normal): ");
        String customerType = scanner.nextLine();

        // Input product type
        System.out.print("Enter product type (Premium/Gold/Silver/Normal): ");
        String productType = scanner.nextLine();

        // Calculate and display discount rates
        Customer customer = new Customer();
        double serviceDiscountRate = customer.getServiceDiscountRate(customerType);
        double productDiscountRate = customer.getProductDiscountRate(productType);
        System.out.println("Service Discount Rate: " + (serviceDiscountRate * 100) + "%");
        System.out.println("Product Discount Rate: " + (productDiscountRate * 100) + "%");

        // Close the scanner
        scanner.close();
    }
}
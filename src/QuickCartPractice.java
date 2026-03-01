import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The QuickCartSystem class serves as the entry point for a sophisticated retail checkout simulation.
 * It utilizes Java Streams and Object-Oriented Composition to manage a cart of items and calculate totals.
 */
public class QuickCartPractice {

    // Constant for the discount threshold to avoid "magic numbers" in the code.
    private static final double DISCOUNT_THRESHOLD = 1000.0;
    private static final double FREEBIE_THRESHOLD = 2000.0;
    private static final double DISCOUNT_RATE = 0.15;

    /**
     * Inner class representing a Product entity to demonstrate Object-Oriented Composition.
     */
    static class Product {
        private final String name;
        private final double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() { return price; }
        public String getName() { return name; }
    }

    /**
     * Displays a professional header and greeting message to the console.
     * Returns nothing.
     */
    public static void displayGreeting() {
        System.out.println("=========================================");
        System.out.println("       QUICKCART SMART CHECKOUT          ");
        System.out.println("=========================================");
        System.out.println("Welcome! Let's process your items.\n");
    }

    /**
     * Uses Java Streams (Functional Programming) to sum the prices of all products in the list.
     * Returns the calculated sum as a double.
     */
    public static double computeSubtotal(List<Product> cart) {
        return cart.stream()
                   .mapToDouble(Product::getPrice)
                   .sum();
    }

    /**
     * Applies a 15% discount using a pure function approach if the subtotal meets the requirement.
     * Returns the final amount after potential deduction.
     */
    public static double applyDiscount(double subtotal) {
        if (subtotal >= DISCOUNT_THRESHOLD) {
            double savings = subtotal * DISCOUNT_RATE;
            System.out.printf("✨ Promo Applied: 15%% Discount (-₱%.2f)%n", savings);
            return subtotal - savings;
        }
        System.out.println("ℹ️  Note: Subtotal under ₱1,000.00. No discount applied.");
        return subtotal;
    }

    /**
     * Evaluates the final total to determine eligibility for a free gift based on business logic.
     * Returns nothing.
     */
    public static void checkFreebie(double total) {
        if (total > FREEBIE_THRESHOLD) {
            System.out.println("🎁 BONUS: Your total exceeds ₱2,000.00! A Premium Tote Bag has been added to your order.");
        }
    }

    /**
     * Prints a formatted closing message to signify the end of the transaction.
     * Returns nothing.
     */
    public static void displayThankYou() {
        System.out.println("\n=========================================");
        System.out.println("  Thank you for choosing QuickCart!      ");
        System.out.println("     Please come again soon!             ");
        System.out.println("=========================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> cart = new ArrayList<>();

        displayGreeting();

        // Step 1: Input Collection with enhanced prompts
        for (int i = 1; i <= 2; i++) {
            System.out.print("Enter name for Item " + i + ": ");
            String name = sc.next();
            System.out.print("Enter price for " + name + ": ₱");
            double price = sc.nextDouble();
            cart.add(new Product(name, price));
        }

        System.out.println("\n--- Processing Receipt ---");

        // Step 2: Logic Execution using abstracted methods
        double subtotal = computeSubtotal(cart);
        System.out.printf("Subtotal: ₱%.2f%n", subtotal);

        double finalTotal = applyDiscount(subtotal);
        System.out.printf("Total Amount Due: ₱%.2f%n", finalTotal);

        // Step 3: Post-purchase evaluation
        checkFreebie(finalTotal);
        displayThankYou();

        sc.close();
    }
}
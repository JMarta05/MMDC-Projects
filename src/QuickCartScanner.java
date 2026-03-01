import java.util.Scanner; // Import the Scanner class to read user input

public class QuickCartScanner {
    public static void main(String[] args) {
        // Create a Scanner object to capture input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // === 1. Collect User Input ===
        // We prompt the user for product details to make the report dynamic.
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine(); 

        System.out.print("Enter quantity sold today: ");
        int quantitySold = scanner.nextInt(); 

        System.out.print("Enter price per item: ");
        double pricePerItem = scanner.nextDouble(); 

        System.out.print("Enter number of restocked items: ");
        int restockedItems = scanner.nextInt(); 

        // === 2. Perform Computations ===
        // Calculate total revenue based on sales.
        double totalCost = quantitySold * pricePerItem;

        // Logic for stock: current stock is what we restocked minus what we sold.
        int remainingStock = restockedItems - quantitySold;

        // A boolean flag to trigger an alert if stock is low (less than 5).
        boolean lowStockAlert = remainingStock < 5;

        // === 3. Display Results ===
        System.out.println("\n=== QuickCart Sales Report ===");
        System.out.println("Product:         " + productName);
        System.out.println("Total Cost:      P" + totalCost);
        
        // Handling negative stock: If sold > restocked, we display a warning.
        if (remainingStock < 0) {
            System.out.println("Remaining Stock: ERROR (Sales exceed stock: " + remainingStock + ")");
        } else {
            System.out.println("Remaining Stock: " + remainingStock);
        }

        // Custom alert message using standard characters to avoid "unclosed literal" errors.
        if (lowStockAlert) {
            System.out.println("Low Stock Alert: [!] Restock soon!");
        } else {
            System.out.println("Low Stock Alert: Enough stock available.");
        }

        // Close the Scanner to prevent resource leaks
        scanner.close();
    }
}
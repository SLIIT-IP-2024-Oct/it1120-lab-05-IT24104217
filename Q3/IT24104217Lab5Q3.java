import java.util.Scanner;

public class IT24104217Lab5Q3 { 
    public static void main(String[] args) {
        final int ROOM_CHARGE_PER_DAY = 48000;
        final int DISCOUNT_3_TO_4_DAYS = 10;
        final int DISCOUNT_5_OR_MORE_DAYS = 20;

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter start date (1-31): ");
        int startDate = scanner.nextInt();
        System.out.print("Enter end date (1-31): ");
        int endDate = scanner.nextInt();
        
        // Validation
        if (startDate < 1 || startDate > 31 || endDate < 1 || endDate > 31) {
            System.out.println("Error: Dates must be between 1 and 31.");
            return;
        }
        if (startDate >= endDate) {
            System.out.println("Error: Start date must be less than end date.");
            return;
        }
        
        int numberOfDays = endDate - startDate;
        int totalAmount = numberOfDays * ROOM_CHARGE_PER_DAY;
        int discount = 0;

        // Apply discount based on the number of days reserved
        if (numberOfDays >= 3 && numberOfDays <= 4) {
            discount = DISCOUNT_3_TO_4_DAYS;
        } else if (numberOfDays >= 5) {
            discount = DISCOUNT_5_OR_MORE_DAYS;
        }

        // Calculate final amount after discount
        if (discount > 0) {
            totalAmount -= (totalAmount * discount / 100);
        }

        System.out.println("Number of days reserved: " + numberOfDays);
        System.out.println("Total amount to be paid: Rs " + totalAmount);
        
        scanner.close();
    }
}
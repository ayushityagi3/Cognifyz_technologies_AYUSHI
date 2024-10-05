import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double temperature;
        int choice;
        while (true) {
            System.out.println("Choose conversion type: ");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the temperature: ");
                    temperature = sc.nextDouble();
                    double CF = (temperature * 9 / 5) + 32;
                    System.out.println(temperature + " Celsius is equal to " + CF + " Fahrenheit.");
                    break;
                case 2:
                    System.out.println("Enter the temperature: ");
                    temperature = sc.nextDouble();
                    double FC = (temperature - 32) * 5 / 9;
                    System.out.println(temperature + " Fahrenheit is equal to " + FC + " Celsius.");
                    break;
                case 3:
                    System.out.println("Thankyou for visiting");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
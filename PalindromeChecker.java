import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine().replaceAll("[\\W]", "").toLowerCase();

        String reverse = new StringBuilder(input).reverse().toString();

        if (input.equals(reverse)) {
            System.out.println("The entered text is a palindrome.");
        } else {
            System.out.println("The entered text is not a palindrome.");
        }

        scanner.close();
    }
}

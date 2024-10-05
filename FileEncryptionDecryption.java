import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Do you want to (E)ncrypt or (D)ecrypt the file? ");
        char choice = scanner.next().charAt(0);

        System.out.print("Enter the key (integer): ");
        int key = scanner.nextInt();

        if (choice == 'E' || choice == 'e') {
            processFile(filePath, key, true);
        } else if (choice == 'D' || choice == 'd') {
            processFile(filePath, key, false);
        } else {
            System.out.println("Invalid option.");
        }

        scanner.close();
    }

    private static void processFile(String filePath, int key, boolean encrypt) {
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream("processed_" + file.getName());

            int content;
            while ((content = fis.read()) != -1) {
                if (encrypt) {
                    fos.write(content + key);
                } else {
                    fos.write(content - key);
                }
            }

            fis.close();
            fos.close();

            System.out.println("File processed successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

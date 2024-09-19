import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to Study Comrade Password Services :)");
            System.out.println("Enter 1 - Password Generator");
            System.out.println("Enter 2 - Password Strength Check (Not implemented)");
            System.out.println("Enter 3 - Useful Information");
            System.out.println("Enter 4 - Quit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    generatePassword(scanner);
                    break;
                case 2:
                    System.out.println("Password Strength Check feature is not implemented yet.");
                    break;
                case 3:
                    displayUsefulInformation();
                    break;
                case 4:
                    System.out.println("Closing the program. Bye bye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please select again.");
            }
        }
        scanner.close();
    }

    private static void generatePassword(Scanner scanner) {
        System.out.println("Hello, welcome to the Password Generator :) Answer the following questions by Yes or No.");

        boolean includeLower = getYesNoInput(scanner, "Do you want Lowercase letters to be used?");
        boolean includeUpper = getYesNoInput(scanner, "Do you want Uppercase letters to be used?");
        boolean includeNumbers = getYesNoInput(scanner, "Do you want Numbers to be used?");
        boolean includeSymbols = getYesNoInput(scanner, "Do you want Symbols to be used?");
        
        System.out.print("Great! Now enter the length of the password: ");
        int length = scanner.nextInt();
        
        String password = createPassword(includeLower, includeUpper, includeNumbers, includeSymbols, length);
        System.out.println("Your generated password -> " + password);
    }

    private static boolean getYesNoInput(Scanner scanner, String prompt) {
        System.out.print(prompt + " (yes/no): ");
        String response = scanner.next().trim().toLowerCase();
        while (!response.equals("yes") && !response.equals("no")) {
            System.out.print("Invalid input. Please enter yes or no: ");
            response = scanner.next().trim().toLowerCase();
        }
        return response.equals("yes");
    }

    private static String createPassword(boolean includeLower, boolean includeUpper, boolean includeNumbers, boolean includeSymbols, int length) {
        StringBuilder password = new StringBuilder();
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()_+[]{}|;:',.<>?";

        StringBuilder characterPool = new StringBuilder();
        if (includeLower) characterPool.append(lower);
        if (includeUpper) characterPool.append(upper);
        if (includeNumbers) characterPool.append(numbers);
        if (includeSymbols) characterPool.append(symbols);

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }
        return password.toString();
    }

    private static void displayUsefulInformation() {
        System.out.println("Useful Information for Creating Strong Passwords:");
        System.out.println("1. Use a minimum password length of 8 or more characters.");
        System.out.println("2. Include lowercase and uppercase alphabetic characters, numbers, and symbols.");
        System.out.println("3. Avoid using easily guessable information like pet names.");
        System.out.println("4. Don't reuse passwords across multiple accounts.");
        System.out.println("5. Regularly update passwords, especially for important accounts.");
    }
}

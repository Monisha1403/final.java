import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class CountryGuessingGame {
    private static final int GRID_SIZE = 7;
    private static final int TOTAL_COUNTRIES = 3;
    private static final HashSet<String> countries = new HashSet<>();
    private static final HashSet<String> guesses = new HashSet<>();
    private static final Random random = new Random();

    public static void main(String[] args) {
        setupCountries();
        playGame();
    }

    private static void setupCountries() {
        while (countries.size() < TOTAL_COUNTRIES) {
            String position = getRandomPosition();
            countries.add(position);
        }
    }

    private static String getRandomPosition() {
        int row = random.nextInt(GRID_SIZE) + 1; // 1 to 7
        int col = random.nextInt(GRID_SIZE) + 1; // 1 to 7
        return row + "," + col;
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your guess (e.g., a5, b2): ");
            String guess = scanner.nextLine().trim().toLowerCase();
            
            if (isValidGuess(guess)) {
                guesses.add(guess);
                if (countries.contains(guess)) {
                    System.out.println("Hit!");
                    countries.remove(guess);
                } else {
                    System.out.println("Miss!");
                }

                if (countries.isEmpty()) {
                    System.out.println("Kill! You guessed all countries!");
                    break;
                }
            } else {
                System.out.println("Invalid guess. Please enter a valid position (e.g., a5, b2).");
            }
        }
        scanner.close();
    }

    private static boolean isValidGuess(String guess) {
        if (!guess.matches("[a-g][1-7]")) {
            return false;
        }
        return !guesses.contains(guess);
    }
}
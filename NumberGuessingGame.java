import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int start = 1;
        int end = 100;
        int targetNumber = random.nextInt(end - start + 1) + start;
        int maxAttempts = 10;
        int attempts = 0;
        int score = 0;

        System.out.println("Welcome to Corrected Number Guessing Game!");
        System.out.println("I have selected a number between " + start + " and " + end);
        System.out.println("You can type 'exit' to quit the game at any time.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }

            try {
                int userGuess = Integer.parseInt(input);

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number.");
                    score += (maxAttempts - attempts) * 10;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try again. The number is higher.");
                } else {
                    System.out.println("Try again. The number is lower.");
                }

                attempts++;

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'exit' to quit.");
                scanner.next();
            }
        }

        System.out.println("Your score is: " + score);
        scanner.close();
    }
}

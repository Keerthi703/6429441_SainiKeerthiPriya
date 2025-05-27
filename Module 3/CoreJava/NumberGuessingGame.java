import java.util.Random;
import java.util.Scanner;
class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int number = rand.nextInt(100) + 1, guess;
        do {
            System.out.print("Guess the number (1-100): ");
            guess = sc.nextInt();
            if (guess < number) System.out.println("Too low");
            else if (guess > number) System.out.println("Too high");
            else System.out.println("Correct!");
        } while (guess != number);
    }
}

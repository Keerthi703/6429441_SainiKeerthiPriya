import java.util.Scanner;
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class AgeChecker {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your Age to check Eligibility");
        int age = sc.nextInt();
        try {
            if (age < 18) throw new InvalidAgeException("Age must be 18 or older.");
            System.out.println("Access granted.");
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
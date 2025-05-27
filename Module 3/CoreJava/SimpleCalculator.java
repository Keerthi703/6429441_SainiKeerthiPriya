import java.util.Scanner;
class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.print("Choose operation (+ - * /): ");
        char op = sc.next().charAt(0);
        switch (op) {
            case '+' -> System.out.println("Result: " + (a + b));
            case '-' -> System.out.println("Result: " + (a - b));
            case '*' -> System.out.println("Result: " + (a * b));
            case '/' -> System.out.println(b != 0 ? "Result: " + (a / b) : "Cannot divide by zero");
            default -> System.out.println("Invalid operation");
        }
    }
}

public class HelloBytecode {
    public static void main(String[] args) {
        int result = add(5, 10);
        System.out.println("Result: " + result);
    }

    public static int add(int a, int b) {
        return a + b;
    }
}

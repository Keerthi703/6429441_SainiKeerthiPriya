public class OverloadExample {
    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    public static void main(String[] args) {
        OverloadExample obj = new OverloadExample();
        System.out.println(obj.add(2, 3));
        System.out.println(obj.add(2.5, 3.5));
        System.out.println(obj.add(1, 2, 3));
    }
}
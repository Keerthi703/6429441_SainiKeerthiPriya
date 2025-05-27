public class PatternMatching {
    public static void main(String[] args) {
        Object[] items = { 42, "Hello", 3.14, true };

        for (Object obj : items) {
            switch (obj) {
                case Integer i -> System.out.println("Integer: " + i);
                case String s -> System.out.println("String: " + s);
                case Double d -> System.out.println("Double: " + d);
                default -> System.out.println("Unknown type");
            }
        }
    }
}

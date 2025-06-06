package Module3;

public class MyArrowFunctionExample {
    // Arrow function-like syntax (not standard in Java)
    public static void main(String[] args) {
        Runnable greet = () -> System.out.println("Hello, World!");
        greet.run(); // Invokes the arrow function
    }
}
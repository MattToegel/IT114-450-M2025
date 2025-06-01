package module1;

public class Precision {
    public static void main(String[] args) {

        float a = 1f;
        float b = 0f;
        for (int i = 0; i < 10; i++) {
            b += 0.1f;// shorthand for b = b + 0.1f;
            System.out.println("b: " + b);
        }
        System.out.println("A equals B?" + (a == b));

        System.out.println("A: " + a);
        System.out.println("B: " + b);

        // let's see the same for doubles
        double x = 1d;
        double y = 0d;
        for (int i = 0; i < 10; i++) {
            y += 0.1d;
        }
        System.out.println("X equals Y?" + (x == y));
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
    }
}

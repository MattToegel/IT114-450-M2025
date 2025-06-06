package Module3;

public class OverloadedMethods {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add two floats
    public float add(float a, float b) {
        return a + b;
    }

    // Overloaded method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        OverloadedMethods o = new OverloadedMethods();
        System.out.println(o.add(2, 2));
        System.out.println(o.add(1.5f, 1.5f));
        System.out.println(o.add(3d, 3d));
    }
}

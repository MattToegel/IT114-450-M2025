package module1;

public class Break {
    public static void main(String[] args) {
        while (true) {
            if (true) {
                break;
            }
            System.out.println("I'm loopin'");
        }
        System.out.println("We broke out of the loop");

    }
}

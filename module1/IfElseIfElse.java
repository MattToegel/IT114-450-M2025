package module1;

public class IfElseIfElse {
    public static void main(String[] args) {
        int age = 25;// <--- Change this value and rerun it
        if (age >= 21) {// if this is true
            System.out.println("You're at least 21 years old!");
        }

        if (age >= 18) {// otherwise if this is true
            System.out.println("You're at least 18 years old!");
        } else {// if no other condition was met
            System.out.println("You're under 18 years old");
        }
    }
}
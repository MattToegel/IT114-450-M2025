package module1;

public class Overflow {
    public static void main(String[] args) {

        byte myByte = 127;// remember the range of a byte is -128 - 127
        System.out.println("My byte is " + myByte);
        // let's see what happens when we add 1
        myByte++;// shorthand for incrementing by 1
        System.out.println("My byte is " + myByte);

        myByte = -128;
        System.out.println("My byte is " + myByte);
        myByte--;// shorthand for decrementing by 1
        System.out.println("My byte is " + myByte);

    }
}

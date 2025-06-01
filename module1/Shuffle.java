package module1;

import java.util.Arrays;

public class Shuffle {
    public static void main(String[] args) {
        String[] words = { "One", "Two", "Three", "Four", "Five" };

        for (int i = 0; i < words.length; i++) {
            String t = words[i];
            int newIndex = (int) (Math.random() * (words.length - 1));
            if (i == newIndex) {
                continue;
            }
            words[i] = words[newIndex];
            words[newIndex] = t;
        }
        System.out.println(Arrays.toString(words));
    }
}
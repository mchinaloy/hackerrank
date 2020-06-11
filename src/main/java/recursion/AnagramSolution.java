package recursion;


import java.util.HashSet;
import java.util.Set;

public class AnagramSolution {

    static String word = "cats";
    static char[] characters = word.toCharArray();
    static Set<String> anagrams = new HashSet<>();

    static void anagrams(int newSize) {
        if (newSize == 1) {
            return;
        }
        for (int i = 0; i < newSize; i++) {
            anagrams(newSize - 1);
            if (newSize == 2) {
                displayWord();
            }
            rotate(newSize);
        }
    }

    static void displayWord() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character ch : characters) {
            stringBuilder.append(ch);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void rotate(int newSize) {
        int j;
        int position = characters.length - newSize;
        char temp = characters[position];       // save first letter
        for (j = position + 1; j < characters.length; j++) {      // shift others left
            characters[j - 1] = characters[j];
        }
        characters[j - 1] = temp;                 // put first on right
    }

    public static void main(String[] args) {
        anagrams(word.length());
        int counter = 0;
        for (String word : anagrams) {
            System.out.println(counter + ". " + word);
            counter++;
        }
    }

}

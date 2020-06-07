package recursion;

import java.util.ArrayList;
import java.util.List;

public class EncryptedWordsSolution {

    // Add any helper functions you may need here

    static int getMiddleIndex(int length) {
        int middleIndex;
        if(length % 2 == 0) {
            middleIndex = (length / 2) - 1;
        } else {
            middleIndex = length / 2;
        }
        return middleIndex;
    }

    // abc = bca
    // abcd = bacd
    //  b acd
    //  a cd = left_arr.length == 1, return

    // abcxcba = xbacbca
    //  x abc cba
    //  x bac bca
    // x a bc = left_arr.length == 1, return

    // facebook = eafcobok
    // e fac book
    // e afc obok
    // f ac = left_arr == 1, return

    static String encryptWord(String word) {

        char[] splitWord = word.toCharArray();

        int middleIndex = getMiddleIndex(splitWord.length);

        StringBuilder encryptedWord = new StringBuilder();
        encryptedWord.append(splitWord[middleIndex]);

        List<Character> left = new ArrayList<>();
        List<Character> right = new ArrayList<>();

        for(int i = 0; i < middleIndex; i++) {
            left.add(splitWord[i]);
        }

        for(int j = middleIndex + 1; j < splitWord.length; j++) {
            right.add(splitWord[j]);
        }

        if(left.size() > 1) {
            StringBuilder leftBuilder = new StringBuilder();
            left.forEach(leftBuilder::append);
            encryptedWord.append(encryptWord(leftBuilder.toString()));
        } else if(left.size() == 1) {
            encryptedWord.append(left.get(0));
        }

        if(right.size() > 1) {
            StringBuilder rightBuilder = new StringBuilder();
            right.forEach(rightBuilder::append);
            encryptedWord.append(encryptWord(rightBuilder.toString()));
        } else if(right.size() == 1) {
            encryptedWord.append(right.get(0));
        }

        return encryptedWord.toString();
    }

    static String findEncryptedWord(String s) {
        // Write your code here
        return encryptWord(s);
    }

    public static void main(String[] args) {
        System.out.println(findEncryptedWord("facebook"));
    }
}


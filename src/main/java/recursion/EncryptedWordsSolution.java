package recursion;

public class EncryptedWordsSolution {

    // Add any helper functions you may need here

    static int getMidIndex(char[] splitWord) {
        int mid = 0;
        if (splitWord.length % 2 == 0) {
            mid = (splitWord.length / 2) - 1;
        } else {
            mid = splitWord.length / 2;
        }
        return mid;
    }

    static char[] populateLeftArray(char[] splitWord, int mid) {
        char[] left = new char[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = splitWord[i];
        }
        return left;
    }

    static char[] populateRightArray(char[] splitWord, int mid) {
        char[] right = new char[splitWord.length - mid];
        int index = 0;
        for (int i = mid; i < splitWord.length; i++) {
            right[index] = splitWord[i];
            index++;
        }
        return right;
    }

    static void printArray(char[] characters) {
        System.out.println();
        for (int i = 0; i < characters.length; i++) {
            System.out.print(characters[i] + " ");
        }
        System.out.println();
    }

    // a b c
    static String encryptWord(String result) {

        char[] splitWord = result.toCharArray();

        if (splitWord.length == 1) {
            return String.valueOf(splitWord[0]);
        }

        int mid = getMidIndex(splitWord);

        char[] left = populateLeftArray(splitWord, mid);
        char[] right = populateRightArray(splitWord, mid);

        printArray(left);
        printArray(right);

        System.out.println("Left arr length: " + left.length);
        System.out.println("Right arr length: " + right.length);

        String leftStr = new String(left);
        String rightStr = new String(right);

        if (left.length > 0) {
            leftStr = leftStr + encryptWord(leftStr);
        }
        if (right.length > 0) {
            rightStr = rightStr + encryptWord(rightStr);
        }

        System.out.println("Left str is: " + leftStr);
        System.out.println("Right str is: " + rightStr);

        return String.valueOf(splitWord[mid]) + leftStr.trim() + rightStr.trim();

    }

    static String findEncryptedWord(String s) {
        // Write your code here
        //
        return encryptWord(s);
    }

    public static void main(String[] args) {
        System.out.println(findEncryptedWord("abcd"));
    }
}


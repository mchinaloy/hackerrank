package graphs;

import java.util.HashSet;
import java.util.Set;

public class Boggle {

    static final int ROWS = 4, COLS = 4;
    static final Set<String> dictionary = new HashSet<>();

    // A recursive function to print all words present on boggle
    static void findWordsUtil(char[][] boggle, boolean[][] visited, int i,
                              int j, String str) {
        // Mark current cell as visited and append current character to str
        visited[i][j] = true;
        str = str + boggle[i][j];

        // If str is present in dictionary, then print it
        if (dictionary.contains(str)) {
            System.out.println(str);
        }

        // Traverse the adjacent cells of boggle[i][j]
        for (int row = i - 1; row <= i + 1 && row < ROWS; row++) {
            for (int col = j - 1; col <= j + 1 && col < COLS; col++) {
                if (row >= 0 && col >= 0 && !visited[row][col]) {
                    findWordsUtil(boggle, visited, row, col, str);
                }
            }
        }

        visited[i][j] = false;
    }

    // Prints all words present in dictionary.
    static void findWords(char[][] boggle) {
        boolean[][] visited = new boolean[ROWS][COLS];

        String str = "";

        // Consider every character and look for all words starting with this character
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                findWordsUtil(boggle, visited, i, j, str);
            }
        }
    }

    public static void main(String[] args) {
        dictionary.add("CAT");
        dictionary.add("TEN");
        dictionary.add("ACE");

        char[][] boggle = {
            {'N', 'E', 'T', 'A'},
            {'U', 'E', 'A', 'C'},
            {'A', 'E', 'C', 'E'},
            {'X', 'Z', 'Q', 'T'}
        };

        System.out.println("Following words of dictionary are present");
        findWords(boggle);
    }

}

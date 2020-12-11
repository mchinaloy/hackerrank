package graphs;

import java.util.HashSet;
import java.util.Set;

public class Boggle {

    private static final int ROWS = 4;
    private static final int COLS = 4;
    private static final Set<String> validWords = new HashSet<>();

    private static void getValidWords(char[][] letterGrid) {
        for (int row = 0; row < ROWS; row++) {
            boolean[][] visited = new boolean[ROWS][COLS];
            for (int col = 0; col < COLS; col++) {
                backtrack(letterGrid, visited, "", row, col);
            }
        }
    }

    private static void backtrack(char[][] letterGrid, boolean[][] visited, String current, int row, int col) {
        if (row < 0 || row > ROWS - 1 || col < 0 || col > COLS - 1) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        current = current + letterGrid[row][col];
        if (validWords.contains(current)) {
            System.out.println(current);
            return;
        }
        int[] rowOffsets = {0, 0, -1, 1};
        int[] colOffsets = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            backtrack(letterGrid, visited, current, row + rowOffsets[i], col + colOffsets[i]);
        }
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        validWords.add("TENT");
        validWords.add("HAVE");
        char[][] letterGrid = {
                {'B', 'O', 'F', 'T'},
                {'H', 'A', 'V', 'E'},
                {'A', 'L', 'F', 'N'},
                {'J', 'Q', 'F', 'T'}
        };
        getValidWords(letterGrid);
    }

}

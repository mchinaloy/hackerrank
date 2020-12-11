package graphs;

public class WordSearch {

    private static final int ROWS = 4;
    private static final int COLS = 4;

    private static boolean wordSearch(char[][] letterGrid, String word) {
        for (int row = 0; row < ROWS; row++) {
            boolean[][] visited = new boolean[ROWS][COLS];
            for (int col = 0; col < COLS; col++) {
                boolean result = backtrack(letterGrid, word, 0, visited, row, col);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] letterGrid, String word, int index, boolean[][] visited, int row, int col) {
        if (row < 0 || row > ROWS-1 || col < 0 || col > COLS-1 || visited[row][col]) {
            return false;
        }
        if(index > word.length()-1) {
            return false;
        }
        if(index == word.length()-1) {
            return true;
        }
        visited[row][col] = true;
        if(letterGrid[row][col] == word.charAt(index)) {
               index = index + 1;
               int[] rowOffsets = {0, 0, -1, 1};
               int[] colOffsets = {1, -1, 0, 0};
               for(int i=0; i < 4; i++) {
                   boolean result = backtrack(letterGrid, word, index, visited, row + rowOffsets[i], col + colOffsets[i]);
                   if(result) {
                       return true;
                   }
               }
        }
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] letterGrid = {
                {'A', 'B', 'C', 'D'},
                {'H', 'O', 'M', 'E'},
                {'U', 'M', 'D', 'N'},
                {'Y', 'B', 'X', 'T'}
        };
        String word = "DENT";
        System.out.println(wordSearch(letterGrid, word));
    }

}

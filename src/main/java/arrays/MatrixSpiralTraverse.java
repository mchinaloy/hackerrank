package arrays;

public class MatrixSpiralTraverse {

    public static void traverse(int[][] numbers) {
       int startRow = 0;
       int endRow = numbers.length-1;
       int startCol = 0;
       int endCol = numbers[0].length-1;

       while(startRow <= endRow && startCol <= endCol) {

           for(int col = startCol; col <= endCol; col++) {
               System.out.print(numbers[startRow][col]);
           }

           for(int row = startRow + 1; row <= endRow; row++) {
               System.out.print(numbers[row][endCol]);
           }

           for(int col = endCol - 1; col >= startCol; col--) {
               if(startRow == endRow) {
                   break;
               }
               System.out.print(numbers[endRow][col]);
           }

           for(int row = endRow - 1; row > startRow; row--) {
               if(startRow == endRow) {
                   break;
               }
               System.out.print(numbers[row][startCol]);
           }

           startRow++;
           startCol++;
           endRow--;
           endCol--;
       }

    }

    public static void main(String[] args) {
        int[][] numbers = {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15},
        };
        traverse(numbers);
    }

}

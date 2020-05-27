package sorting;

public class InsertionSortSolution {

    static int[] insertionSort(int[] arr) {
        // 1 4 2 6 5 7
        // numToCompare = 4
        // preceedingNum = 1
        // O(N^2)
        for(int i = 1; i < arr.length; i++) {
            int numToCompare = arr[i];
            int preceedingNum = arr[i-1];
            int indexToCompare = i;
            while(indexToCompare >= 0) {
                if(numToCompare < preceedingNum) {
                    arr[i - 1] = numToCompare;
                    arr[i] = preceedingNum;
                }
                indexToCompare--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] numbers = {2,1,4,3,7,6};
        int[] result = insertionSort(numbers);
        for(int num : result) {
            System.out.print(num + " ");
        }
    }

}

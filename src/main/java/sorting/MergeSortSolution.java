package sorting;

import static java.lang.System.arraycopy;

public class MergeSortSolution {

    static int[] mergeSort(int[] numbers) {
        if(numbers.length == 1) {
            return numbers;
        }

        int mid = numbers.length / 2;
        int[] left = new int[mid];
        int[] right = new int[numbers.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = numbers[i];
        }

        for (int i = mid; i < numbers.length; i++) {
            right[i - mid] = numbers[i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int size = left.length + right.length;
        int[] result = new int[size];
        arraycopy(left, 0, result, 0, left.length);
        arraycopy(right, 0, result, left.length, right.length);

        for(int i = 1; i < result.length; i++) {
            int indexToCompare = i-1;
            int numToCompare = result[i];
            while(indexToCompare >= 0) {
                if(numToCompare < result[indexToCompare]) {
                    int temp = result[indexToCompare];
                    result[indexToCompare] = numToCompare;
                    result[indexToCompare+1] = temp;
                }
                indexToCompare--;
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] numbers = {4,5,2,7,9,6};
        int[] result = mergeSort(numbers);
        for(int num : result) {
            System.out.print(num + " ");
        }
    }

}

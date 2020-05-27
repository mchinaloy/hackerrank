package sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSortSolution1 {

    static List<Integer> partition(int[] numbers) {
        int pivot = numbers[0];

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < pivot) {
                left.add(numbers[i]);
            } else {
                right.add(numbers[i]);
            }
        }

        return mergeResults(left, right, pivot);
    }

    static List<Integer> mergeResults(List<Integer> left, List<Integer> right, int pivot) {
        List<Integer> result = new ArrayList<>(left);
        result.add(pivot);
        result.addAll(right);
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 1, 4, 3, 7, 6};
        List<Integer> result = partition(numbers);
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }

}

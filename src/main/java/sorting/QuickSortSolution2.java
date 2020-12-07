package sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSortSolution2 {

    static List<Integer> quicksort(int[] numbers) {
        List<Integer> nums = new ArrayList<>();
        for (int num : numbers) {
            nums.add(num);
        }
        return partition(nums, nums.get(0));
    }

    static List<Integer> partition(List<Integer> numbers, int pivot) {

        /*
        2, 1, 4, 3, 7, 6
        [2]
        1 [2] 4 3 7 6
        4 3 7 6
        [4]
        3 [4] 7 6
        [7]
        6
         */

        if (numbers.size() == 1) {
            return numbers;
        }

        List<Integer> leftPartition = new ArrayList<>();
        List<Integer> rightPartition = new ArrayList<>();

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < pivot) {
                leftPartition.add(numbers.get(i));
            } else {
                rightPartition.add(numbers.get(i));
            }
        }

        if (leftPartition.size() > 0) {
            leftPartition = partition(leftPartition, leftPartition.get(0));
        }

        if (rightPartition.size() > 0) {
            rightPartition = partition(rightPartition, rightPartition.get(0));
        }
        return combinePartitions(leftPartition, rightPartition, pivot);
    }

    static List<Integer> combinePartitions(List<Integer> left, List<Integer> right, int pivot) {
        List<Integer> result = new ArrayList<>(left);
        result.add(pivot);
        result.addAll(right);
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {8, 5, 2, 9, 5, 6, 3};

        System.out.println("Input: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Output: ");
        List<Integer> result = quicksort(numbers);
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }

}

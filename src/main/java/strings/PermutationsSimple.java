package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PermutationsSimple {

    private static List<int[]> results = new ArrayList<>();

    private static void getPermutations(int[] numbers) {
        permutations(numbers, 0);
    }

    private static void permutations(int[] numbers, int start) {
        if(start >= numbers.length) {
            results.add(numbers.clone());
        } else {
            for(int i=start; i < numbers.length; i++) {
                swap(numbers, start, i);
                permutations(numbers, start + 1);
                swap(numbers, start, i);
            }
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        getPermutations(numbers);
        for(int[] entry : results) {
            System.out.println(Arrays.toString(entry));
        }
    }

}

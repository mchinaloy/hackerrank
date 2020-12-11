package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {

    private static final Map<Integer, Integer> seen = new HashMap<>();

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int complement = Math.abs(target - numbers[i]);
            if (seen.containsKey(complement)) {
                return new int[]{i, seen.get(complement)};
            } else {
                seen.put(numbers[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String args[]) {
        int[] numbers = {2, 4, 1, 3, 7, 9};
        int[] result = twoSum(numbers, 5);
        if (result.length > 1) {
            System.out.println("[" + result[0] + "," + result[1] + "]");
        } else {
            System.out.println("[]");
        }
    }

}

package arrays;

import java.util.HashMap;
import java.util.Map;

public class ThreeSumSolution {

    public static int[] threeSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int complement = Math.abs(target - numbers[i]);
            int[] twoSumExists = twoSum(numbers, i, complement);
            if (twoSumExists.length > 0) {
                return new int[]{i, twoSumExists[0], twoSumExists[1]};
            }
        }
        return new int[0];
    }

    private static final Map<Integer, Integer> seen = new HashMap<>();

    private static int[] twoSum(int[] numbers, int index, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (i != index) {
                int complement = Math.abs(target - numbers[i]);
                if (seen.containsKey(complement)) {
                    return new int[]{i, seen.get(complement)};
                } else {
                    seen.put(numbers[i], i);
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 6, 1, 4, 8, 12, 7};
        int[] result = threeSum(numbers, 21);
        if (result.length > 0) {
            System.out.println("[" + result[0] + "," + result[1] + "," + result[2] + "]");
        } else {
            System.out.println("[]");
        }
    }

}

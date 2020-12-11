package trees;

public class BinarySearchSimple {

    private static boolean binarySearch(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left <= right) {
            // Prevent INT overflow bug
            int mid = left + (right - left) / 2;
            if(numbers[mid] == target) {
                return true;
            }
            if(target < numbers[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 7, 9, 12, 18, 23, 34};
        System.out.println(binarySearch(numbers, 23));
    }

}

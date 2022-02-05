package trees;

public class BinarySearchPractice {

    public static void quicksort(int[] numbers, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = numbers[left + (right - left) /2];
        int index = partition(numbers, left, right, pivot);
        quicksort(numbers, left, index-1);
        quicksort(numbers, index, right);
    }

    private static int partition(int[] numbers, int left, int right, int pivot) {
        while(left <= right) {
            while(numbers[left] < pivot) {
                left++;
            }
            while(numbers[right] > pivot) {
                right--;
            }
            if(left <= right) {
                swap(numbers, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }

    public static boolean binarySearch(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                return true;
            } else if (target < numbers[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 5, 8, 12, 15, 27, 29, 34, 47};
        System.out.println(binarySearch(numbers, 5));

        int[] unsortedNumbers = {3, 2, 1, 5, 7, 4, 22, 17, 15, 33};
        quicksort(unsortedNumbers, 0, unsortedNumbers.length-1);
        for(Integer n : unsortedNumbers) {
            System.out.println(n);
        }
    }

}

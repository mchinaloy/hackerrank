package sorting;

public class QuickSortSolution3 {

    private static void qs(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = numbers[left + (right - left) / 2];
        int index = partition(numbers, left, right, pivot);
        qs(numbers, left, index - 1);
        qs(numbers, index, right);
    }

    private static int partition(int[] numbers, int left, int right, int pivot) {
        while (left <= right) {

            while (numbers[left] < pivot) {
                left++;
            }

            while (numbers[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(numbers, left, right);
                left++;
                right--;
            }

        }
        return left;
    }

    private static void swap(int[] numbers, int left, int right) {
        int tmp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = tmp;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 8, 3, 5, 9};
        qs(numbers, 0, numbers.length - 1);
        for (int num : numbers) {
            System.out.println(num);
        }
    }

}

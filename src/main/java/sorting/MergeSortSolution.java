package sorting;

public class MergeSortSolution {

    static void merge(int[] Arr, int start, int mid, int end) {
        // create a temp array
        int[] temp = new int[end - start + 1];

        // crawlers for both intervals and for temp
        int i = start;
        int j = mid + 1;
        int k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp
        while (i <= mid && j <= end) {
            if (Arr[i] <= Arr[j]) {
                temp[k] = Arr[i];
                k += 1;
                i += 1;
            } else {
                temp[k] = Arr[j];
                k += 1;
                j += 1;
            }
        }

        // add elements left in the first interval
        while (i <= mid) {
            temp[k] = Arr[i];
            k += 1;
            i += 1;
        }

        // add elements left in the second interval
        while (j <= end) {
            temp[k] = Arr[j];
            k += 1;
            j += 1;
        }

        // copy temp to original interval
        for (i = start; i <= end; i += 1) {
            Arr[i] = temp[i - start];
        }
    }

    static void mergeSort(int Arr[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(Arr, start, mid);
            mergeSort(Arr, mid + 1, end);
            merge(Arr, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {4, 5, 2, 7, 9, 6};
        mergeSort(numbers, 0, numbers.length-1);
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

}

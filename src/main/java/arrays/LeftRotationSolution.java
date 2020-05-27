package arrays;

public class LeftRotationSolution {

    public static int[] rotateLeft(int[] numbers, int rotations) {

        if(rotations == 0 || (numbers.length == rotations)) {
            return numbers;
        }

        // [1,2,3,4,5] - 2 rotations = [3,4,5,1,2]
        // Save index [0], index being rotated, shift everything left and insert at end, do this x times
        // O(R * N)
        for(int i = 0; i < rotations; i++) { // O(R)
            int numberToShift = numbers[0];
            for(int j = 0; j < numbers.length; j++) { // O(N)
                int indexToShift = j + 1;
                if(indexToShift > numbers.length-1) {
                    numbers[numbers.length-1] = numberToShift;
                } else {
                    numbers[j] = numbers[indexToShift];
                }
            }

        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        int[] result = rotateLeft(numbers, 2);
        for(int num : result) {
            System.out.println(num);
        }
    }

}

package trees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchSolution {

    static int getMiddleIndex(int size) {
        if(size % 2 == 0) {
            return (size / 2) - 1;
        }
        return size / 2;
    }

    static boolean binarySearch(List<Integer> numbers, int numberToFind) {
        if(numbers.size() == 0) {
            return false;
        }

        int middleIndex = getMiddleIndex(numbers.size());

        if(numbers.get(middleIndex) == numberToFind) {
            return true;
        }

        if(numberToFind < numbers.get(middleIndex)) {
            List<Integer> left = new ArrayList<>();
            for(int i = 0; i < middleIndex; i++) {
                left.add(numbers.get(i));
            }
            return binarySearch(left, numberToFind);
        } else if(numberToFind > numbers.get(middleIndex)) {
            List<Integer> right = new ArrayList<>();
            for(int i = middleIndex + 1; i < numbers.size(); i++) {
                right.add(numbers.get(i));
            }
            return binarySearch(right, numberToFind);
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);

        System.out.println(binarySearch(numbers, 5));

    }

}

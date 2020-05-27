package heaps;

import java.util.Arrays;

public class HeapSolution {

    static int size = 0;
    static int capacity = 10;
    static int[] numbersHeap = new int[capacity];

    /*
         3
        / \
       4   6
      / \  / \
     5   8 9  10

    [3,4,6,5,8,9,10]
     0 1 2 3 4 5 6

     leftChildIndex of 4 = (1 * 2) + 1 = 3 = [5]
     rightChildIndex of 4 = (1 * 2) + 2 = 4 = [8]
     parentIndex of 5 = (3 - 1) / 2 = [4]

     */

    static int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    static int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    static int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    static int getLeftChild(int index) {
        return numbersHeap[getLeftChildIndex(index)];
    }

    static int getRightChild(int index) {
        return numbersHeap[getRightChildIndex(index)];
    }

    static int getParent(int index) {
        return numbersHeap[getParentIndex(index)];
    }

    static boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    static boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    static boolean hasParent(int index) {
        return getParentIndex(index) >= size;
    }

    static void ensureCapacity() {
        if(size == capacity) {
            numbersHeap = Arrays.copyOf(numbersHeap, capacity * 2);
            capacity *= 2;
        }
    }

    static void swap(int indexOne, int indexTwo) {
        int temp = numbersHeap[indexOne];
        numbersHeap[indexOne] = numbersHeap[indexTwo];
        numbersHeap[indexTwo] = temp;
    }

    // Get the min element (min-heap is root)
    static int peek() {
        return numbersHeap[0];
    }

    // Remove the min element (min-heap is root)
    static int poll() {
        // Remove min element
        int minItem = numbersHeap[0];
        // Set min element with last element
        numbersHeap[0] = numbersHeap[size-1];
        size--;
        heapifyDown();
        // Return removed item
        return minItem;
    }

    static void add(int data) {
        ensureCapacity();
        numbersHeap[size-1] = data;
        size++;
        heapifyUp();
    }

    static void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && getParent(index) > numbersHeap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    static void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChildIndex(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
        }
    }

    public static void main(String[] args) {

    }

}

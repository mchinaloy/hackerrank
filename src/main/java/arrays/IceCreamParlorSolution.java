package arrays;

public class IceCreamParlorSolution {

    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {
        // m = money to spend e.g. 4
        // arr = flavor costs = [1,4,5,3,2]

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(i != j) {
                    int totalCost = arr[i] + arr[j];
                    if(totalCost == m) {
                        return new int[]{i+1, j+1};
                    }
                }
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] flavors = { 1,3,4,4,6,8 };
        int[] result = icecreamParlor(4, flavors);
        for(int flavor : result) {
            System.out.println(flavor);
        }
    }

}

import java.util.Scanner;
public class search {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Enter target value");
        int target = scnr.nextInt();
        System.out.println(searcher(arr, 0, arr.length - 1,target));
        scnr.close();
    }

    public static int searcher(int[] arr, int low, int high, int target) {
        if( low > high ) {
            return -1;
        }
        int middle = (high + low) / 2;
        if (arr[middle] == target) {
            return middle;
        }
            else if ( arr[middle] < target) {
                return searcher(arr, middle + 1, high, target);
            }
            else {
                return searcher(arr, low, middle - 1, target);
            }
    }
}

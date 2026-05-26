
public class SumArray {
    public static void main(String[] args) {
        System.out.println(sumArray(new int[] { 1, 2, 3, 4, 5 }, 5));
    }

    public static int sumArray(int[] arr, int n) {
        if( n == 0 ){
            return 0;
        }
        return arr[n - 1] + sumArray(arr, n - 1);
    }
}

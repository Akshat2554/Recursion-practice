import java.util.Scanner;
public class power {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("enter base value");
        int base = scnr.nextInt();
        System.out.println("enter the exponent");
        int exponent = scnr.nextInt();
        System.out.println(powerUp(base, exponent));
        scnr.close();
    }
    public static int powerUp(int base, int exponent) {
        if( exponent == 0){
            return 1;
        }
        if ( exponent % 2 == 0){
        int half = powerUp(base, exponent/2);
        return half*half;
        }
        else{
        return base * powerUp( base, exponent - 1);
        }
    }
}

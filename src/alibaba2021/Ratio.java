package alibaba2021;

import java.util.Scanner;

public class Ratio {
    private static int gcd(int a, int b){
        if(a < b){
            int temp = a; a = b; b = temp;
        }
        while(b > 0){
            int temp = a % b; a = b; b = temp;
        }
        return a;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int greatestCommonDivisor = gcd(a, b);
        // 先约分
        a /= greatestCommonDivisor;
        b /= greatestCommonDivisor;
        // 然后计算unit
        int unit = Math.min(A / a, B / b);
        // x占a份unit，y占b份unit
        System.out.println(unit * a + " " + unit * b);
    }
}
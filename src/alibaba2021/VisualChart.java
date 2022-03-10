package alibaba2021;

import java.math.BigInteger;
import java.util.Scanner;

public class VisualChart {
    private static final BigInteger ONE = new BigInteger(String.valueOf(1));

    private static final BigInteger ZERO = new BigInteger(String.valueOf(0));

    private static final BigInteger MOD = new BigInteger(String.valueOf(998244353));

    private static BigInteger factorial(BigInteger n){
        BigInteger res = new BigInteger(String.valueOf(1));
        while (!n.equals(ZERO)){
            res = res.multiply(n);
            n = n.subtract(ONE);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(String.valueOf(sc.nextInt()));
        BigInteger up = new BigInteger(String.valueOf(sc.nextInt()));
        BigInteger down = new BigInteger(String.valueOf(sc.nextInt()));
        BigInteger left = new BigInteger(String.valueOf(sc.nextInt()));
        BigInteger right = new BigInteger(String.valueOf(sc.nextInt()));
        System.out.println(
                        factorial(n.multiply(n)).
                                divide(factorial(up)).
                                divide(factorial(down)).
                                divide(factorial(left)).
                                divide(factorial(right)).
                                mod(MOD));
    }
}

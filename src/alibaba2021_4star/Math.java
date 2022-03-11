package alibaba2021_4star;

import java.util.Scanner;

public class Math {
    private static long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long T = sc.nextLong();
        for(int i = 0; i < T; i++){
            long A = sc.nextLong();
            long B = sc.nextLong();
            long n = sc.nextLong();
            if(n == 1){
                System.out.println(A);
            }else if(n == 2){
                System.out.println((A * A - 2 * B) % MOD);
            }else{
                long an_2 = A;
                long an_1 = ((A * A - 2 * B) % MOD + MOD) % MOD;
                long an = 0;
                for(int j = 3; j <= n; j++){
                    an = ((an_1 * A - B * an_2) % MOD + MOD) % MOD;
                    an_2 = an_1;
                    an_1 = an;
                }
                System.out.println(an);
            }
        }
    }
}

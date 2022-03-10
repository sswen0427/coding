package alibaba2021;

import java.util.Arrays;
import java.util.Scanner;

public class Canal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] x = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            sc.nextInt();
        }
        Arrays.sort(x);
        int median = x[n / 2];
        long res = 0;
        for(int i = 0; i < n; i++) res += Math.abs(median - x[i]);
        System.out.println(res);
    }
}


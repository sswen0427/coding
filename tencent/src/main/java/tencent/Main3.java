package tencent;

import java.util.Scanner;
// 70 percent
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int[] fight = new int[n+2];
        int[] defend = new int[n+2];
        for(int i = 1; i <= n; i++){
            if(str.charAt(i-1) == '0'){
                fight[i] = fight[i-1] + i;
            }else{
                fight[i] = fight[i-1];
            }
        }
        for(int i = n; i >= 1; i--){
            if(str.charAt(i-1) == '1'){
                defend[i] = defend[i+1]+i;
            }else{
                defend[i] = defend[i+1];
            }
        }
        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= n; i++){
            int num = Math.abs(fight[i] - defend[i+1]);
            if(num < min){
                min = num;
            }
        }
        System.out.println(min);
    }
}

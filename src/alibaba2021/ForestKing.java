package alibaba2021;

import java.util.Scanner;

public class ForestKing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] idol = new int[n+1];
        int[] res = new int[n+1];
        for(int i = 1; i < idol.length; i++){
            idol[i] = sc.nextInt();
        }
        for(int i = 1; i < idol.length; i++){
            int index = i;
            do{
                res[index]++;
                index = idol[index];
            }while (index != 0);
        }
        for(int i = 1; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
}
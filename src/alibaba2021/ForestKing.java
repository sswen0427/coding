package alibaba2021;

import java.util.Scanner;
import java.util.Arrays;

public class ForestKing {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] idol = new int[n + 1];
        int[] tickets = new int[n + 1];

        Arrays.fill(tickets, 1);
        for(int i = 1; i < idol.length; i++) idol[i] = sc.nextInt();

        for(int i = tickets.length-1; i >= 1; i--)
            tickets[idol[i]] += tickets[i];   // 有崇拜对象，假设把自己身上所有的票都投给崇拜对象
        for(int i = 1; i <= n; i++)
            System.out.println(tickets[i]);
    }
}
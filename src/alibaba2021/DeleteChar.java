package alibaba2021;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class DeleteChar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            System.out.println(delete(str.toCharArray(), n, m));
        }
    }

    private static String delete(char[] str, int n, int m) {
        Deque<Character> deque = new LinkedList<>();
        int removeCharNums = 0;
        for(int i = 0; i < n; i++){
            char c = str[i];
            while(!deque.isEmpty() && c < deque.peek() && removeCharNums < m){
                deque.pop();
                removeCharNums += 1;
            }
            deque.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty())
            sb.append(deque.pollLast());
        return sb.toString().substring(0, n - m);
    }
}
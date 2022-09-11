package alibaba2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectItems {
    private static List<Integer> list = new ArrayList<>();

    private static int n = 0;

    private static int m = 0;

    private static void helper(int value){
        if(list.size() == m){
            for(int i = 0; i < list.size() - 1; i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println(list.get(list.size()-1));
            return;
        }
        if(value > n) return;
        list.add(value);
        helper(value+1);
        list.remove(list.size()-1);

        helper(value+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        helper(1);
    }
}

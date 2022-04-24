package tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    private static String ltrim(String string){
        StringBuilder stringBuilder = new StringBuilder(string);
        while (stringBuilder.length() > 0 && stringBuilder.charAt(0) == '0'){
            stringBuilder.delete(0, 1);
        }
        if(stringBuilder.length() == 0) return "0";
        else return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
        int length = list.get(0).length();

        List<String> res = new ArrayList<>();
        for(int i = 0; i < length; i++){
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = 0; j < list.size(); j++){
                stringBuilder.append(list.get(j).charAt(i));
            }
            res.add(stringBuilder.toString());
        }
        res.sort(((o1, o2) -> o1.compareTo(o2)));
        for(int i = 0; i < res.size(); i++){
            if(i == 0){
                System.out.print(ltrim(res.get(i)));
            }else{
                System.out.print(" " + ltrim(res.get(i)));
            }
        }
    }
}
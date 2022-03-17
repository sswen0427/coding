package bytedance2019;

import java.util.Scanner;

public class SmartEditor {
    private static String fixString(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        for(int i = 0; i < stringBuilder.length(); i++){
            boolean case1 = (i+3) < stringBuilder.length()
                    && stringBuilder.charAt(i) == stringBuilder.charAt(i+1)
                    && stringBuilder.charAt(i+2) == stringBuilder.charAt(i+3)
                    && stringBuilder.charAt(i) != stringBuilder.charAt(i+2);
            boolean case2 = (i+2) < stringBuilder.length()
                    && stringBuilder.charAt(i) == stringBuilder.charAt(i+1)
                    && stringBuilder.charAt(i+1) == stringBuilder.charAt(i+2);

            if(case1 || case2 ){
                stringBuilder.delete(i+2, i+3);
                i--;
            }
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++){
            System.out.println(fixString(sc.nextLine()));
        }
    }
}

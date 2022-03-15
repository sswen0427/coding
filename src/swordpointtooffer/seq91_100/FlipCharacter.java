package swordpointtooffer.seq91_100;

public class FlipCharacter {
    public int minFlipsMonoIncr(String s) {
        if(s.length() == 1) return 0;
        char[] arr = s.toCharArray();
        int zero = 0, one = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '0'){
                one = Math.min(one, zero) + 1;
            }else if(arr[i] == '1'){
                one = Math.min(one, zero);
                zero++;
            }
        }
        return Math.min(one, zero);
    }
}

package bytedance2019;

import java.util.ArrayList;
import java.util.Scanner;

public class Majiang {

    private static boolean canHu(int[] arr, int total, boolean hasHead){
        if(total == 0) return true;
        if(!hasHead){
            for(int i = 0; i < 9; i++){
                if(arr[i] >= 2){
                    arr[i] -= 2;
                    if(canHu(arr, total - 2, true)) return true;
                    arr[i] += 2;
                }
            }
            return false;
        }else{
            for(int i = 0; i < 9; i++){
                if(arr[i] > 0){
                    if(arr[i] >= 3){
                        arr[i] -= 3;
                        if(canHu(arr, total - 3, true)) return true;
                    }
                    if(i + 2 < 9 && arr[i+1] > 0 && arr[i+2] > 0){
                        arr[i]--;
                        arr[i+1]--;
                        arr[i+2]--;
                        if(canHu(arr, total - 3, true)) return true;
                        arr[i]++;
                        arr[i+1]++;
                        arr[i+2]++;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] state = new int[9], helpArr = new int[9];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < 13; i++){
            int num = sc.nextInt();
            state[num - 1]++;
        }
        for(int i = 0; i < 9; i++){
            if(state[i] < 4){
                int num = i + 1;
                System.arraycopy(state, 0, helpArr, 0, 9);
                helpArr[i]++;
                if(canHu(helpArr, 14, false)) res.add(num);
            }
        }
        if(res.isEmpty()) System.out.println(0);
        else{
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(res.get(0));
            for(int i = 1; i < res.size(); i++){
                stringBuffer.append(" ");
                stringBuffer.append(res.get(i));
            }
            System.out.println(stringBuffer);
        }
    }
}

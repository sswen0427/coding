package alibaba2021_4star;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++)  a[i] = sc.nextInt();
        for(int i = 0; i < n; i++)  map.put(sc.nextInt(), i);

        // 将序列表示成b的下标
        for (int i = 0; i < n; i++) a[i] = map.get(a[i]);

        // 求下标最长连续上升序列
        int max = 1;
        int cur = 1;
        // 从第二个开始计算
        for (int i = 1; i < a.length; i++) {
            if(a[i]>a[i-1]) {
                cur++;
                max = Math.max(max,cur);
            }else {
                cur = 1;
            }
        }
        System.out.println(n - max);
    }
}

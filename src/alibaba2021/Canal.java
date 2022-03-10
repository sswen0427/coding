package alibaba2021;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Canal {
    public static void main(String[] args) {
        // step 1 : construct the incremental map
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            sc.nextInt();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            sum += entry.getValue();
            map.put(entry.getKey(), sum);
        }

        // step 2 : binary search
        int left = map.firstKey();
        int right = map.lastKey();
        int mid = 0;
        while (left <= right){
            mid = left + (right-left)/2;
            Map.Entry<Integer, Integer> entry = map.floorEntry(mid);
            int leftSum = entry.getValue();
            int rightSum = sum - leftSum;
            if(leftSum > rightSum){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        // step 3 : compute the distance
        int total = 0, leftSum = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            total += (Math.abs(entry.getKey() - mid) * (entry.getValue() - leftSum));
            leftSum = entry.getValue();
        }
        System.out.println(total);
    }
}

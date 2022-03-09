package alibaba2021;

import java.util.*;

public class PerfectPair {

    public static void main(String[] args) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();;
        for(int i = 0; i < n; i++){
            int first = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int j = 1; j < k; j++){
                list.add(first - sc.nextInt());
            }
            map.put(list, map.getOrDefault(list, 0) + 1);
        }
        int sum = 0;
        List<Integer> negate = Collections.nCopies(k-1, 0);
        if(map.containsKey(negate)){
            int cnt = map.get(negate);
            sum += cnt * (cnt-1)/2;
        }
        int sum1 = 0;
        for(Map.Entry<List<Integer>, Integer> entry : map.entrySet()){
            List<Integer> nums = entry.getKey();
            int value1 = entry.getValue();

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < nums.size(); i++){
                list.add(-nums.get(i));
            }
            if(map.containsKey(list)){
                int value2 = map.get(list);
                sum1 += value1 * value2;
            }
        }
        sum += sum1/2;
        System.out.println(sum);
    }
}

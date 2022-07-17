package leetcode.seq0341_0350;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if(map.get(o1) > map.get(o2)){
                return 1;
            }else if(map.get(o1) < map.get(o2)){
                return -1;
            }else{
                return 0;
            }
        });
        for(Integer key : map.keySet()){
            queue.add(key);
            if(queue.size() > k){
                queue.poll();
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = queue.poll();
        }
        return res;
    }
}

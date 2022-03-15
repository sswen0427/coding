package swordpointtooffer.seq21_30;

import java.util.*;

public class O1Containter {
    private Map<Integer, Integer> num_idx = new HashMap<>();
    private List<Integer> nums = new ArrayList<>();
    Random random = new Random();

    /** Initialize your data structure here. */
//        public RandomizedSet() {
//
//        }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(num_idx.containsKey(val))  return false;
        int idx = nums.size();
        num_idx.put(val, idx);
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!num_idx.containsKey(val))  return false;
        int idx = num_idx.get(val);
        int lastNum = nums.get(nums.size() -1);
        nums.set(idx, lastNum);
        nums.remove(nums.size()-1);
        num_idx.put(lastNum, idx);
        num_idx.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = random.nextInt(nums.size());
        return nums.get(idx);
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}

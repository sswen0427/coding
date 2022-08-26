package leetcode._0001_0100.seq0031_0040;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class SearchRange {
    private int low(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != target) return mid;
                right = mid - 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int high(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] != target) return mid;
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int left = low(nums, target);
        if(left == -1) return new int[]{-1, -1};
        int right = high(nums, target);
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        new ConcurrentHashMap(32);

        SearchRange searchRange = new SearchRange();

//        int[] nums = {5,7,7,8,8,10};
//        int target = 8;

        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        System.out.println(Arrays.toString(searchRange.searchRange(nums, target)));

    }
}

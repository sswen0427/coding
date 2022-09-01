package leetcode._0001_0100.seq0051_0060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        List<int[]> list = new ArrayList<>();
        int first = 0, second = 1;
        while (true){
            if(second >= intervals.length){
                list.add(intervals[first]);
                break;
            }

            if(intervals[second][0] <= intervals[first][1]){
                if(intervals[second][1] > intervals[first][1]){
                    intervals[first][1] = intervals[second][1];
                }
                second++;
            }else{
                list.add(intervals[first]);
                first = second;
                second++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] nums = new int[2][];
        nums[0] = new int[]{1, 4};
        nums[1] = new int[]{4, 5};
        new Merge().merge(nums);

    }

}

package leetcode.seq821_830;

import java.util.*;

public class FlipGame {

    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> same = new HashSet();

        for (int i = 0; i < fronts.length; ++i)
            if (fronts[i] == backs[i])
                same.add(fronts[i]);

        int ans = 9999;
        for (int x: fronts)
            if (!same.contains(x))
                ans = Math.min(ans, x);

        for (int x: backs)
            if (!same.contains(x))
                ans = Math.min(ans, x);

        return ans % 9999;
    }

    public static void main(String[] args) {
        FlipGame flipGame = new FlipGame();
        int[] fronts = {1, 1};
        int[] backs = {2, 2};
        System.out.println(flipGame.flipgame(fronts, backs));
    }
}

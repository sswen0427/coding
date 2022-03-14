package swordpointtooffer;

import java.util.HashMap;
import java.util.Map;

public class TheShortestSubstringContainingAllCharacters {
    public String minWindow(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0, cnt = 0;
        String ans = "";
        while (right < s.length()){
            char in = s.charAt(right);
            char out = s.charAt(left);

            smap.put(in, smap.getOrDefault(in, 0) + 1);
            // 该语句的作用是统计窗口内的有效字符
            if(smap.get(in) <= tmap.getOrDefault(in, 0)) cnt++;

            while (smap.get(out) > tmap.getOrDefault(out, 0) && left < right){
                smap.put(out, smap.get(out)-1);
                out = s.charAt(++left);
            }

            if(cnt == t.length()){
                if(ans.isEmpty() || right - left + 1 < ans.length()){
                    ans = s.substring(left, right+1);
                }
            }
            right++;
        }
        return ans;
    }
}

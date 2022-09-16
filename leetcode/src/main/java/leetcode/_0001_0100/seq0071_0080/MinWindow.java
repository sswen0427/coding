package leetcode._0001_0100.seq0071_0080;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    private Map<Character, Integer> ori = new HashMap<>();
    private Map<Character, Integer> cnt = new HashMap<>();

    private boolean check(){
        for(Map.Entry<Character, Integer> entry : ori.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if(cnt.getOrDefault(key, 0) < value){
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (char c : t.toCharArray()) {
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen){
            ++r;
            if(r < sLen){
                char ch = s.charAt(r);
                if(ori.containsKey(ch)) {
                    cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
                }
            }
            while (check() && l <= r){
                if(r-l+1 < len){
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                char ch = s.charAt(l);
                if(ori.containsKey(ch)){
                    cnt.put(ch, cnt.getOrDefault(ch, 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }
}

package swordpointtooffer2.seq011_020;

import java.util.ArrayList;
import java.util.List;

public class AllAnagram {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        if(n < m)  return new ArrayList<>();
        int[] cnt = new int[26];
        for(int i = 0; i < m; i++){
            --cnt[p.charAt(i) - 'a'];
            ++cnt[s.charAt(i) - 'a'];
        }

        int diff = 0;
        for(int num : cnt){
            if(num != 0) diff++;
        }

        List<Integer> list = new ArrayList<>();
        if(diff == 0) list.add(0);
        for(int i = m; i < n; i++){
            char in = s.charAt(i);
            char out = s.charAt(i-m);

            if(cnt[in - 'a'] == 0) diff++;
            ++(cnt[in - 'a']);
            if(cnt[in - 'a'] == 0) diff--;

            if(cnt[out - 'a'] == 0) diff++;
            --cnt[out - 'a'];
            if(cnt[out - 'a'] == 0) diff--;

            if(diff == 0) list.add(i-m+1);
        }
        return list;
    }

    public static void main(String[] args) {
        AllAnagram allAnagram = new AllAnagram();
        allAnagram.findAnagrams( "cbaebabacd", "abc");
    }
}

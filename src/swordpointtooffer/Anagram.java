package swordpointtooffer;

public class Anagram {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(n > m) return false;
        int[] cnt = new int[26];
        for(int i = 0; i < n; i++){
            --cnt[s1.charAt(i)-'a'];
            ++cnt[s2.charAt(i)-'a'];
        }
        int diff = 0;
        for(int num : cnt){
            if(num != 0)  diff++;
        }
        if(diff == 0)  return true;
        for(int i = n; i < m; i++){
            char x = s2.charAt(i);
            char y = s2.charAt(i-n);
            if(x == y) continue;

            if(cnt[x-'a'] == 0) diff++;
            ++cnt[x-'a'];
            if(cnt[x-'a'] == 0) diff--;

            if(cnt[y-'a'] == 0) diff++;
            --cnt[y-'a'];
            if(cnt[y-'a'] == 0) diff--;

            if(diff == 0)  return true;
        }
        return false;
    }
}

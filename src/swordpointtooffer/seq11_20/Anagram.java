package swordpointtooffer.seq11_20;

public class Anagram {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(n > m) return false;
        int[] cnt = new int[26];
        for(int i = 0; i < n; i++){
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0, right = 0;
        while(right < m){
            int index = s2.charAt(right) - 'a';
            ++cnt[index];
            while(cnt[index] > 0){
                --cnt[s2.charAt(left)-'a'];
                ++left;
            }
            if(right - left + 1 == n) return true;
            right++;
        }
        return false;
    }
}

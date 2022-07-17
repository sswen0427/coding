package swordpointtooffer2.seq011_020;

public class PalindromeString {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for(int i = 0; i < 2 * n - 1; i++){
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                ans++;
            }
        }
        return ans;
    }
}

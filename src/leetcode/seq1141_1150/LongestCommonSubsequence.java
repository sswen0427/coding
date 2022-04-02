package leetcode.seq1141_1150;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("abcde", "ace"));
        System.out.println(lcs.longestCommonSubsequence("abc", "abc"));
        System.out.println(lcs.longestCommonSubsequence("abc", "def"));
    }
}

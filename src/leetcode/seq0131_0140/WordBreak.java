package leetcode.seq0131_0140;

import java.util.*;

// DFS 超出时间限制
class WordBreak1 {
    private String str = null;
    private Set<String> wordSet = null;

    private boolean canBreak(int start){
        if(start == str.length()) return true;
        for(int i = start+1; i <= str.length(); i++){
            String prefix = str.substring(start, i);
            if(wordSet.contains(prefix) && canBreak(i)){
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        str = s;
        return canBreak(0);
    }
}



// DFS + 记忆化
class WordBreak2 {
    private String str = null;
    private Set<String> wordSet = null;
    private Boolean[] memo = null;

    private boolean canBreak(int start){
        if(start == str.length()) return true;
        if(memo[start] != null) return memo[start];
        for(int i = start+1; i <= str.length(); i++){
            String prefix = str.substring(start, i);
            if(wordSet.contains(prefix) && canBreak(i)){
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        str = s;
        memo = new Boolean[s.length()];
        return canBreak(0);
    }
}


// BFS 超出时间限制
class WordBreak3 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        while (!queue.isEmpty()){
            int start = queue.pollFirst();
            for(int i = start + 1; i <= s.length(); i++){
                String prefix = s.substring(start, i);
                if(wordSet.contains(prefix)){
                    if(i < s.length()){
                        queue.addLast(i);
                    }else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

// BFS + 记忆化
class WordBreak4 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] isVisited = new boolean[s.length()];
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(0);

        while (!queue.isEmpty()){
            int start = queue.pollFirst();
            if(isVisited[start]) continue;
            isVisited[start] = true;

            for(int i = start + 1; i <= s.length(); i++){
                String prefix = s.substring(start, i);
                if(wordSet.contains(prefix)){
                    if(i < s.length()){
                        queue.addLast(i);
                    }else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

// dp
class WordBreak5 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int right = 1; right <= s.length(); right++){
            for(int left = right-1; left >= 0; left--){
                if(dp[left]){
                    String suffix = s.substring(left, right);
                    if(wordSet.contains(suffix)){
                        dp[right] = true;
                        break;
                    }
                }

            }
        }
        return dp[s.length()];
    }
}
package leetcode._0001_0100.seq0071_0080;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    class Solution1{

        private List<List<Integer>> lists = new ArrayList<>();

        private List<Integer> list = new ArrayList<>();

        private void dfs(int n, int k, int start){
            if(list.size() == k) {
                lists.add(new ArrayList<>(list));
                return;
            }
            for(int i = start; i <= n; i++){
                list.add(i);
                dfs(n, k, i+1);
                list.remove(list.size() - 1);
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            dfs(n, k, 1);
            return lists;
        }
    }


    class Solution2{

        private List<List<Integer>> lists = new ArrayList<>();

        private List<Integer> list = new ArrayList<>();

        private void dfs(int n, int k, int start){
            if(list.size() == k) {
                lists.add(new ArrayList<>(list));
                return;
            }
            for(int i = start; i <= n - (k - list.size()) + 1; i++){
                list.add(i);
                dfs(n, k, i+1);
                list.remove(list.size() - 1);
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            dfs(n, k, 1);
            return lists;
        }
    }

    class Solution3{

        private List<List<Integer>> lists = new ArrayList<>();

        private List<Integer> list = new ArrayList<>();

        private void dfs(int n, int k, int start){
            if(k == 0){
                lists.add(new ArrayList<>(list));
                return;
            }
            if(start > n - k + 1){
                return;
            }
            dfs(n, k, start + 1);
            list.add(start);
            dfs(n, k-1, start + 1);
            list.remove(list.size() - 1);
        }

        public List<List<Integer>> combine(int n, int k) {
            dfs(n, k, 1);
            return lists;
        }
    }
}

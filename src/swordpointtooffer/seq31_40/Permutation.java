package swordpointtooffer.seq31_40;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    private List<String> lists = new ArrayList<>();

    private char[] list;

    private char[] chars;

    private boolean[] used;

    private void dfs(int depth){
        if(depth == chars.length){
            lists.add(String.valueOf(list));
            return;
        }

        for(int i = 0; i < chars.length; i++){
            if(used[i]) continue;
            if(i > 0 && chars[i] == chars[i-1] && !used[i-1])   continue;

            list[depth] = chars[i];
            used[i] = true;
            dfs(depth+1);
            used[i] = false;
        }
    }

    public String[] permutation(String s) {
        chars = s.toCharArray();
        list = new char[chars.length];
        used = new boolean[chars.length];

        Arrays.sort(chars);
        dfs(0);
        return lists.toArray(new String[lists.size()]);
    }
}

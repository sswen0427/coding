package leetcode._0701_0800.seq0781_0790;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    private List<String> list = new ArrayList<>();

    private char[] chars;

    private void changeCase(int index){
        char ch = chars[index];
        if(Character.isLowerCase(ch)){
            chars[index] = Character.toUpperCase(ch);
        }else {
            chars[index] = Character.toLowerCase(ch);
        }
    }

    private void dfs(int index){
        if(index == chars.length){
            list.add(new String(chars));
            return;
        }
        dfs(index + 1);
        char ch = chars[index];
        if(Character.isLowerCase(ch) || Character.isUpperCase(ch)){
            changeCase(index);
            dfs(index + 1);
            changeCase(index);
        }
    }

    public List<String> letterCasePermutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return list;
    }
}

package leetcode._0001_0100.seq0011_0020;

import java.util.Deque;
import java.util.LinkedList;

public class IsValid {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            switch (ch){
                case '(':
                case '{':
                case '[':{
                    stack.addLast(ch);
                    break;
                }
                case ')':{
                    if(stack.isEmpty()) return false;
                    if(stack.pollLast() != '(') return false;
                    break;
                }
                case '}':{
                    if(stack.isEmpty()) return false;
                    if(stack.pollLast() != '{') return false;
                    break;
                }
                case ']':{
                    if(stack.isEmpty()) return false;
                    if(stack.pollLast() != '[') return false;
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
}

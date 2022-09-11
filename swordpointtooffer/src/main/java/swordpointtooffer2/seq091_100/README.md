
剑指 Offer II 092. [翻转字符](https://leetcode-cn.com/problems/cyJERH/)  
&nbsp;&nbsp;&nbsp;&nbsp;zero[i]和one[i]表示0到 i 的子串满足要求且分别以0结尾和以1结尾时的最小翻转次数。  
&nbsp;&nbsp;&nbsp;&nbsp;s[i] == '0': zero[i] = zero[i-1], one[i] = min(one[i-1], zero[i-1]) + 1  
&nbsp;&nbsp;&nbsp;&nbsp;s[i] == '1': zero[i] = zero[i-1]+1, one[i] = min(one[i-1], zero[i-1])  
&nbsp;&nbsp;&nbsp;&nbsp;s[0] == '0': zero[0] = 0, one[0] = 1  
&nbsp;&nbsp;&nbsp;&nbsp;s[0] == '1': zero[0] = 1, one[0] = 0  
&nbsp;&nbsp;&nbsp;&nbsp;由于当前的最小值只和前一位的最小值有关，所以可以优化空间复杂度为O(1)，只使用两个变量zero和one来表示前面的最小值


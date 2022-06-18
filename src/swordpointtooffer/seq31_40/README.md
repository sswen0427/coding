剑指 Offer II 031. [最近最少使用缓存](https://leetcode.cn/problems/OrIXps/)  
&nbsp;&nbsp;&nbsp;&nbsp;哈希表 + 双向链表， 照着抄的

剑指 Offer II 038. [每日温度](https://leetcode.cn/problems/iIQa4I/)  
&nbsp;&nbsp;&nbsp;&nbsp;单调栈, 发现自己知道用什么方法却不会写代码

剑指 Offer II 039. [直方图最大矩形面积](https://leetcode.cn/problems/0ynMMM/)  
&nbsp;&nbsp;&nbsp;&nbsp;如果我们枚举「宽」，我们可以使用两重循环枚举矩形的左右边界以固定宽度 w，此时矩形的高度 h，就是所有包含在内的柱子的「最小高度」，对应的面积为 w×h。

&nbsp;&nbsp;&nbsp;&nbsp;如果我们枚举「高」，我们可以使用一重循环枚举某一根柱子，将其固定为矩形的高度 h。随后我们从这跟柱子开始向两侧延伸，直到遇到高度小于 h 的柱子，就确定了矩形的左右边界。如果左右边界之间的宽度为 w，那么对应的面积为 w×h。

&nbsp;&nbsp;&nbsp;&nbsp;单调栈，和38题一样，用两次单调栈
剑指 Offer II 007. [数组中和为 0 的三个数](https://leetcode-cn.com/problems/1fGaJU/)  
&nbsp;&nbsp;&nbsp;&nbsp;先排序，以第一个元素为target，然后使用双指针寻找和为target的两个数

剑指 Offer II 011. [0 和 1 个数相同的子数组](https://leetcode-cn.com/problems/A1NYOS/)  
&nbsp;&nbsp;&nbsp;&nbsp;将数组中的 0 视作 −1，则原问题转换成「求最长的连续子数组，其元素和为 0」。 维护一个变量counter 存储前缀和。
遍历数组nums，当遇到元素 1 时将 counter 的值加 1，当遇到元素 0 时将 counter 的值减 1，遍历过程中使用哈希表存储每个前缀和第一次出现的下标。

剑指 Offer II 014. [字符串中的变位词](https://leetcode-cn.com/problems/MPnaiL/)     
1.滑动窗口  
&nbsp;&nbsp;&nbsp;&nbsp;用一个变量diff来记录 cnt<sub>1</sub> 与 cnt<sub>2</sub> 的不同值的个数，这样判断 cnt<sub>1</sub>
和 cnt<sub>2</sub> 是否相等就转换成了判断 diff 是否为 0。  
&nbsp;&nbsp;&nbsp;&nbsp;每次窗口滑动，记一进一出两个字符为 x 和 y. 若 x=y 则对 cnt<sub>2</sub> 无影响，可以直接跳过。
若 x!=y，对于字符 x，在修改 cnt<sub>2</sub>之前若有 cnt<sub>2</sub>[x]=cnt<sub>1</sub>[x]，则将 diff 加一；
在修改 cnt<sub>2</sub> 之后若有 cnt<sub>2</sub>[x]=cnt<sub>1</sub>[x]，则将 diff 减一。字符 y 同理。

2.双指针  
&nbsp;&nbsp;&nbsp;&nbsp;可以在保证 cnt 的值不为正的情况下，去考察是否存在一个区间，其长度恰好为 n。  
&nbsp;&nbsp;&nbsp;&nbsp;初始时，仅统计 s<sub>1</sub> 中的字符，则 cnt 的值均不为正，且元素值之和为 −n。
然后用两个指针 left 和 right 表示考察的区间 [left,right]。right 每向右移动一次，就统计一次进入区间的字符 x。
为保证 cnt 的值不为正，若此时 cnt[x]>0，则向右移动左指针，减少离开区间的字符的 cnt 值直到 cnt[x]≤0。  
注意到 [left,right] 的长度每增加 1，cnt 的元素值之和就增加 1。当 [left,right] 的长度恰好为 n 时，就意味着
cnt 的元素值之和为 0。由于 cnt 的值不为正，元素值之和为 0 就意味着所有元素均为 0，这样我们就找到了一个目标子串。
                        

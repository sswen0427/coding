剑指 Offer II 007. [数组中和为 0 的三个数](https://leetcode-cn.com/problems/1fGaJU/)  
&nbsp;&nbsp;&nbsp;&nbsp;先排序，以第一个元素为target，然后使用双指针寻找和为target的两个数

剑指 Offer II 011. [0 和 1 个数相同的子数组](https://leetcode-cn.com/problems/A1NYOS/)  
&nbsp;&nbsp;&nbsp;&nbsp;将数组中的 0 视作 −1，则原问题转换成「求最长的连续子数组，其元素和为 0」。 维护一个变量counter 存储前缀和。遍历数组nums，当遇到元素 1 时将 counter 的值加 1，当遇到元素 0 时将 counter 的值减 1，遍历过程中使用哈希表存储每个前缀和第一次出现的下标。

                                                                 


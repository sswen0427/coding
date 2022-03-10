[原题链接](https://www.nowcoder.com/test/30440590/summary) <br/>
1.完美对   **difficult**
<pre>
对输入做如下变换即可
2  11 21      2 -9 -19
19 10  1     19  9  18
20 11  1     20  9  19
 6 15 24      6 -9 -18
18 27 36     18 -9 -18
</pre>
教训：字符串哈希要比List哈希快，访问数组要比List快，先判断键是否存在再使用相应的值要比getOrDefault快

2.选择物品  simple

3.过河问题  **difficult**

4.比例问题  **difficult**

5.小强修水渠 题目少个约束，水渠必须经过房屋 simple

6.国际交流会 最终结果要使用long类型，否则会出现溢出问题 simple

7.小强的神奇矩阵  一定一定要注意越界问题  simple

8.蚂蚁森林之王   Arrays.fill method can init the array    simple

9.删除字符    never use stack    **difficult**

10.视力表 BigInteger is useful    **difficult**   取模等式等价变形中，是没有除法的！！！


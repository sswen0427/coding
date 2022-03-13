[原题链接](https://www.nowcoder.com/test/30440638/summary) <br/>
1.子集    **difficult**    <font color = 'red'>lambda表达式居然是最后一个测试用例没有通过的原因</font>

2.小强爱数学   
    x<sup>n</sup>+y<sup>n</sup> = (x<sup>n-1</sup>+y<sup>n-1</sup>)(x+y) - xy(x<sup>n-2</sup>+y<sup>n-2</sup>)    <br>
    a<sub>n</sub> = a<sub>n-1</sub> * A - B * a<sub>n-2</sub>

3.二叉树    **difficult**   amazing

4.对称飞行器    **very difficult**

5.知识竞赛    **difficult**  
  将员工的两项能力值之差的绝对值|ai-bi|由小到大排序，那么较差的能力是A还是B肯定是由排在后面的员工决定的。用后面员工的较弱能力（A或者B）跟当前该项能力的最大值相加，然后和当前记录的最大弱项和值比较就OK了。
  
6.树上最短链  <font color = 'red' >普通的bfs就可以了，第一次使用set超时，第二次改成ArrayList就过了</font>

7.牛牛们吃糖果  转换成0-1背包问题来求解

8.方案数量 可以采用动态规划解法

9.合法连续子段  注意左指针右移的时候，仍然需要检查此时区间是否满足条件
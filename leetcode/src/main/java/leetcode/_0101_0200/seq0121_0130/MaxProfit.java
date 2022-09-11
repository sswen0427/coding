package leetcode._0101_0200.seq0121_0130;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minprice){
                minprice = prices[i];
            }else if(prices[i] - minprice > maxProfit){
                maxProfit = prices[i] - minprice;
            }
        }
        return maxProfit;
    }
}

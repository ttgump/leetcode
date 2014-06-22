/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
/*
这个很简单，一次扫描完成。只需要找到最大增长即可。
从前往后，用当前价格减去此前最低价格，就是在当前点卖出股票能获得的最高利润。
扫描的过程中更新最大利润和最低价格就行了。
O(n)
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int low = prices[0];
        int maxp = 0;
        for(int i = 1; i < prices.length; ++i) {
            int profit = prices[i] - low;
            if(maxp < profit) maxp = profit;
            if(low > prices[i]) low = prices[i];
        }
        return maxp;
    }
}
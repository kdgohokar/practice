package me.practice;

public class BuySellStock {

    public static int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxProfit = 0;
        while (r < prices.length) {
            if (prices[r] > prices[l]) {
                int currentProfit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, currentProfit);
            } else {
                l = r;
            }
            r++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
}

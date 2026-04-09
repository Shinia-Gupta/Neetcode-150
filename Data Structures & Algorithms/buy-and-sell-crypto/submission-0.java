class Solution {
    public int maxProfit(int[] prices) {
        //intuition - standing at a stock i considering it as the selling stock, what is the minimum price of the stock i can get to buy it till the stock i
        int profit=0,minStockPriceSoFar=Integer.MAX_VALUE;
        for(int stockPrice:prices){
            int currentProfit=(stockPrice-minStockPriceSoFar)<=0?0:stockPrice-minStockPriceSoFar;
            profit=Math.max(profit, currentProfit);
            minStockPriceSoFar=Math.min(minStockPriceSoFar,stockPrice);
        }
        return profit; 
    }
}

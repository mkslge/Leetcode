class Solution {
    public int maxProfit(int[] prices, int fee) {
        int [] own = new int[prices.length];
        int [] dontOwn = new int[prices.length];
        //base cases 
        //either we just bought the stock
        own[0] = -prices[0];
        //or we didnt so we have no profit
        dontOwn[0] = 0;
        for(int i = 1; i < prices.length;i++) {
            //you can either keep the same stock we already own, or newly purchase one
            own[i] = Math.max(own[i - 1], dontOwn[i - 1] - prices[i]);
            //here you can either continue to wait, or sell a stock and pay the fee
            dontOwn[i] = Math.max(dontOwn[i - 1], own[i] + prices[i] - fee);
        }
        //we know this will be the max, since dontOwn updates based on own
        // (alternatively we can also return the max of both, but it comes to the same result)
        return dontOwn[prices.length - 1];
    }
}

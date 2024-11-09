class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int index = 0;
        int currMinPrice = 10001;
        int profit = 0;

        while(index < prices.size()) {
            //check if our current price is more then our last price
            if(prices[index] > currMinPrice) {
                //if so we can add that to our profits
                profit += prices[index] - currMinPrice;
            }
            //reset our last price
            currMinPrice = prices[index];
            index++;
        }
        //return profit
        return profit;
    }
};

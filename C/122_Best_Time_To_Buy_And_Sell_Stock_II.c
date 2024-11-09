int maxProfit(int* prices, int pricesSize) {
    
    int i = 0;
    int sol = 0;
    int min = 10001;

    while(i < pricesSize) {
        //see if we have found a new price to buy
        if(prices[i] > min) {
            //buy it it
            sol += prices[i] - min;
        }
        //reset minimum
        min = prices[i];
        i++;
    }
    return sol;
}

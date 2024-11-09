# @param {Integer[]} prices
# @return {Integer}
def max_profit(prices)
    #use window to keep track of prices
    l = 0
    r = 0
    #keep track of solution
    maxProfit = 0
    #go through whole array
    while r < prices.length()
        #if we found an unprofitable price we have to go to the next index
        if prices[l] > prices[r]
            l += 1
            
        else 
            #otherwise if it is profitable compare it to our max profit
            #and keep going
            maxProfit = [prices[r] - prices[l],maxProfit].max
            r += 1
        end
    end
    return maxProfit
end

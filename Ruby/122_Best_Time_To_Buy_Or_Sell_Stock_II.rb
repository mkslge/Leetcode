# @param {Integer[]} prices
# @return {Integer}
def max_profit(prices)
    #set last_price to impossibly high price (by problem statement)
    last_price = 10001
    profit = 0
    idx = 0
    #go through prices
    while idx < prices.length
        #if we have found a higher price we can sell and make profit
        if prices[idx] > last_price
            #add difference to our profits
            profit += prices[idx] - last_price
        end
        #update last_price and index
        last_price = prices[idx]
        idx += 1
    end
    #return profits
    return profit

end

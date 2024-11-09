class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        
        i = 0
        min = 10001
        sol = 0
        while i < len(prices):
            # check if this is the minimum
            if prices[i] > min:
                #if it is we can make more profit
                sol += prices[i] - min
            #reset the minimum
            min = prices[i]
            #keep going
            i += 1
        #return max profit
        return sol

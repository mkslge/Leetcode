class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        states = [[-1 for _ in range(3)] for _ in range(len(prices))]
        print(states)
        buy = 0
        sell = 1
        cooldown = 2
        def dp(state, time):
            if time >= len(prices):
                return 0

            if states[time][state] == -1:

                if state == buy:
                    states[time][state] = max(
                        dp(buy, time + 1),
                        dp(sell, time + 1) - prices[time]
                    )
                elif state == sell:
                    states[time][state] = max(
                        dp(sell, time + 1),
                        dp(cooldown, time + 1) + prices[time]
                    )
                else: #cooldown
                    states[time][state] = dp(buy, time + 1)
                    
            return states[time][state]

        return dp(buy, 0)

        

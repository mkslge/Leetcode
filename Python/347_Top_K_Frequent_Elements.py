import heapq
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        freqs = {}
        for num in nums:
            if num not in freqs:
                freqs[num] = 0
            freqs[num] += 1
        
        pq = []


        for num, freq in freqs.items():
            heapq.heappush(pq, (-freq, num))
        
        sol = []
        for _ in range(k):
            _, num =heapq.heappop(pq)
            sol.append(num)
        return sol

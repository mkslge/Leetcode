class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        sets = []
        def backtrack(i, arr):
            if i >= len(nums):
                sets.append(arr[:])
                return
            arr.append(nums[i])
            backtrack(i + 1, arr)
            while i< len(nums) - 1 and nums[i + 1] == nums[i]:
                i += 1

            arr.pop()
            backtrack(i + 1, arr)
            
        backtrack(0, [])
        return sets
        

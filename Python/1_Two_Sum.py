class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        idxs = {}
        for i in range(len(nums)):
            num = nums[i]
            recip = target - num

            if recip in idxs:
                return [idxs[recip], i]
            idxs[num] = i
        return []
        

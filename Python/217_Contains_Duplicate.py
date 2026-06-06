class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        vals = set()
        for num in nums:
            if num in vals:
                return True
            vals.add(num)
        return False
        

class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        prefix = [1] * len(nums)
        postfix = [1] * len(nums)
        prefix[0] = nums[0]
        postfix[len(postfix) - 1] = nums[len(nums) - 1]

        for i in range(1, len(nums)):
            j = len(nums) - 1 - i
            prefix[i] = prefix[i - 1] * nums[i]
            postfix[j] = postfix[j + 1] * nums[j]
        products = [0] * len(nums)

        for i in range(len(nums)):
            prefix_val = 1 if i == 0 else prefix[i - 1]
            postfix_val = 1 if i == len(nums) - 1 else postfix[i + 1]
            products[i] = prefix_val * postfix_val
        return products

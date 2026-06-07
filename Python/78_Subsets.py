class Solution:

    def subsets(self, nums: List[int]) -> List[List[int]]:
        subsets = []
        def aux(curr, i):
            if i >= len(nums):
                subsets.append(curr)
                return
            else:
                aux( list(curr), i + 1)
                curr.append(nums[i])
                aux(list(curr), i + 1)
        aux([], 0)
        return subsets

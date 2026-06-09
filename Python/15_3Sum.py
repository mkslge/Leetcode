class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        nums.sort()

        sol_set = set()
        for i in range(len(nums) - 1):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            l = i + 1
            r = len(nums) - 1
            while l < r:
                summed = nums[i] + nums[l] + nums[r]

                if summed == 0:
                    tup = tuple([nums[i], nums[l], nums[r]])
                    if tup not in sol_set:
                        sol_set.add(tup)
                    l += 1
                elif summed > 0:
                    r -= 1
                else:
                    l += 1


        return list(sol_set)

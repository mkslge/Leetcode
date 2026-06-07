class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        vals = set(nums)
        seq = 0
        for val in vals:
            if val - 1 not in vals:
                count = 1
                while val + count in vals:
                    count += 1
                seq = max(seq, count)
                
        return seq

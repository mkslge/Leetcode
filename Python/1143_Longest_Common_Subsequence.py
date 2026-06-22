class Solution(object):
    def longestCommonSubsequence(self, text1, text2):

        mem = [[-1 for _ in range(len(text2))] for _ in range(len(text1))]

        #mem[0][0] = 0

        def lcs_dfs(i1, i2):
            if i1 < 0 or i2 < 0 or i1 >= len(text1) or i2 >= len(text2):
                return 0
            if mem[i1][i2] == -1:
                if text1[i1] == text2[i2]:
                    mem[i1][i2] = 1 + lcs_dfs(i1 - 1, i2 - 1)
                else:
                    mem[i1][i2] = max(lcs_dfs(i1 - 1, i2), lcs_dfs(i1, i2 - 1))
            return mem[i1][i2]
        
        return lcs_dfs(len(text1) - 1, len(text2) - 1)


        

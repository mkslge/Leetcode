class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        lst = [[-1 for _ in range(n)] for _ in range(m)]
        lst[0][0] = 1
        def uniqueRec(i, j):
            if i < 0 or i >= m:
                return 0
            if j < 0 or j >= n:
                return 0
            if lst[i][j] != -1:
                return lst[i][j]
            lst[i][j] = uniqueRec(i - 1, j) + uniqueRec(i, j - 1)
            return lst[i][j]
        return uniqueRec(m - 1, n - 1)
            

        

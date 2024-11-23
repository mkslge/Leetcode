class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        #get number of rows and columns
        rows = len(matrix)
        cols = len(matrix[0])
        left = 0
        #set right to last index using rows and columns
        right = rows * cols - 1
        #just do a regular binary search but convert left and right
        #to indices for the matrix
        while left <= right:
            #get middle value like normal
            m = left + (right - left) // 2
            #get row of index by dividing
            mRow = m // cols
            #got column of index by getting remainder
            mCol = m % cols
            #if we found the value return true
            if target == matrix[mRow][mCol]:
                return True
                #if its too small check smaller half
            elif target < matrix[mRow][mCol]:
                right = m - 1
                #if its too big check bigger half
            else:
                left = m + 1
        #if we exited loop we didnt find it ):
        return False
        

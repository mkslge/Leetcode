class Solution:
    def numTrees(self, n: int) -> int:
        #stores past results
        mem  = [0] * (n+1)
        #sets base cases
        mem[0] = 1
        mem[1] = 1

        #calculating results for every number <= n and storing in mem array
        for i in range (2,n + 1):
            #for each node we need to consider every case 
            #wehere 2 <= j <= i is the root node and 
            #add them up to get all of the combinations
            for j in range (1,i + 1):
                #recursively calculate left subtree times right subtree
                #to get all combinations for each root node
                mem[i] += mem[ j - 1] * mem[i - j]
        
        #return final result in stored array
        return mem[n]
            
        

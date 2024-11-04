class Solution {
    public int numTrees(int n) {
        //stores past results
        int [] mem = new int[n + 1];
        //sets base cases
        mem[0] = 1;
        mem[1] = 1;

        //calculating results for every number <= n
        for(int i = 2; i <= n;i++) {
            //for each node we need to consider every case 
            //wehere 2 <= j <= i is the root node and 
            //add them up to get all of the combinations
            for(int j = 1; j <= i;j++) {
                //recursively calculate left subtree times right subtree
                //to get all combinations for each root node
                mem[i] += mem[ j -1] * mem[i - j];
            }
        }
        //return final result
        return mem[n];

    }

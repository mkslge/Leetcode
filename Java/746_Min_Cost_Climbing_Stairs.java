class Solution {
    int [] minCost;
    public int minCostClimbingStairs(int[] cost) {
        minCost  = new int[cost.length + 1];
        Arrays.fill(minCost, -1);
        
        return dfs(cost.length, cost);
    }

    int dfs(int index, int [] cost) {
        if(index < 0) {
            return 0;
        }
        if(minCost[index] == -1) {
            int downOne = dfs(index - 1, cost);
            int downTwo = dfs(index - 2, cost);
            int costVal = index >= cost.length ? 0 : cost[index];
            minCost[index] = Math.min(downOne, downTwo) + costVal;
        }
        return minCost[index];
    }
}

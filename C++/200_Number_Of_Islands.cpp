class Solution {
public:
    vector<vector<bool>> visited;
    vector<vector<int>> adj;
    int numIslands(vector<vector<char>>& grid) {
        adj = {{1,0}, {0,1},{-1,0},{0, -1}};
        visited.resize(grid.size(), vector<bool>(grid[0].size(), false));
        int islandCount = 0;
        for(size_t i{}; i < grid.size();i++) {
            for(size_t j{}; j < grid[0].size();j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    markVisited(grid, i,j);
                    islandCount++;
                } 
            }
        }
        return islandCount;
    }

    void markVisited(vector<vector<char>>& grid, int i, int j) {
        if(i < 0 || i >= grid.size()
        || j < 0 || j >= grid[0].size()
        || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        for(auto& a : adj) {
            markVisited(grid, a[0] + i, a[1] + j);
        } 
    }
};

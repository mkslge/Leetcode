class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        if(edges.size() != n - 1) {
            return false;
        }
        std::vector<bool> visited(n, false);
        std::vector<std::vector<int>> adjs(n);
        //O(E )
        for(const auto& edge : edges) {
            //degrees[edge[1]]++;
            //degrees[edge[0]]++;
            adjs[edge[0]].push_back(edge[1]);
            adjs[edge[1]].push_back(edge[0]);
        }

        std::queue<int> q;
        q.push(0);
        visited[0] = true;
        int count = 0;
        //O(V + E)
        while(!q.empty()) {
            int vertex = q.front();
            q.pop();
            count++;
            for(const auto& adj : adjs[vertex]) {
                if(!visited[adj]) {
                    visited[adj] = true;
                    q.push(adj);
                }
            }
        }

        return n == count;
    }
};

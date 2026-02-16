class Solution {
public:
    void wallsAndGates(vector<vector<int>>& rooms) {
        for(size_t i{}; i < rooms.size();i++) {
            for(size_t j{}; j < rooms[0].size();j++) {
                if(rooms[i][j] == 0) {
                    bfs(rooms, i, j, 0);
                }
            }
        }
    }


    void bfs(vector<vector<int>>& r, int i, int j, int c) {
        queue<pair<int, int>> q;
        q.push(pair{i + 1,j});
        q.push(pair{i,j + 1});
        q.push(pair{i - 1,j});
        q.push(pair{i,j - 1});


        while(!q.empty()) {
            int qSize = q.size();
            for(int k = 0; k < qSize;k++) {
                
                pair<int, int> p = q.front();
                q.pop();
                if(validPath(r, p.first, p.second, c)) {
                    r[p.first][p.second] = c + 1;
                    q.push(pair{p.first + 1, p.second});
                    q.push(pair{p.first, p.second + 1});
                    q.push(pair{p.first - 1, p.second});
                    q.push(pair{p.first, p.second - 1});
                }
                
            }
            
            c++;
        }

    }
    bool validPath(vector<vector<int>>& r, int i, int j, int c) {
        if(i < 0 || i >= r.size()
        || j < 0 || j >= r[0].size()
        || r[i][j] == -1 || r[i][j] == 0
        || c + 1 >= r[i][j]) {
            return false;
        }
        return true;
    }


};

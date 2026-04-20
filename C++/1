class Solution {
public:
    std::vector<std::vector<int>> to_move{{1,2},{2,1}, {-1,2}, {-2,1},
        {1,-2}, {2, -1}, {-1,-2}, {-2, -1}
    };
    int minKnightMoves(int x, int y) {
        x = abs(x);
        y = abs(y);
        std::queue<pair<int, int>> q;
        std::unordered_set<pair<int, int>, pair_hash > visited;
        int moves = 0;

        q.push(std::make_pair(0,0));
        visited.insert(std::make_pair(0,0));
        while(!q.empty()) {
            int size = q.size();
            for(auto i = 0; i < size;i++) {
                auto p = q.front();

                q.pop();
                
                if(p.first == x && p.second == y) {
                    return moves;
                }

                for(auto adj : to_move) {
                    int cx = adj[0] + p.first;
                    int cy = adj[1] + p.second;
                    if(!visited.contains(std::make_pair(cx, cy))
                    && cx >= -2 && cy >= -2) {
                        auto new_p = std::make_pair(cx, cy);
                        q.push(new_p);
                        visited.insert(new_p);
                    }
                }

            }
            moves++;
        }
        return moves;
    }

    struct pair_hash {
    inline size_t operator()(const pair<int, int> & v) const {
        return v.first * 31 + v.second * 2;
    };
};


    

    


};

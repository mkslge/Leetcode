class Solution {
public:

    std::vector<std::vector<int>> mem;
    std::string g1;
    std::string g2;
    std::string g3;
    bool isInterleave(string s1, string s2, string s3) {
        if(s1.size() + s2.size() != s3.size()) {
            return false;
        }
        
        mem = 
        std::vector<std::vector<int>>(s1.size() + 1, std::vector<int>(1 + s2.size(), -1));
        g1 = s1;
        g2 = s2;
        g3 = s3;
        
        return dfs(0,0);
    }

    bool dfs(int i, int j) {
        if(i + j == g3.size()) {
            return true;
        } else if(mem[i][j] != -1) {
            return mem[i][j];
        }

        int f1 = g3[i + j] == g1[i] ? dfs(i + 1, j) : 0;
        int f2 = g3[i + j] == g2[j] ? dfs(i, j + 1) : 0;

  
        mem[i][j] = f1 || f2 ? 1 : 0;

        return f1 == 1 || f2 == 1;
    }
};

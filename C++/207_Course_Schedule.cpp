class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        std::vector<int> degrees(numCourses, 0);
        std::vector<std::vector<int>> adjs(numCourses);
        // O(E)
        for(const auto& prereq : prerequisites) {
            degrees[prereq[0]]++;
            adjs[prereq[1]].push_back(prereq[0]);
        }

        std::queue<int> q;
        //O(V)
        for(auto i = 0; i < numCourses;i++) {
            if(degrees[i] == 0) {
                q.push(i);
            }
        }

        int count = 0;
        //O(V + E)
        while(!q.empty()) {
            int course = q.front();
            q.pop();
            count++;
            for(const auto& adj : adjs[course]) {
                degrees[adj]--;
                if(degrees[adj] == 0) {
                    q.push(adj);
                }
            }
        }

        return count == numCourses;
    }
};

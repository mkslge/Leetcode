class ZigzagIterator {
public:
    vector<vector<int>> vecs;
    vector<int> idxs;
    int curr_idx;
    ZigzagIterator(vector<int>& v1, vector<int>& v2) {
        vecs.emplace_back(v1);
        vecs.emplace_back(v2);
        idxs = vector<int>{0,0};
        curr_idx = 0;
    }

    int next() {
        while(true) {

            if(idxs[curr_idx] < vecs[curr_idx].size()) {
                int sol = vecs[curr_idx][idxs[curr_idx]];

                idxs[curr_idx]++;
                curr_idx = (curr_idx + 1) % idxs.size();
                
                return sol;
            } else {
                curr_idx = (curr_idx + 1) % idxs.size();
            }
        }
    }

    bool hasNext() {
        for(int i = 0 ; i < idxs.size();i++) {
            if(idxs[i] < vecs[i].size()) {
                return true;
            }
        }
        return false;
    }
};

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i(v1, v2);
 * while (i.hasNext()) cout << i.next();
 */

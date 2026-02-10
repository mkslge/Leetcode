class TimeMap {
public:
    unordered_map<string, vector<pair<int, string>>> m;
    TimeMap() {
        
    }
    
    void set(string key, string value, int timestamp) {
        m[key].push_back(std::make_pair(timestamp, value));
    }
    
    string get(string key, int timestamp) {
        if(!m.contains(key)) {
            return "";
        }
        vector<pair<int, string>>& vec = m[key];
        int l = 0;
        int r = vec.size() - 1;
        string ans = "";
        while(l <= r) {
            int mid = (r + l) / 2;
            int ts_prev = vec[mid].first;
            if(ts_prev <= timestamp) {
                ans = vec[mid].second;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return ans;
    }
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */

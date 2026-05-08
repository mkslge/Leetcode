class Solution {
public:
    bool mergeTriplets(vector<vector<int>>& triplets, vector<int>& target) {
        auto filtered = triplets | std::views::filter([target](std::vector<int>& triplet) {
            return triplet[0] <= target[0] && triplet[1] <= target[1]
            && triplet[2] <= target[2];
        });

        std::vector<bool> found(3,false);
        for(const auto& triplet : filtered) {
            for(int i = 0; i < 3;i++) {
                if(triplet[i] == target[i]) {
                    found[i] = true;
                }
            }
        }
        return found[0] && found[1] && found[2];
    }
};

class Solution {
public:
    long long subArrayRanges(vector<int>& nums) {
        stack<pair<long, long>> stack;
        vector<long long> mins(nums.size());
        vector<long long> maxs(nums.size());
        long long sol = 0;

        for(int i = 0;i < nums.size();i++) {
            //go until we find a number bigger than our current
            while(!stack.empty() && nums[i] > stack.top().first) {
                stack.pop();
            }
            //if stack is empty its our maximum
            if(stack.empty())  {
                maxs[i] = (long long)nums[i] * (i + 1);
            } else {
                //nums[i] will be our maximum until the next max
                maxs[i] = (nums[i] * (i - (stack.top().second))) + 
                //so we add it on top of nums[i] * the amount of subarrays
                maxs[stack.top().second];
            }
            //save the value and its index
            stack.push({nums[i],i});
        }
        //clear array
        while(!stack.empty()) {
            stack.pop();
        }

        for(int i =0 ; i < nums.size();i++) {
            //go until we find a number smaller than our current
            while(!stack.empty() && nums[i] < stack.top().first) {
                stack.pop();
            }
            //if its empty our current is the minimum for everything
            if(stack.empty()) {
                mins[i] = (long long)nums[i] * (i + 1);
            } else {
                //otherwise combine solutions again
                mins[i] = (nums[i] * (i - (stack.top().second))) 
                + mins[stack.top().second];
            }
            //save value and index for next go arounds
            stack.push({nums[i],i});
        }
        //for each rounds subtract max from min to get our range
        for(int i = 0; i < nums.size();i++) {
            sol = sol + maxs[i] - mins[i];
        }
        
        return sol;
    }
};

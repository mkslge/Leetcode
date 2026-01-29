class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        std::stack<int> stack;
        for(auto &token : tokens) {
            if(token == "+") {
                int secVal = stack.top();
                stack.pop();
                int firstVal = stack.top();
                stack.pop();
                stack.push(firstVal + secVal);

            } else if(token == "-") {
                int secVal = stack.top();
                stack.pop();
                int firstVal = stack.top();
                stack.pop();
                stack.push(firstVal - secVal);

            } else if(token == "*") {
                int secVal = stack.top();
                stack.pop();
                int firstVal = stack.top();
                stack.pop();
                stack.push(firstVal * secVal);

            } else if(token == "/") {
                int secVal = stack.top();
                stack.pop();
                int firstVal = stack.top();
                stack.pop();
                stack.push(firstVal / secVal);

            } else {
                stack.push(std::stoi(token));
            }
        }

        return stack.top();

    }
};

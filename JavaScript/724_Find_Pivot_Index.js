/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function(nums) {
    //calculate prefix
    let prefix = new Array();
    prefix[0] = nums[0];
    let i = 0;

    for( i = 1; i < nums.length;i++) {
        prefix[i] = nums[i] + prefix[i - 1];
    }
    //calculate postfix
    let postfix = new Array();
    postfix[nums.length - 1] = nums[nums.length - 1];
    for( i = nums.length - 2; i >= 0;i--) {
        postfix[i] = nums[i] + postfix[i + 1];
    }
    //go from left and check if prefix == postfix
    for( i = 0; i < nums.length;i++) {
        //if they do return index
        if(prefix[i] == postfix[i]) {
            return i;
        }
    }
    //otherwise theres none so return -1
    return -1;
    
};

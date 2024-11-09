var reduce = function(nums, fn, init) {
    let acc = init
    let i = 0;
    for(i = 0; i < nums.length;i++) {
        acc = fn(acc, nums[i]);
    }
    return acc;
};

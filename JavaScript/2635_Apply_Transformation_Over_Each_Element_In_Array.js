/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let i = 0;
    //go through every element and apply function
    for(i = 0; i < arr.length;i++) {
        arr[i] = fn(arr[i],i);
    }
    //return updated function
    return arr;
};

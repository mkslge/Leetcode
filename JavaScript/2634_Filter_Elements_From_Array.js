/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    //make empty array
    let sol = new Array();
    let i = 0;
    for(i = 0; i < arr.length;i++) {
        //only add if the value fits the filter
        if(fn(arr[i],i)) {
            sol.push(arr[i]);
        }
    }
    //return filtered values
    return sol;
};

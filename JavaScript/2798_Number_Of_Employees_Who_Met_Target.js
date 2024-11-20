/**
 * @param {number[]} hours
 * @param {number} target
 * @return {number}
 */
var numberOfEmployeesWhoMetTarget = function(hours, target) {
    //iterate over and see if it meets target
    return hours.reduce( (a,c) => c >= target ? a + 1: a, 0);
};

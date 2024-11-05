#Write up: The code works by having a sliding window that checks
# if the current window contains a duplicate,
#if it does not, it goes further to find the largest possible window
# and checks if we have found a new longest substring
# if it does contain a duplicate, it cuts the substring off by one from
#the start and then checks again. The loop will end when the right pointer
# has reached the end of the string and then returns the maximum length
# we found. The time complexity of the algorithm is O(n) because each
#charcter is looked at at most twice, which is 2n times in total
# The space complexity is O(n) because the HashMap stores at most n
# characters if the string has no duplicates
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
    #initalizes left and right pointers and variable that tracks solution
        l,r,sol = 0,0,0
    #initalizes set that holds values present in current window
        curr_elems = set()
    #loop runs while we have not reached the end
        while r < len(s):
        #checks case where a duplicate element is found
            if s[r] in curr_elems:
            #cuts off front of window and tries again
                curr_elems.remove(s[l])
                l += 1
            else:
            #checks case where a duplicate is NOT found
            #adds new character to set of present characters
                curr_elems.add(s[r])
            #checks if new longest substring found
                sol = max(sol, r - l + 1)
            #increases window
                r += 1

    #returns solution
        return sol


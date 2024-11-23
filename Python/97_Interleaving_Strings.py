class Solution(object):
    def isInterleave(self, s1, s2, s3):
        #first we check if the lengths match up, if they dont we immediately knwo
        #it doesnt work
        if len(s1) + len(s2) != len(s3):
            return False
        #set that stores past results
        memo = {}

        def helper(s1_index, s2_index, s3_index):
            if s3_index == len(s3) :
                return True
            elif (s1_index,s2_index) in memo:
                return memo[(s1_index,s2_index)]
            
            #check if there is a way to get to the end using first string as next
            #character
            check1 = s1_index < len(s1) and s1[s1_index] == s3[s3_index] and helper(s1_index + 1,s2_index, s3_index + 1)


            #check if there is a way to get to the end using second string as next
            #character
            check2 = s2_index < len(s2) and s2[s2_index] == s3[s3_index] and helper(s1_index,s2_index + 1, s3_index + 1)

            #save our result
            memo[(s1_index, s2_index)] = check1 or check2
            #and then return it
            return check1 or check2

        #return function starting at beginning for all strings
        return helper(0,0,0)

        

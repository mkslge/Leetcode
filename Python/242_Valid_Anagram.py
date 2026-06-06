class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
            
        s_freqs = [0] * 26
        t_freqs = [0] * 26
        for i in range(len(s)):
            s_freqs[ord(s[i]) - ord('a')] += 1
        for i in range(len(t)):
            t_freqs[ord(t[i]) - ord('a')] += 1
        
        for i in range(0, 26):
            if s_freqs[i] != t_freqs[i]:
                return False
            
        return True
        

class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        def getAnagram(str):
            arr = [0] * 26
            for i in range(len(str)):
                arr[ord(str[i]) - ord('a')] += 1
            return tuple(arr)

        anagrams = {}

        for i in range(len(strs)):
            key = getAnagram(strs[i])

            if key not in anagrams:
                anagrams[key] = []
            anagrams[key].append(strs[i])
        
        return list(anagrams.values())

        

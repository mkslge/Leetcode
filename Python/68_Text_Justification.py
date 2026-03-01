class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        sol = []
        curr_words = []
        curr_size = 0
        for word in words:
            if len(curr_words) + curr_size + len(word) > maxWidth:
                # add the spaces
                gaps_to_fill = maxWidth - curr_size
                size = max(1, len(curr_words) - 1)
                for i in range(gaps_to_fill):
                    curr_words[i % size] += " "
                    print(curr_words)


                # add finished line to our list
                sol.append("".join(curr_words))
                curr_words = []
                curr_size = 0
            curr_words.append(word)
            curr_size += len(word)

        sol.append(" ".join(curr_words).ljust(maxWidth))
        return sol

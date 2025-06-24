class Solution {
    public int maxNumberOfBalloons(String text) {
        int [] chars = new int[26];
        //count up all characters
        for(char c : text.toCharArray()) {
            chars[c - 'a']++;
        }

        //since there are 2 l's and o's in balloon we have to have 2       
        //for each instance of balloon so we halve the amount that we have
        chars['l' - 'a'] /= 2;
        chars['o' - 'a'] /= 2;

        //now we check the mimumum value of our letters
        return Math.min(chars['b' - 'a'], 
        Math.min(chars['a' - 'a'], 
        Math.min(chars['l' - 'a'], 
        Math.min(chars['o' - 'a'], chars['n' - 'a']))));
    }
}

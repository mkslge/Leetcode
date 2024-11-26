class Solution {
    public int findChampion(int n, int[][] edges) {
        HashSet<Integer> undefeated = new HashSet<>();
        //add all possible vertices into a set
        for(int i = 0 ; i < n;i++) {
            undefeated.add(i);
        }
        //if a vertice appears in curr[1], it means it lost
        //so it is not a champion ):
        for(int [] curr: edges) {
            undefeated.remove(curr[1]);
        }
        //at the end we are only left with the champions
        //if the size isnt 1, there are multiple champions,
        //so we then return -1, otherwise, we return
        //the first element in the set using the iterator
        return undefeated.size() != 1 ? -1 : undefeated.iterator().next();
    }
}

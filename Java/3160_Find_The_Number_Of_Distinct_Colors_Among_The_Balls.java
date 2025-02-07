class Solution {

    public int[] queryResults(int limit, int[][] queries) {
        //color and amount
        HashMap<Integer, Integer> map = new HashMap<>();
        //which ball has which color
        HashMap<Integer, Integer> ballToColor = new HashMap<>();
        int currAmount = 0;
        int [] sol = new int[queries.length];
        
        for(int i = 0; i < queries.length;i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            //we have have a new color we increment the amount
            if(!map.containsKey(color)) {
                currAmount++;
            }
            //add the color to the count of the color
            map.put(color, map.getOrDefault(color,0) + 1);
            //if the ball previously had a color remove that color
            if(ballToColor.containsKey(ball)) {
                //if theres only one of it we remove it otherwise we 
                //decrement it
                int oldColor = ballToColor.get(ball);
                if(map.get(oldColor) == 1) {
                    map.remove(oldColor);
                    currAmount--;
                } else {
                    map.put(oldColor, map.get(oldColor) - 1);
                }
            }
            //replace it with new color
            ballToColor.put(ball, color);
            //update solution array
            sol[i] = currAmount;
        }   
        return sol;
    }
}

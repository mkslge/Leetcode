class Solution {
    int [] potionsG;
    long successG;
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        //sort potions so we can perform binary search
        Arrays.sort(potions);
        //set global variables
        potionsG = potions;
        successG = success;
        //go through every spell and perform binary search
        for(int i = 0; i < spells.length;i++) {
            //use same array to save space
            spells[i] = binarySearch(spells[i]);
        }   
        //return same spells array
        return spells;

    }
    public int binarySearch(int spell) {  
        //set left and right pointers  
        int left = 0, right = potionsG.length - 1;

        while(left <= right) {
            //get middle of subsection
            int m = (left + right) / 2;
            //if the spell is powerful we can lower our search
            if((long)spell * potionsG[m] >= successG) {
                right = m - 1;
            }  else {
                //otherwise we'll have to search for more powerful spells
                left = m + 1;
            }
        }
        //then we can return the section of the array that has powerful spells
        return potionsG.length - left;
    }
    
}

class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        //while w'ere not at the end and we're going to require a carry
        while(i >= 0 && digits[i] == 9 ) {
            digits[i] = 0;
            i--;
        }
        //if there is still a carry and we've made it to the end
        //the start needs to be a 1
        if(i < 0) {
            int []arr = new int[digits.length + 1];
            arr[0] = 1;
            return arr;
        } else {  
            //if theres no carry we just add one to the end :) 
            digits[i]++;
            return digits;
        }

    }
}

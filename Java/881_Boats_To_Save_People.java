class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //sort array so we can combine the least and most weighing people
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while(left <= right) {
            //check if they can both fit in the boat
            if(people[left] + people[right] <= limit) {
                //if they can we want to move the left as well as right
                left++;
            } 
            //if they cant we only want to fit the heaviest person in the boat
            right--;
            boats++;
        }

        //if there is one person left over we want to add him to a new boat
        if(left == right) {
            boats++;
        }
        return boats;
    }
}

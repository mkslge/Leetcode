class SmallestInfiniteSet {
    //priority queue that stores values below the minimum value
    PriorityQueue<Integer> pq;
    //integer that stores the minimum value 
    int smallest;
    public SmallestInfiniteSet() {
        //initalizes default value
        pq = new PriorityQueue<>();
        //1 is the smallest positive integer
        smallest = 1;
    }
    
    public int popSmallest() {
        //if the prioity queue is empty we return the smallest value from our pointer and
        //then also increment it
        if(pq.isEmpty()) {
            smallest++;
            return smallest - 1;
        } else {
            //otherwise get the minimum value from our min heap
            return pq.remove();
        }
    }
    
    //in this function we check the if num < smallest first since it is an O(1) operation
    //which makes the best case O(1) instead of O(logn)
    public void addBack(int num) {
        //first we check that that value is less than our smallest
        //since all values above our smallest our implicitly in our infinite set
        //then we check that it isnt already in our min heap
        if(num < smallest && !pq.contains(num)) {
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

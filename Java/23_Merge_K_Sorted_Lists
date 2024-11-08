/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //make dummy node for storing solution
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        //boolean that tracks if we need to keep going
        boolean keepGoing = true;
        while(keepGoing) {
            keepGoing = false;
            int minIndex = -1;
            //go through all lists and get the list that has the minimum value
            for(int i = 0; i < lists.length;i++) {
                if(lists[i] != null) {
                    //if we found a non null list then we need to keep going
                    keepGoing = true;
                    //keep track of min index
                    if(minIndex == -1 || lists[minIndex].val > lists[i].val) {
                        minIndex = i;
                    }
                }
            }
            //update solution and increment list we used
            if(minIndex != -1) {
                curr.next = lists[minIndex];
                curr = curr.next;
                lists[minIndex] = lists[minIndex].next;
            }
        }
        //return solution
        return dummy.next;

    }
}

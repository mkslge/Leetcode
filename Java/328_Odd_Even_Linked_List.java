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
    public ListNode oddEvenList(ListNode head) {
        //create dummy nodes so we can access start of each list
        ListNode dummy = new ListNode(0);
        ListNode even = dummy;
        ListNode odd = new ListNode(0);
        ListNode sol = odd;


        //track if we are at even or odd
        boolean isEven = false;
        ListNode curr = head;



        //traverse linked list
        while(curr != null) {
            
            if(isEven) {
                ///set next even node
                even.next = curr;
                //update current
                curr = curr.next;
                //update even
                even = even.next;
                //make sure to cut new even node from old linked list
                even.next = null;
            } else {
                //set next odd node
                odd.next = curr;
                //update curr
                curr = curr.next;
                update odd
                odd = odd.next;
                //make sure to cut new oddnode from old linked list
                odd.next = null;
            }
            //invert isEven
            isEven = !isEven;
        }
        //connect odd and even lists
        odd.next = dummy.next;
        //return start of odd
        return sol.next;

    }
}

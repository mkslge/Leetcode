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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //carry keeps track of left overs
        int carry = 0;
        //make dummy node to store solution
        ListNode dummy = new ListNode();
        ListNode tail = dummy;


        //while nothing is null and carry has something we
        //need to keep adding
        while(l1 != null || l2 != null || carry != 0) {
            //add to current val list node one value
            int currVal = 0;
            if(l1 != null) {
                currVal += l1.val;
                l1 = l1.next;
            }
            //add to current val list two value
            if(l2 != null) {
                currVal += l2.val;
                l2 = l2.next;
            }
            //add carry
            currVal += carry;
            //get new carry
            carry = currVal / 10;
            //get current val
            currVal = currVal % 10;
            //make new node and keep going
            tail.next = new ListNode(currVal);
            tail = tail.next;

        }
        //return solution
        return dummy.next;
    }
}

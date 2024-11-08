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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //initalize dummy node and nodes that keep track of where we are at
        //in current lists
       ListNode dummy = new ListNode();
       ListNode c1 = list1;
       ListNode c2 = list2;
       ListNode curr = dummy;
        //keep going as long as both are not null
       while(c1 != null && c2 != null) {
        //check which node we want to add
            if(c1.val <= c2.val) {
                //add first node to solution
                curr.next = c1;
                c1 = c1.next;
            } else {
                //add 2nd node to solution
                curr.next = c2;
                c2 = c2.next;
            }
            //increment solution
            curr = curr.next;
       }
       //add leftovers of list that is not null
       if(c1 == null) {
        curr.next = c2;
       } else {
        curr.next = c1;
       }
       //return solution
       return dummy.next;
    }
}

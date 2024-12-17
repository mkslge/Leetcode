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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        //make slow and fast pointers to get halfway point
        ListNode fast = head;
        ListNode slow = head;
        //make slow previous for deletion later on
        ListNode slowPrev = null;
        
        //use slow fast method to get middle point of array
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slowPrev = slow;
            slow = slow.next;
        }
        //since we made sure array is at least length 2 we update previous to the next
        //to delete the node :)
        slowPrev.next = slow.next;
        return head;
        
    }
}

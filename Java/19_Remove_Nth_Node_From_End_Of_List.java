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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode countLength = head;
        int length = 0;
        //get node we need to delete
        while(countLength != null) {
            length++;
            countLength = countLength.next;
        }
        //delete node
        int target = length - n;
        ListNode curr = head;
        ListNode prev = null;
        int count = 0 ;
        //go to node
        while(count < target) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        //delete the node
        if(prev == null) {
            head = head.next;
        } else {
            prev.next = curr.next;
        }
        //return new head
        return head;
    }
}

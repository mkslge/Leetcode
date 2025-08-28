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
        //dummy node to keep track of start of solution
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int rem = 0;
        while(l1 != null || l2 != null || rem != 0) {
            //if they are we dont want to add anything but dont want
            //to get a nullptr exception
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;

            //we obviously can only move the pointer forward if they
            //aren't null
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;

            //add up the total including the remainder
            int total = l1Val + l2Val + rem;


            //only use the last digit
            ListNode newNode = new ListNode(total % 10); 
            

            //store the remainder for next round
            rem = total / 10;

            //save solution
            curr.next = newNode;
            curr = curr.next;
            
        }
        



        return dummy.next;
    }
}

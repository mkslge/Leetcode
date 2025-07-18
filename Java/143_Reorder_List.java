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
    public void reorderList(ListNode head) {

        //create deque 
        Deque<ListNode> deque = new ArrayDeque<>();

        //construct list as deque
        for(ListNode node = head; node != null; node = node.next) {
            
            deque.addLast(node);
        }

        //now using the deck first add the first
        ListNode curr = head;
        deque.removeFirst();

        while(!deque.isEmpty()) {
            //then add the last
            ListNode tail = deque.removeLast();
            curr.next = tail;
            curr = curr.next;

            //then add the first
            if(!deque.isEmpty()) {
                ListNode first = deque.removeFirst();
                curr.next = first;
                curr = curr.next;
            }

        }
        //then cut off the list at the end
        curr.next = null;

    }
}

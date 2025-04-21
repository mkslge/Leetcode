class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //save first node for later since this will later be our last node b4 cutoff
        ListNode saveHead = head;
        //check if there is even space to reverse next group
        ListNode lastNode = nullCheck(head, k);
        if(lastNode == null) {
            return head; //if not just exit
        } 

        ListNode nextGroup = lastNode.next; //next group will be right after 
        nextGroup = reverseKGroup(nextGroup, k); //reverse the next group first
        lastNode.next = null; //cut the list in half before reversing current group

        //reverse and put it back together
        ListNode ret = reverseList(head);
        saveHead.next = nextGroup;

        //return new list
        return ret;
    }
    public ListNode nullCheck(ListNode head, int k) {
        //k is one and head still isnt null return the head since its the cutoff point
        if(k == 1 && head != null) {
            return head;
        } else if(head == null) {
            //if its null return it
            return null;
        } else {
            //otherwise keep traversing
            return nullCheck(head.next, k - 1);
        }
    }

    public ListNode reverseList(ListNode head) {
        //if list is 1 or 0 nodes its already reversed
        if(head == null || head.next == null) {
            return head;
        }
        //recursively reverse list
        ListNode rest = reverseList(head.next);

        //swap order of first 2 nodes
        head.next.next = head;
        head.next = null;
        //return reversed list

        return rest;
    }
}

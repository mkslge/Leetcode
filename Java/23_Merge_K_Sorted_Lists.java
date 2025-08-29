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
        //check for edge case where we dont have any lsits
        if(lists.length == 0) {
            return null;
        }
        //keep merging the lists together until theres only one left
        while(lists.length > 1) {
            List<ListNode> temp = new ArrayList<>();
            for(int i = 0; i < lists.length; i+= 2) {
                //merge 2 lists next to eachother
                ListNode l1 = lists[i];
                ListNode l2 = i + 1 < lists.length ? lists[i + 1] : null;
                ListNode merged = mergeTwoLists(l1, l2);
                temp.add(merged);
            }
            //make the array the new bigger lists and keep merging
            lists = temp.toArray(new ListNode[0]);
        }
        //at the end we should have one huge list where everything is 
        //sorted
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(a != null && b != null) {
            if(a.val < b.val) {
                curr.next = a;
                a = a.next;

            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }

        if(a == null) curr.next = b;
        if(b == null) curr.next = a;

        return dummy.next;
    }
}

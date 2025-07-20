/* 
The idea here is to go through the list and keep adding the latest node to
the start of the list,
so at first the list will look like 
1 -> 2 -> 3 -> 4 -> 5
then
2 -> 1 -> 3 -> 4 -> 5
then
3 -> 2 -> 1 -> 4 -> 5
then
4 -> 3 -> 2 -> 1 -> 5
then finally
5 -> 4 -> 3 -> 2 -> 1

At this point we simply returning the "start" pointer
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, start = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = start;
            
            start = curr;
            curr = next;
        }


        return start;
    }
}

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverseList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        sol = None
        curr = head
        while curr:
            new_curr = curr.next
            curr.next = sol
            sol = curr
            curr = new_curr
        return sol
        

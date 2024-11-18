# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        #if k is negative we can return
        if k <= 0 or head is None:
            return head
        #get the size of the array
        size = 0
        curr = head
        while curr:
            size += 1
            curr = curr.next

        #if k mod size is 0 that means we can return orignal array
        k = k % size
        if k == 0:
            return head
        
        curr = head
        prev = None
        # otherwise we go to kth array
        for i in range(size - k ):
            prev = curr
            curr = curr.next
        #update array
        if prev:
            prev.next = None
    
        sol = curr
        while curr.next:
            curr = curr.next
        #update head
        curr.next = head
        
        return sol
        

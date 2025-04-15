struct ListNode* reverseList(struct ListNode* head) {
    //if size is less than 1 its already reversed
    if(!head || !head->next) {
        return head;
    }
    //recursively reverse sublist
    struct ListNode* rest = reverseList(head->next);

    //2nd node's next value is now 1st node (head)
    head->next->next = head;

    //head now should be the last node
    head->next = NULL;

    return rest;
}

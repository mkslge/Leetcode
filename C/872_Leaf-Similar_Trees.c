
 void dfs(struct TreeNode* curr, int list [], int *size) {
    //basecase
    if(!curr) {
        return;
    } else if(!curr->left && !curr->right) {
        //check if leaf
        list[(*size)++] = curr->val;

    } else {
        //recrusive calls
        dfs(curr->left, list,size);
        dfs(curr->right, list,size);
    }
}

bool same_list(int *list1, int* list2, int size) {
    //if both lists are empty we return null
    if(!list1 && !list2 ) {
        return true;
    } 
    //see if every item is the same
    int i;
    for(i = 0; i < size;i++) {
        if(list1[i] != list2[i]) {
            return false;
        }
    }
    //return true if it is
    return true;

}

bool leafSimilar(struct TreeNode* root1, struct TreeNode* root2) {
    int first_size = 0;
    int second_size = 0;
    int first_list[200], second_list[200];
    //call dfs on both lists
    dfs(root1, first_list, &first_size);
    dfs(root2, second_list, &second_size);
    //check if the sizes are different 
    if(first_size != second_size) {
        return false;
    }
    //if not return true if the lists are the same
    return same_list(first_list, second_list, first_size);

}


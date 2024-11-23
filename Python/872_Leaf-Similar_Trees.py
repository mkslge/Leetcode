class Solution(object):
    def leafSimilar(self, root1, root2):
        #this is a helper function that evaluates a tree
        def evalTree(root):
            #perform dfs on the tree and store leaves
            lst = []
            stack = []
            #get starting node
            stack.append(root)
            #iterate while theres still stack left
            while stack:
                #pop first value off
                curr = stack.pop()
                #if its a leaf add value to our list
                if not curr.left and not curr.right:
                    lst.append(curr.val)
                else:
                    #otherwise add children to our stack
                    if curr.left:
                        stack.append(curr.left)
                    if curr.right:
                        stack.append(curr.right)
            #at the end return the list
            return lst
        #evaluate both trees and check if the leaves are the same
        leaves1 = evalTree(root1)
        leaves2 = evalTree(root2)

        #return boolean
        return leaves1 == leaves2
        

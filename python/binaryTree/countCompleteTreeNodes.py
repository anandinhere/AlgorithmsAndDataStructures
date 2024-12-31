# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


from util.binarytreeutil import TreeNode

from binarytree import Node

from typing import Optional
class Solution:

    def countNodes1(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        if not root.left and not root.right:
            return 1

        return 1 + self.countNodes1(root.left) + self.countNodes1(root.right)

    def countNodes2(self, root: Optional[TreeNode]) -> int:

        if not root:
            return 0

        height = 0
        temp = root
        while temp:
            temp = temp.left
            height += 1

        leafCount = 0
        def countNodesFlag( root: Optional[TreeNode], currheight:int) -> None:
            nonlocal leafCount
            if not root:
                return


            if not root.left and not root.right and currheight==height:
                leafCount += 1


            countNodesFlag(root.left,currheight+1)
            countNodesFlag(root.right,currheight+1)


        countNodesFlag(root,1)




        return (2 ** (height-1)) -1 +  leafCount


    def countNodes(self, root: Optional[TreeNode]) -> int:

        if not root:
            return 0


        height = 0
        temp = root
        while temp:
            temp = temp.left
            height += 1




        leafCount = 0
        def checkexists(idx:int, height:int, root: Optional[TreeNode]) -> bool:

            max_nodes = 2**height - 1
            left = 0
            right = max_nodes

            for i in range(0,height):
                mid = left + (right - left) // 2
                if idx <= mid:
                    right = mid
                    root = root.left
                else:
                    left = mid + 1
                    root = root.right
            return root is not None


        height = height - 1
        max_nodes = 2**height-1
        left = 1
        right = max_nodes
        leaf_count = 1
        #pick the pivot
        while left<=right:
            mid = left + (right - left) // 2
            #check if a node exists at pivot
            if checkexists(mid,height,root):  #this checks if there is a node in mid
                left = mid + 1
                leaf_count += 1 #leaf_count is not the right answer. as the window goes down by half. but a value is present at "left"
            else:
                right = mid - 1
        #(2**(height -1 )) -1 +
        return  2**height-1 + left #is always good index + 1.


class LeetcodeSolution:
    def compute_depth(self, node: TreeNode) -> int:
        """
        Return tree depth in O(d) time.
        """
        d = 0
        while node.left:
            node = node.left
            d += 1
        return d

    def exists(self, idx: int, d: int, node: TreeNode) -> bool:
        """
        Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        Return True if last level node idx exists.
        Binary search with O(d) complexity.
        """
        left, right = 0, 2**d - 1
        for _ in range(d):
            pivot = left + (right - left) // 2
            if idx <= pivot:
                node = node.left
                right = pivot
            else:
                node = node.right
                left = pivot + 1
        return node is not None

    def countNodes(self, root: TreeNode) -> int:
        # if the tree is empty
        if not root:
            return 0

        d = self.compute_depth(root)
        # if the tree contains 1 node
        if d == 0:
            return 1

        # Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        # Perform binary search to check how many nodes exist.
        left, right = 1, 2**d - 1
        while left <= right:
            pivot = left + (right - left) // 2
            if self.exists(pivot, d, root):
                left = pivot + 1
            else:
                right = pivot - 1

        # The tree contains 2**d - 1 nodes on the first (d - 1) levels
        # and left nodes on the last level.
        return (2**d - 1) + left


rootNode = TreeNode.makeCompleteTreeFromPreOrder([0,1,2,3])
print(TreeNode.makePrettyTree(rootNode))
#print(rootNode)

s = Solution()
res = s.countNodes(rootNode)

print(res)


# s = LeetcodeSolution()
# res = s.countNodes(rootNode)
#
# print(res)

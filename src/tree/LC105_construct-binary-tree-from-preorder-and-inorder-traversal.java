//Given two integer arrays preorder and inorder where preorder is the preorder 
//traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
// 
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
//
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 16696 
//👎 637


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = preorder.length;

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, inorder, map, 0, n - 1, 0, n - 1);
    }

    private TreeNode build(int[] preorder, int[] inoreder, Map<Integer, Integer> map, int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }

        int rootVal = preorder[preL];
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftSubTreeSize = rootIndex - inL;

        root.left = build(preorder, inoreder, map, preL + 1, preL + leftSubTreeSize, inL, rootIndex - 1);
        root.right = build(preorder, inoreder, map, preL + leftSubTreeSize + 1, preR, rootIndex + 1, inR);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

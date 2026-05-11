//Given two integer arrays inorder and postorder where inorder is the inorder 
//traversal of a binary tree and postorder is the postorder traversal of the same 
//tree, construct and return the binary tree. 
//
// 
// Example 1: 
// 
// 
//Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: inorder = [-1], postorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder and postorder consist of unique values. 
// Each value of postorder also appears in inorder. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// postorder is guaranteed to be the postorder traversal of the tree. 
// 
//
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 8714 ?
//? 159


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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, postorder, map, 0, n - 1, 0, n - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, Map<Integer, Integer> map, int inL, int inR, int pL, int pR) {
        if (inL > inR || pL > pR) {
            return null;
        }

        int rootVal = postorder[pR];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        int leftSubtreeSize = rootIndex - inL;

        root.left = build(inorder, postorder, map, inL, rootIndex - 1, pL, pL + leftSubtreeSize - 1);
        root.right = build(inorder, postorder, map, rootIndex + 1, inR, pL + leftSubtreeSize, pR - 1);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

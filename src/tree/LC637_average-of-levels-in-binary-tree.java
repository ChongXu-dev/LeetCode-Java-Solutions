//Given the root of a binary tree, return the average value of the nodes on 
//each level in the form of an array. Answers within 10⁻⁵ of the actual answer will 
//be accepted.
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [3.00000,14.50000,11.00000]
//Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, 
//and on level 2 is 11.
//Hence return [3, 14.5, 11].
// 
//
// Example 2: 
// 
// 
//Input: root = [3,9,20,15,7]
//Output: [3.00000,14.50000,11.00000]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 55
//95 👎 352


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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            double sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
                sum += curr.val;
            }
            res.add(sum / size);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

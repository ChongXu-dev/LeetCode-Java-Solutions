//Given an array nums of distinct integers, return all the possible 
//permutations. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// 
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
//
// Related Topics Array Backtracking 👍 20916 👎 385


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] used;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums, new ArrayList());
        return res;
    }

    private void backtrack(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            path.add(nums[i]);
            used[i] = true;

            backtrack(nums, path);

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

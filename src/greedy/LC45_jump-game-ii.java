//You are given a 0-indexed array of integers nums of length n. You are 
//initially positioned at index 0. 
//
// Each element nums[i] represents the maximum length of a forward jump from 
//index i. In other words, if you are at index i, you can jump to any index (i + j) 
//where: 
//
// 
// 0 <= j <= nums[i] and 
// i + j < n 
// 
//
// Return the minimum number of jumps to reach index n - 1. The test cases are 
//generated such that you can reach index n - 1. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 
//step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,0,1,4]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// It's guaranteed that you can reach nums[n - 1]. 
// 
//
// Related Topics Array Dynamic Programming Greedy 👍 16490 👎 706


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * [Approach]:
 * Greedy Algorithm.
 * https://leetcode.cn/problems/jump-game-ii/
 * <p>
 * *[Complexity]:
 * -Time Complexity: O(n)
 * -Space Complexity: O(1)
 */
class Solution {
    public int jump(int[] nums) {
        int maxIndex = 0;
        int count = 0;
        int end = 0;//每一次范围的边界

        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);

            if (end == i) {
                count++;
                end = maxIndex;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

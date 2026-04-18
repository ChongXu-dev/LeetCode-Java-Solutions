//Given an array of positive integers nums and a positive integer target, 
//return the minimal length of a subarray whose sum is greater than or equal to target. 
//If there is no such subarray, return 0 instead. 
//
// 
// Example 1: 
//
// 
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem 
//constraint.
// 
//
// Example 2: 
//
// 
//Input: target = 4, nums = [1,4,4]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// 
//Follow up: If you have figured out the 
//O(n) solution, try coding another solution of which the time complexity is 
//O(n log(n)).
//
// Related Topics Array Binary Search Sliding Window Prefix Sum 👍 14425 👎 541


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);

                sum -= nums[left];
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

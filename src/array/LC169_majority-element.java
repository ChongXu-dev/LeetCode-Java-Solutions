//Given an array nums of size n, return the majority element. 
//
// The majority element is the element that appears more than ⌊n / 2⌋ times. 
//You may assume that the majority element always exists in the array. 
//
// 
// Example 1: 
// Input: nums = [3,2,3]
//Output: 3
// 
// Example 2: 
// Input: nums = [2,2,1,1,1,2,2]
//Output: 2
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// The input is generated such that a majority element will exist in the array. 
//
// 
//
// 
//Follow-up: Could you solve the problem in linear time and in 
//O(1) space?
//
// Related Topics Array Hash Table Divide and Conquer Sorting Counting 👍 22765 
//👎 825


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * [Approach]:
 * Boyer-Moore Voting Algorithm (摩尔投票法)
 *
 * * [Reference]:
 * - Wikipedia: https://zh.wikipedia.org/wiki/多数投票算法
 * - LeetCode CN: https://leetcode.cn/problems/majority-element/solutions/
 *
 * * [Complexity]:
 * -Time Complexity: O(n)
 * -Space Complexity: O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int candidate = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                candidate = nums[i];
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

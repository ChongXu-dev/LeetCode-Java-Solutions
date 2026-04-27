//Given an integer array nums and an integer k, return true if there are two 
//distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <
//= k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1], k = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: nums = [1,0,1,1], k = 1
//Output: true
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
//
// Related Topics Array Hash Table Sliding Window 👍 7529 👎 3328


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (!set.add(nums[right])) {
                return true;
            }

            while (right - left >= k) {
                set.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

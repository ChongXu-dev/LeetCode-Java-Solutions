//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
// Notice that the solution set must not contain duplicate triplets.
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not 
//matter.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 35498 👎 3280


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Focus on removing duplicate elements. !!!!!
 */

/**
 * [Approach]:
 * We use Sorting combined with Two Pointers to find unique triplets.
 * 1. Sort the input array `nums`. This is crucial for enabling the two-pointer technique and for easily skipping duplicate values.
 * 2. Iterate through the array with a fixed pointer `i` (from 0 to nums.length - 3).
 * - Early termination: If `nums[i] > 0`, break the loop (sum can never reach 0).
 * - Deduplication 1: If `nums[i] == nums[i-1]`, continue to skip duplicate starting numbers.
 * 3. Set two pointers for the remaining section: `left` at `i + 1` and `right` at the end of the array.
 * - Calculate `sum = nums[i] + nums[left] + nums[right]`.
 * - If `sum == 0`: Add the triplet to the result. Then move both pointers inward while skipping any identical adjacent values (Deduplication 2 & 3).
 * - If `sum < 0`: Increment `left` to increase the total sum.
 * - If `sum > 0`: Decrement `right` to decrease the total sum.
 * <p>
 * [Complexity]:
 * - Time Complexity: O(n^2), where n is the length of the array. Sorting takes O(n log n), and the nested two-pointer traversal takes O(n^2). The overall time is dominated by O(n^2).
 * - Space Complexity: O(log n) to O(n), depending on the sorting algorithm's implementation. Java's Arrays.sort() for primitives uses Dual-Pivot Quicksort, which requires O(log n) space. We generally do not count the output list in space complexity.
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;

                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

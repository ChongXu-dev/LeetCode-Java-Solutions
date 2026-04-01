//Given an array of integers nums and an integer target, return indices of the 
//two numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may 
//not use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// Only one valid answer exists. 
// 
//
// 
//Follow-up: Can you come up with an algorithm that is less than 
//O(n²)
// time complexity?
//
// Related Topics Array Hash Table 👍 68413 👎 2550


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * My Approach.
 */

class Solution {

    /**
     * [Approach 1]: Brute force
     * We use nested loops to check every possible pair of numbers in the array.
     * If the sum a pair equals the target, we return their indices.
     *
     * *[Complexity]:
     * -Time Complexity: O(n^2), where n is the length of the array.
     * -Space Complexity: O(1), as we do not use extra data structures.
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
    for(int i = 0; i < nums.length; i++){
        for(int j = i + 1; j < nums.length; j++){
            if(nums[i] + nums[j] == target){
                return new int[] {i,j};
            }
        }
    }
    return new int[0];
    }

    /**
     * [Approach 2]: HashMap
     * We use a HashMap to store the numbers we have visited and their indices.
     * While iterating, we calculate the complement(target - current number).
     * If the map contains the complement, we return their indices immediately.
     *
     * *[Complexity]:
     * -Time Complexity: O(n), as we traverse the array only once.
     * -Space Complexity: O(n), for storing elements in the HashMap.
     */
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if( map.containsKey(target - nums[i])){
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

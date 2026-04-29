//You are given a sorted unique integer array nums. 
//
// A range [a,b] is the set of all integers from a to b (inclusive). 
//
// Return the smallest sorted list of ranges that cover all the numbers in the 
//array exactly. That is, each element of nums is covered by exactly one of the 
//ranges, and there is no integer x such that x is in one of the ranges but not in 
//nums. 
//
// Each range [a,b] in the list should be output as: 
//
// 
// "a->b" if a != b 
// "a" if a == b 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]
//Explanation: The ranges are:
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// Example 2: 
//
// 
//Input: nums = [0,2,3,4,6,8,9]
//Output: ["0","2->4","6","8->9"]
//Explanation: The ranges are:
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// All the values of nums are unique. 
// nums is sorted in ascending order. 
// 
//
// Related Topics Array 👍 4546 👎 2388


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = i;
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            StringBuilder sb = new StringBuilder();
            if (start == i) {
                sb.append(nums[start]);
            } else {
                sb.append(nums[start]).append("->").append(nums[i]);
            }

            res.add(sb.toString());
        }
        return res;
    }


    public List<String> summaryRangesFirst(int[] nums) {
        int left = 0;
        int right = 1;
        List<String> res = new ArrayList<>();

        while (right <= nums.length) {
            while (right < nums.length && nums[right] == 1 + nums[right - 1]) {
                right++;
            }

            if (right == left + 1) {
                res.add(Integer.toString(nums[left]));
            } else {
                res.add(nums[left] + "->" + nums[right - 1]);
            }

            left = right;
            right = left + 1;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

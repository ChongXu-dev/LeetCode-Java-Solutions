//Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
// 
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack ?
//? 36416 👎 702


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxL = 0;
        int maxR = 0;
        int total = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxL) {
                    maxL = height[left];
                } else {
                    total += maxL - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxR) {
                    maxR = height[right];
                } else {
                    total += maxR - height[right];
                }
                right--;
            }
        }

        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

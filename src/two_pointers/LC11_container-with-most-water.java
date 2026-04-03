//You are given an integer array height of length n. There are n vertical lines
//drawn such that the two endpoints of the iᵗʰ line are (i, 0) and (i, height[i]).
// 
//
// Find two lines that together with the x-axis form a container, such that the 
//container contains the most water. 
//
// Return the maximum amount of water a container can store. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
// 
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can 
//contain is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics Array Two Pointers Greedy 👍 34170 👎 2206


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * [Approach]:
 * We use the two pointers technique, starting with pointers at the beginning('left'),
 * and the end('right') of the array.
 * Since the area of the container is limited by the shorter line, we calculate the
 * current area and update the maximum area.
 * To maximize the area, we must safely discard the shorter line. Therefore:
 * - If the 'left' line is shorter, we move the 'left' pointer inward (left++).
 * - If the 'right' line is shorter, we move the 'right' pointer inward (right--).
 * We repeat this process until the two pointers meet.
 * <p>
 * *[Complexity]:
 * -Time Complexity: O(n), where n is the length of the array, we traverse the array only once.
 * -Space Complexity: O(1), we do not use extra data structures.
 */
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] > height[right]) {
                maxArea = Math.max(maxArea, (right - left) * height[right]);
                right--;
            } else {
                maxArea = Math.max(maxArea, (right - left) * height[left]);
                left++;
            }
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

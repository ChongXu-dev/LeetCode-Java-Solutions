//There are n children standing in a line. Each child is assigned a rating 
//value given in the integer array ratings. 
//
// You are giving candies to these children subjected to the following 
//requirements: 
//
// 
// Each child must have at least one candy. 
// Children with a higher rating get more candies than their neighbors. 
// 
//
// Return the minimum number of candies you need to have to distribute the 
//candies to the children. 
//
// 
// Example 1: 
//
// 
//Input: ratings = [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1, 
//2 candies respectively.
// 
//
// Example 2: 
//
// 
//Input: ratings = [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2, 
//1 candies respectively.
//The third child gets 1 candy because it satisfies the above two conditions.
// 
//
// 
// Constraints: 
//
// 
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
//
// Related Topics Array Greedy 👍 9334 👎 850


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * [Approach]:
 * Greedy Algorithm.
 * https://leetcode.cn/problems/candy/solutions/
 * <p>
 * *[Complexity]:
 * -Time Complexity: O(n)
 * -Space Complexity: O(n)
 */
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }

        int[] candies = new int[ratings.length];
        for (int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int total = 0;
        for (int count : candies) {
            total += count;
        }

        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

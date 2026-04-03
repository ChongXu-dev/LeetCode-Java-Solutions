//Given a string s, find the length of the longest substring without duplicate 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3. Note that "bca" and 
//"cab" are also correct answers.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
//
//
//
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 44862 👎 2210


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * [Approach]:
 * We use the Sliding Window technique with two pointers('left' and 'right').
 * We maintain a HashSet to store the unique characters in the current window.
 * As we traverse the string with the ‘right' pointers：
 * -If the character is not in the set, we add it,
 * calculate the length of current window and update the maxium length.
 * -If the character is in the set, we continously shrink the window from the 'left' pointer
 * by removing characters from the set until the duplicate is eliminated.
 * <p>
 * *[Complexity]:
 * -Time Complexity: O(n), where n is the length of the string, each character is visited at most twice.
 * -Space Complexity: O(min(m,n)), where m is the size of the character set.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

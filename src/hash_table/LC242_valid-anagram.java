//Given two strings s and t, return true if t is an anagram of s, and false
//otherwise. 
//
// 
// Example 1: 
//
// 
// Input: s = "anagram", t = "nagaram" 
// 
//
// Output: true 
//
// Example 2: 
//
// 
// Input: s = "rat", t = "car" 
// 
//
// Output: false 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s and t consist of lowercase English letters. 
// 
//
// 
// Follow up: What if the inputs contain Unicode characters? How would you
//adapt your solution to such a case? 
//
// Related Topics Hash Table String Sorting 👍 14320 👎 474


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * [Approach]:
 * We use an Integer array called 'record' to count how many times every letter appeared,
 * we increment the count for characters in 's', and decrement for 't'.
 * If every element of the array is 0, return true,
 * if not, return false.
 * <p>
 * *[Complexity]:
 * -Time Complexity: O(n), as we only traverse the String only once.
 * -Space Complexity: O(1), although we use an array to record, but it is constant(26).
 */
class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a'] += 1;
            record[t.charAt(i) - 'a'] -= 1;
        }

        for (int i = 0; i < 26; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

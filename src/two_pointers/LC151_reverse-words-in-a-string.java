//Given an input string s, reverse the order of the words. 
//
// A word is defined as a sequence of non-space characters. The words in s will 
//be separated by at least one space. 
//
// Return a string of the words in reverse order concatenated by a single space.
// 
//
// Note that s may contain leading or trailing spaces or multiple spaces 
//between two words. The returned string should only have a single space separating the 
//words. Do not include any extra spaces. 
//
// 
// Example 1: 
//
// 
//Input: s = "the sky is blue"
//Output: "blue is sky the"
// 
//
// Example 2: 
//
// 
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing 
//spaces.
// 
//
// Example 3: 
//
// 
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single 
//space in the reversed string.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s contains English letters (upper-case and lower-case), digits, and spaces ' 
//'. 
// There is at least one word in s. 
// 
//
// 
// Follow-up: If the string data type is mutable in your language, can you 
//solve it in-place with O(1) extra space? 
//
// Related Topics Two Pointers String 👍 10552 👎 5588


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int p = chars.length - 1;
        StringBuilder characters = new StringBuilder();

        while (p >= 0) {
            while (p >= 0 && chars[p] == ' ') {
                p--;
            }

            if (p < 0) {
                break;
            }

            int p1 = p - 1;
            while (p1 >= 0 && chars[p1] != ' ') {
                p1--;
            }

            characters.append(chars, p1 + 1, p - p1).append(' ');
            p = p1;
        }

        if (characters.length() > 0) {
            characters.setLength(characters.length() - 1);
        }

        return characters.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// Every close bracket has a corresponding open bracket of the same type. 
// 
//
// 
// Example 1: 
//
// 
// Input: s = "()" 
// 
//
// Output: true 
//
// Example 2: 
//
// 
// Input: s = "()[]{}" 
// 
//
// Output: true 
//
// Example 3: 
//
// 
// Input: s = "(]" 
// 
//
// Output: false 
//
// Example 4: 
//
// 
// Input: s = "([])" 
// 
//
// Output: true 
//
// Example 5: 
//
// 
// Input: s = "([)]" 
// 
//
// Output: false 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of parentheses only '()[]{}'. 
// 
//
// Related Topics String Stack 👍 27864 👎 2003


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * [Approach]:
 * We use a Stack to keep track of the opening brackets.
 * 1. Iterate through the string character by character.
 * 2. If the character is an opening bracket ('(', '{', '['), push it onto the stack.
 * 3. If the character is a closing bracket (')', '}', ']'):
 * - Check if the stack is empty. If so, return false.
 * - Pop the top element from the stack and check if it matches the corresponding closing bracket. If not, return false.
 * 4. After the iteration, if the stack is empty, it means all brackets are matched properly, return true. Otherwise, return false.
 * <p>
 * [Complexity]:
 * - Time Complexity: O(n), where n is the length of the string. We traverse the string exactly once.
 * - Space Complexity: O(n). In the worst case (e.g., all opening brackets "((((("), the stack will store all characters.
 */
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '[' || temp == '{') {
                stack.push(temp);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (temp == ')' && top != '(') {
                    return false;
                } else if (temp == ']' && top != '[') {
                    return false;
                } else if (temp == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

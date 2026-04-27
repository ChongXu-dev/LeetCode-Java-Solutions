//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
// Follow up: Could you find an algorithm that runs in O(m + n) time? 
//
// Related Topics Hash Table String Sliding Window 👍 20234 👎 855


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (n > m) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        int minL = 0;
        int minR = 0;
        int left = 0;
        int right = 0;

        int needType = 0;
        int reachType = 0;
        char[] target = new char[128];
        char[] window = new char[128];
        for (int i = 0; i < n; i++) {
            if (target[(int) t.charAt(i)] == 0) {
                needType++;
            }
            target[(int) t.charAt(i)]++;
        }

        for (right = 0; right < m; right++) {
            int index = (int) s.charAt(right);
            if (target[index] > 0) {
                window[index]++;

                if (window[index] == target[index]) {
                    reachType++;
                }
            }

            while (reachType >= needType) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minL = left;
                    minR = right;
                }

                int leftIndex = (int) s.charAt(left);
                if (target[leftIndex] > 0) {
                    if (window[leftIndex] == target[leftIndex]) {
                        reachType--;
                    }
                    window[(leftIndex]--;
                }
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minL, minR + 1);
    }


    //效率过低此版本
    boolean isCovered(int[] window, int[] target) {
        for (int i = 0; i < window.length; i++) {
            if (window[i] < target[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindowOne(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) {
            return "";
        }

        int[] count = new int[128];
        int[] countCompare = new int[128];
        for (int i = 0; i < n; i++) {
            count[(int) t.charAt(i)]++;
        }

        int minIndexL = 0;
        int minIndexR = 0;
        int minLen = Integer.MAX_VALUE;

        int left = 0;

        int right = 0;
        for (right = 0; right < s.length(); right++) {
            if (count[(int) s.charAt(right)] != 0) {
                countCompare[(int) s.charAt(right)]++;
            }

            while (isCovered(countCompare, count)) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minIndexL = left;
                    minIndexR = right;
                }

                if (countCompare[(int) s.charAt(left)] > 0) {
                    countCompare[(int) s.charAt(left)]--;
                }
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minIndexL, minIndexR + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

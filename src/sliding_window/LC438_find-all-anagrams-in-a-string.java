//Given two strings s and p, return an array of all the start indices of p's 
//anagrams in s. You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 13222 👎 377


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Approach: Sliding Window + Frequency Array
 * * Authentic Learning Note:
 * - Initially tried nested loops (see `findAnagramsBruteForce` below), but it caused Time Limit Exceeded (TLE) and StringIndexOutOfBoundsException.
 * - Optimized by maintaining a sliding window of size p.length().
 * - Each time the window moves, just +1 for the new right char, and -1 for the old left char.
 * * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

class Solution {

    boolean check(int[] countOne, int[] countTwo) {
        for (int i = 0; i < 26; i++) {
            if (countOne[i] != countTwo[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }

        int[] countS = new int[26];
        int[] countP = new int[26];

        for (int i = 0; i < p.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countP[p.charAt(i) - 'a']++;
        }

        if (check(countS, countP)) {
            list.add(0);
        }

        for (int i = 1; i <= s.length() - p.length(); i++) {
            countS[s.charAt(i - 1) - 'a']--;
            countS[s.charAt(i - 1 + p.length()) - 'a']++;

            if (check(countS, countP)) {
                list.add(i);
            }
        }

        return list;
    }


    /*暴力解决*/
    public List<Integer> findByBruteForce(String s, String p) {
        int[] record = new int[26];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                record[s.charAt(i + j) - 'a']++;
                record[p.charAt(j) - 'a']--;
            }

            boolean isAnagram = true;
            for (int k = 0; k < 26; k++) {
                if (record[k] != 0) {
                    isAnagram = false;
                }
                record[k] = 0;
            }

            if (isAnagram) {
                list.add(i);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

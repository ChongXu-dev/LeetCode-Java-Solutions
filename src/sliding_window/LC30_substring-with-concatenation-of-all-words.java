//You are given a string s and an array of strings words. All the strings of 
//words are of the same length. 
//
// A concatenated string is a string that exactly contains all the strings of 
//any permutation of words concatenated. 
//
// 
// For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", 
//"cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not 
//a concatenated string because it is not the concatenation of any permutation of 
//words. 
// 
//
// Return an array of the starting indices of all the concatenated substrings 
//in s. You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
// Input: s = "barfoothefoobarman", words = ["foo","bar"] 
// 
//
// Output: [0,9] 
//
// Explanation: 
//
// The substring starting at 0 is "barfoo". It is the concatenation of ["bar",
//"foo"] which is a permutation of words. The substring starting at 9 is "foobar". 
//It is the concatenation of ["foo","bar"] which is a permutation of words. 
//
// Example 2: 
//
// 
// Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"] 
//
// 
//
// Output: [] 
//
// Explanation: 
//
// There is no concatenated substring. 
//
// Example 3: 
//
// 
// Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"] 
// 
//
// Output: [6,9,12] 
//
// Explanation: 
//
// The substring starting at 6 is "foobarthe". It is the concatenation of [
//"foo","bar","the"]. The substring starting at 9 is "barthefoo". It is the 
//concatenation of ["bar","the","foo"]. The substring starting at 12 is "thefoobar". It is 
//the concatenation of ["the","foo","bar"]. 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// s and words[i] consist of lowercase English letters. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 2659 👎 441


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> mapBackup = new HashMap<>();

        for (String word : words) {
            mapBackup.put(word, mapBackup.getOrDefault(word, 0) + 1);
        }

        int len = words[0].length();
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            int count = 0;
            map.clear();//每一次开始要记得清空

            while (right <= s.length() - len) {
                String tempString = s.substring(right, right + len);
                if (mapBackup.containsKey(tempString)) {
                    map.put(tempString, map.getOrDefault(tempString, 0) + 1);
                    count++;

                    while (map.get(tempString) > mapBackup.get(tempString)) {
                        String temp = s.substring(left, left + len);
                        int tempCount = map.get(temp);
                        if (tempCount > 1) {
                            map.put(temp, tempCount - 1);
                        } else {
                            map.remove(temp);
                        }

                        left += len;
                        count--;
                    }

                    if (count == words.length) {
                        result.add(left);
                    }

                    right += len;
                } else {
                    right += len;
                    left = right;
                    count = 0;
                    map.clear();
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

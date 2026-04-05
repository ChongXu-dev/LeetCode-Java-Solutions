//You are given the heads of two sorted linked lists list1 and list2. 
//
// Merge the two lists into one sorted list. The list should be made by
//splicing together the nodes of the first two lists.
//
// Return the head of the merged linked list. 
//
// 
// Example 1: 
// 
// 
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
// 
//
// Example 2: 
//
// 
//Input: list1 = [], list2 = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: list1 = [], list2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both lists is in the range [0, 50]. 
// -100 <= Node.val <= 100 
// Both list1 and list2 are sorted in non-decreasing order. 
// 
//
// Related Topics Linked List Recursion 👍 24945 👎 2439


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


/**
 * [Approach]:
 * We use a "Dummy Node" to simplify the merging process and avoid edge cases at the head.
 * 1. Create a `dummy` node and a `current` pointer initialized to this dummy node.
 * 2. Iterate while both `list1` and `list2` are not null:
 * - Compare the values of `list1` and `list2`.
 * - Attach the smaller node to `current.next`.
 * - Move the chosen list's pointer to its next node.
 * - Move the `current` pointer forward.
 * 3. Once the loop ends, one of the lists might still have remaining nodes. We simply append the rest of the non-empty list to `current.next`.
 * 4. Return `dummy.next`, which is the actual head of the newly merged list.
 * <p>
 * [Complexity]:
 * - Time Complexity: O(n + m), where n and m are the lengths of list1 and list2. We traverse each node at most once.
 * - Space Complexity: O(1). We only use a few pointers for rewiring, without allocating any new nodes.
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                current.next = list2;
                break;
            }
            if (list2 == null) {
                current.next = list1;
                break;
            }

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

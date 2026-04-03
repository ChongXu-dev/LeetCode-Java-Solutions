//Given the head of a singly linked list, reverse the list, and return the 
//reversed list. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2]
//Output: [2,1]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is the range [0, 5000]. 
// -5000 <= Node.val <= 5000 
// 
//
// 
// Follow up: A linked list can be reversed either iteratively or recursively. 
//Could you implement both? 
//
// Related Topics Linked List Recursion 👍 24476 👎 575


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
 * We use an iterative approach to reverse the linked list in-place.
 * We maintain a 'prev' pointer(initially null) and a 'curr' pointer(initially head).
 * In each iteration, we temporarily store the next node(curr.next) to avoid losing the rest of the list.
 * Then, we reverse the current node's pointer to point back to 'prev', and move both 'prev' and 'curr' one step forward.
 *
 * *[Complexity]:
 * -Time Complexity: O(n), where n is the number of nodes in the list, we traverse the list only once.
 * -Space Complexity: O(1), as we only use a few extra pointers without allocating new nodes.
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev, curr, next;
        prev = null;
        curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

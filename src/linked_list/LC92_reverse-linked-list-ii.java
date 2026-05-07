//Given the head of a singly linked list and two integers left and right where 
//left <= right, reverse the nodes of the list from position left to position 
//right, and return the reversed list. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
// 
//
// Example 2: 
//
// 
//Input: head = [5], left = 1, right = 1
//Output: [5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//Follow up: Could you do it in one pass?
//
// Related Topics Linked List 👍 12977 👎 788


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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        curr = pre.next;

        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }

    public ListNode reverseBetweenOne(ListNode head, int left, int right) {
        if (left == right || head == null) {
            return head;
        }

        ListNode preLeft = null;
        ListNode leftNode = head;
        ListNode rightNode = head;

        for (int i = 0; i < right - left; i++) {
            rightNode = rightNode.next;
        }

        for (int i = 0; i < left - 1; i++) {
            preLeft = leftNode;
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        ListNode next = null;
        ListNode pre = rightNode.next;
        rightNode.next = null;

        while (leftNode != null) {
            next = leftNode.next;
            leftNode.next = pre;
            pre = leftNode;
            leftNode = next;
        }

        if (preLeft == null) {
            return pre;
        }
        preLeft.next = rightNode;

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

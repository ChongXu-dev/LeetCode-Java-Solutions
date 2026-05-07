//Given the head of a linked list, rotate the list to the right by k places. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
// 
//
// Example 2: 
// 
// 
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 500]. 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics Linked List Two Pointers 👍 11455 👎 1557


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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k = k % len;
        if (k == 0) {
            return head;
        }
        tail.next = head;

        for (int i = 0; i < len - k; i++) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;

        return head;
    }

    public ListNode rotateRightOne(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = 0;
        ListNode pre = head;

        while (pre != null) {
            len++;
            pre = pre.next;
        }

        k = k % len;
        if (k == 0) {
            return head;
        }

        pre = dummy;
        for (int i = 0; i < len - k; i++) {
            pre = pre.next;
        }

        ListNode nextHead = pre.next;
        dummy.next = nextHead;
        pre.next = null;
        while (nextHead.next != null) {
            nextHead = nextHead.next;
        }
        nextHead.next = head;

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

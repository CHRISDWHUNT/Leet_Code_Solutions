/**
 * @author Chris Hunt
 * @version 1
 * @Problem: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8] <p>
 * Explanation: 342 + 465 = 807. <p>
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]<p>
 * Output: [0]<p>
 * Example 3:<p>
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * @Constraints: The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 * @Difficulty: Medium
 */
public class AddTwoNumbers {
    /**
     * Method to add numbers at the same position in a linked list.
     *
     * @param l1 the first node in a linked list.
     * @param l2 the first node in a linked list.
     * @return a ListNode corresponding to the first node in the new linked list of number summed.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overflow = (l1.val + l2.val) / 10;
        if ((l1.val + l2.val) == 10) overflow = 1;
        ListNode returnRoot = new ListNode((l1.val + l2.val) % 10);

        ListNode current = returnRoot;

        ListNode l1Cur = l1.next;
        ListNode l2Cur = l2.next;

        int num = 0;
        while (l1Cur != null || l2Cur != null) {
            if (l1Cur != null && l2Cur != null) {
                num = l1Cur.val + l2Cur.val + overflow;
                l1Cur = l1Cur.next;
                l2Cur = l2Cur.next;
            } else if (l1Cur != null && l2Cur == null) {
                num = l1Cur.val + overflow;
                l1Cur = l1Cur.next;
            } else if (l1Cur == null && l2Cur != null) {
                num = l2Cur.val + overflow;
                l2Cur = l2Cur.next;
            }
            current.next = new ListNode(num % 10);
            current = current.next;
            overflow = num / 10;
            if (num == 10) overflow = 1;
        }
        if (overflow > 0) current.next = new ListNode(overflow);
        return returnRoot;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
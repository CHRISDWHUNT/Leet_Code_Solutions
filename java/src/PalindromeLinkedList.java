import java.util.Objects;

/**
 * @author Chris Hunt
 * @version 1
 * @Problem: Given the head of a singly linked list, return true if it is a palindrome
 * or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,2,1]
 * Output: true<p>
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2]
 * Output: false
 * <p>
 * <p>
 * Follow up: Could you do it in O(n) time and O(1) space?
 * @Constraints: <p>
 * The number of nodes in the list is in the range [1, 105]. <p>
 * 0 <= Node.val <= 9
 * <p>
 * <p>
 * @Difficulty: Easy
 */
public class PalindromeLinkedList {
    /**
     * Determines if a singly-linked list represents a palindrome.
     *
     * @param head the first node in the list.
     * @return true if it is a palindrome or false otherwise.
     */
    public boolean isPalindrome(ListNode head) {
        StringBuilder forward = new StringBuilder();

        ListNode current = head;
        while (current != null) {
            forward.append(current.val);
            current = current.next;
        }

        return Objects.equals(forward.toString(), forward.reverse().toString());
    }

    //  Definition for singly-linked list.
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
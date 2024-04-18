import java.util.HashMap;

/**
 * @author Chris Hunt
 * @version 1
 * @Problem:Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * @Constraints: <p>
 * The number of nodes in the list is sz.
 * <p>
 * 1 <= sz <= 30
 * <p>
 * 0 <= Node.val <= 100
 * <p>
 * 1 <= n <= sz
 * <p>
 * @Difficulty: Medium
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * Removes the nth element from the back of a singly-linked list
     *
     * @param head the head of the list.
     * @param n    the position from the end of the item.
     * @return a list node representing the next linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> nodeIndexMap = new HashMap<>();

        ListNode temp = head;
        int index = 0;
        do {
            nodeIndexMap.put(index, temp);
            temp = temp.next;
            index++;
        } while (temp != null);

        if (nodeIndexMap.size() == 1) return null;

        ListNode prev = nodeIndexMap.get(nodeIndexMap.size() - 1 - n);
        ListNode next = nodeIndexMap.get(nodeIndexMap.size() - 1 - (n - 2));

        if (prev == null && next != null) return next;
        prev.next = next;

        return head;
    }

    // Definition for singly-linked list.
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
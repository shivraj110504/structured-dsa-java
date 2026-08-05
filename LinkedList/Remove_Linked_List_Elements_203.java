package LinkedList;

public class Remove_Linked_List_Elements_203 {
    public static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            while (head != null && head.val == val) {
                head = head.next;
            }
            ListNode curr = head;
            while (curr != null && curr.next != null) {
                if (curr.next.val == val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        int valToRemove = 6;

        Solution solution = new Solution();
        ListNode result = solution.removeElements(head, valToRemove);

        // Print the modified linked list
        ListNode current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println("null");
    }
}

package LinkedList;


public class Palindrome_Linked_List_234 {

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
    public static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null)
                return true;

            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode rev = reverseList(slow);
            ListNode p1 = head;
            ListNode p2 = rev;
            while (p2 != null) {
                if (p1.val != p2.val)
                    return false;
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;
        }

        private ListNode reverseList(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            ListNode next = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(head));
    }
}

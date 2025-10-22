package LinkedList;

import java.util.HashSet;

public class intersection_of_two_linked_lists_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        HashSet<ListNode> set = new HashSet<>();
        ListNode movA = headA;
        ListNode movB = headB;

        while (movA != null) {
            if (set.contains(movA))
                return movA;
            set.add(movA);
            movA = movA.next;
        }
        while (movB != null) {
            if (set.contains(movB))
                return movB;
            set.add(movB);
            movB = movB.next;
        }
        return null;
    }

    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     if (headA == null || headB == null)
    //         return null;

    //     ListNode a = headA;
    //     ListNode b = headB;

    //     // if a & b have different len, then we will stop the loop after second
    //     // iteration
    //     while (a != b) {
    //         // for the end of first iteration, we just reset the pointer to the head of
    //         // another linkedlist
    //         a = a == null ? headB : a.next;
    //         b = b == null ? headA : b.next;
    //     }

    //     return a;
    // }

    public static void main(String[] args) {
        intersection_of_two_linked_lists_160 solution = new intersection_of_two_linked_lists_160();
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode intersection = new ListNode(8);
        headA.next.next = intersection;
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;

        ListNode result = solution.getIntersectionNode(headA, headB);
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val); // Should print 8
        } else {
            System.out.println("No intersection");
        }
    }
}

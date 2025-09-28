package LinkedList;

import java.util.HashSet;

public class linked_list_cycle_141 {

    public boolean hasCycle(ListNode head) {
        if(head == null)return false;

        HashSet<ListNode> set = new HashSet<>();
        ListNode mover = head;
        while(mover != null){
            if(set.contains(mover)) return true;
            set.add(mover);
            mover = mover.next;
        }
        return false;
    }


// ************************** Another Approach **************************

    // public boolean hasCycle(ListNode head) {
    //     ListNode fast = head;
    //     ListNode slow = head;

    //     while (fast != null && fast.next != null) {
    //         fast = fast.next.next;
    //         slow = slow.next;

    //         if (fast == slow) {
    //             return true;
    //         }
    //     }

    //     return false;        
    // }
    

    public static void main(String[] args) {
        linked_list_cycle_141 solution = new linked_list_cycle_141();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create a cycle
        System.out.println(solution.hasCycle(head)); // Should print true
    }
}

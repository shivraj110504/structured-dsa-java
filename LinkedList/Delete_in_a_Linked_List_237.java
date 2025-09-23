package LinkedList;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Delete_in_a_Linked_List_237 {
   public void deleteNode(ListNode node) {
        // Edge case: if the node is null or the last node, we can't delete it
        if (node == null || node.next == null) return;

        // Copy the value of the next node into the current node
        node.val = node.next.val;

        // Skip over the next node (unlink it from the list)
        node.next = node.next.next;
    }



    public static void main(String[] args) {
        // You can test the deleteNode method here by creating a linked list and calling the method
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        Delete_in_a_Linked_List_237 solution = new Delete_in_a_Linked_List_237();
        solution.deleteNode(head.next); // Delete the node with value 5

        // Print the modified linked list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

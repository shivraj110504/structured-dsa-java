package LinkedList;

public class Remove_Duplicates_from_Sorted_List_83 {
    public ListNode deleteDuplicates(ListNode head) {
        // Create a dummy node that points to the head
        // (Not strictly necessary here, but often used in linked list problems
        // to simplify edge cases like deleting the first node)
        ListNode temp = new ListNode(-1);
        temp.next = head;

        // If the list is empty, just return
        if (head == null)
            return head;

        // Traverse through the list
        while (head.next != null) {
            // If current node and next node have the same value
            if (head.val == head.next.val) {
                // Skip the duplicate node by pointing current node
                // directly to the node after the duplicate
                head.next = head.next.next;
            } else {
                // Otherwise, move forward normally
                head = head.next;
            }
        }

        // Return the actual head of the modified list
        return temp.next;
    }

//  /$$$$$$  /$$$$$$  /$$   /$$  /$$$$$$  /$$$$$$$  /$$$$$$$$      /$$$$$$$   /$$$$$$  /$$$$$$$  /$$$$$$$$
// |_  $$_/ /$$__  $$| $$$ | $$ /$$__  $$| $$__  $$| $$_____/     | $$__  $$ /$$__  $$| $$__  $$|__  $$__/
//   | $$  | $$  \__/| $$$$| $$| $$  \ $$| $$  \ $$| $$           | $$  \ $$| $$  \ $$| $$  \ $$   | $$   
//   | $$  | $$ /$$$$| $$ $$ $$| $$  | $$| $$$$$$$/| $$$$$ /$$$$$$| $$$$$$$/| $$$$$$$$| $$$$$$$/   | $$   
//   | $$  | $$|_  $$| $$  $$$$| $$  | $$| $$__  $$| $$__/|______/| $$____/ | $$__  $$| $$__  $$   | $$   
//   | $$  | $$  \ $$| $$\  $$$| $$  | $$| $$  \ $$| $$           | $$      | $$  | $$| $$  \ $$   | $$   
//  /$$$$$$|  $$$$$$/| $$ \  $$|  $$$$$$/| $$  | $$| $$$$$$$$     | $$      | $$  | $$| $$  | $$   | $$   
// |______/ \______/ |__/  \__/ \______/ |__/  |__/|________/     |__/      |__/  |__/|__/  |__/   |__/ 

    public static void main(String[] args) {
        Remove_Duplicates_from_Sorted_List_83 solution = new Remove_Duplicates_from_Sorted_List_83();
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode result = solution.deleteDuplicates(head);

        // Print the modified linked list
        ListNode current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

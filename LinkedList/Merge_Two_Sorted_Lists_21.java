package LinkedList;

class ListNode{
    int val;
    ListNode next;

    ListNode(){};

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}


public class Merge_Two_Sorted_Lists_21 {
   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // If first list is empty, return the second list
        if (list1 == null) return list2;
        // If second list is empty, return the first list
        if (list2 == null) return list1;

        // Create a dummy node (acts as a placeholder head)
        // This makes it easier to handle edge cases
        ListNode temp = new ListNode(-1);

        // 'curr' will be used to build the merged list
        ListNode curr = temp;

        // Traverse both lists until one of them is fully processed
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
             // Attach list1 node to the merged list
             curr.next = list1;
                // Move list1 pointer forward
                list1 = list1.next;
            } else {
                // Attach list2 node to the merged list
                curr.next = list2;
                // Move list2 pointer forward
                list2 = list2.next;
            }
            // Move the 'curr' pointer forward
            curr = curr.next;
        }

        // Attach the remaining nodes of list1 (if any)
        if (list1 != null) curr.next = list1;
        // Attach the remaining nodes of list2 (if any)
        if (list2 != null) curr.next = list2;

        // Return the merged list (skipping the dummy head)
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
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        Merge_Two_Sorted_Lists_21 sol = new Merge_Two_Sorted_Lists_21();
        ListNode mergedList = sol.mergeTwoLists(list1, list2);

        // Print the merged linked list
        ListNode current = mergedList;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
        
    }
}

package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
};



public class Intro_LinkedList {
    // Function to convert an array to a linked list
    private static Node converArr2LL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;     // mover = mover.next
        }
        return head;
    }

    // print the length of linked list
    private static int lengthOfLL(Node head){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    // search an element in linked list
    private static int searchInLL(Node head, int target){
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(temp.data == target){
                return index;  // element found at index
            }
            index++;
            temp = temp.next;
        }
        return -1;  // element not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8};
        // Node y = new Node(arr[3]);
        Node head = converArr2LL(arr);
        // System.out.println(head.data);     // print head data 
        // ---------------------------------------------------------------------------------

        // print the length of linked list
        int length = lengthOfLL(head);
        System.out.println("Length of linked list: " + length);
        // ---------------------------------------------------------------------------------

        // search an element in linked list
        int target = 6;
        int index = searchInLL(head, target);
        if(index != -1){
            System.out.println("Element " + target + " found at index: " + index);
        } else {
            System.out.println("Element " + target + " not found in the linked list.");
        }

        // print the linked list
        // for traversing the linked list (including above code)
        
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
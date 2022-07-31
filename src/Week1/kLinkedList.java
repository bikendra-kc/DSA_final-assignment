//Question 1 :

package Week1;

import Week1.SingelyLinkedList.Node;

public class kLinkedList {

    SingelyLinkedList[] arr; // This array stores all the linked lists user inputs.

    kLinkedList(SingelyLinkedList[] arr) {
        // constructor
        this.arr = arr;
    }

    SingelyLinkedList Merges() {
        // This function itterates through all the linked lists and merges them into one
        // linked list.
        SingelyLinkedList FinalOutputList = arr[0]; // Initialize the final output list with the first linked list.
        SingelyLinkedList mergedList; // This linked list is used to store the two merged linked list.
        for (int i = 1; i < arr.length; i++) {
            // itteration through all the linked lists.
            mergedList = ToMerge(FinalOutputList, arr[i]); // Merge the current linked list with the final output list.
            FinalOutputList = mergedList; // Update the final output list with the merged linked list.
        }
        return FinalOutputList; // Return the final output list.
    }

    SingelyLinkedList ToMerge(SingelyLinkedList a, SingelyLinkedList b) {
        // This function merges two linked lists.
        SingelyLinkedList result = new SingelyLinkedList(); // Initialize the result linked list.
        Node first_itterator = a.head; // Initialize the first itterator with the first linked list.
        Node second_itterator = b.head; // Initialize the second itterator with the second linked list.
        while (first_itterator != null) {
            // itterate through the first linked list.
            result.addNode(first_itterator.data); // Append the current data to the result linked list.
            first_itterator = first_itterator.next; // Update the first itterator.
        }
        while (second_itterator != null) {
            // itterate through the second linked list.
            result.addNode(second_itterator.data); // Append the current data to the result linked list.
            second_itterator = second_itterator.next; // Update the second itterator.
        }
        return sortLinkedList(result); // Return the sorted result linked list.
    }

    SingelyLinkedList sortLinkedList(SingelyLinkedList list) {
        // Node current will point to head
        Node current = list.head, index = null; // Initialize the current and index pointers.
        int temp; // Initialize the temp variable.

        if (list.head == null) {
            return null; // If the linked list is empty, return null.
        } else {
            while (current != null) {
                // Node index will point to node next to current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater than index's node data, swap the data
                    // between them
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
        return list; // Return the sorted linked list.
    }

    void Median() {

        int median = (Merges().getSize()+1) / 2; 
        // Get the median of the linked list.
        System.out.println("The Median is : " + Merges().getDataAtAnyPos(median)); // Print the median.
    }

    public static void main(String[] args) {
        //creating 3 linked lists
        SingelyLinkedList[] arr = new SingelyLinkedList[3];
        SingelyLinkedList L1 = new SingelyLinkedList();
        SingelyLinkedList L2 = new SingelyLinkedList();
        SingelyLinkedList L3 = new SingelyLinkedList();

        //adding nodes to the linked lists
        L1.addNode(2);
        L1.addNode(4);
        L1.addNode(7);
        L1.addNode(5);
        L1.addNode(10);
        L2.addNode(3);
        L2.addNode(2);
        L2.addNode(7);
        L2.addNode(9);
        L3.addNode(12);
        L3.addNode(5);
        L3.addNode(6);
        L3.addNode(9);
        //passing the linked lists as arrays
        arr[0] = L1;
        arr[1] = L2;
        arr[2] = L3;
        kLinkedList w = new kLinkedList(arr);
        //displaying the output
        w.Median();
        
    }
}


/* 
OUTPUT 
Before Insertion: 1 -> 2 -> 3 -> 4 -> 5 -> null
After Insertion: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> null

Before Insertion: 1 -> 2 -> 3 -> 4 -> 5 -> null
After Insertion: 6 -> 1 -> 2 -> 3 -> 4 -> 5 -> null
*/

class Node {
    int data;
    Node next;
    Node (int val) {
      this.data = val;
      this.next = null;
    }
}
public class InsertAtPosRec {
  static Node insertAtPosRec (Node head, int val, int pos) {
    if (pos == 0){
      Node newNode = new Node(val);
      newNode.next = head;
      return newNode;
    }
    if (head == null) {
      return head;
    }
    head.next = insertAtPos(head.next, val, pos-1);
    return head;
  }

  static void display(Node head) {
    Node temp = head;
    if (temp == null) {
      System.out.println("null");
      return;
    } else {
      System.out.print(temp.data + " -> ");
    }
    display(temp.next);
  }
  
  public static void main(String[] args) {
    Node p = new Node(1);
    p.next = new Node(2);
    p.next.next = new Node(3);
    p.next.next.next = new Node(4);
    p.next.next.next.next = new Node(5);
    System.out.print("Before Insertion: ");
    display(p);
    p = insertAtPos(p, 6, 2);
    System.out.print("After Insertion: ");
    display(p);
  }
}

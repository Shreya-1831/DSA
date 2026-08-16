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
public class InsertAtPos {
  static Node insertAtPos (Node head, int val, int pos) {
    Node newNode = new Node(val);
    if (pos == 0) {
      newNode.next = head;
      return newNode;
    }
    Node temp = head;
    int curr = 0;
    while (temp != null && curr < pos - 1){
      temp = temp.next;
      curr++;
    }
    if (temp != null) {
      newNode.next = temp.next;
      temp.next = newNode;
    }
    return head;
  }

  static void display(Node head) {
    Node temp = head;
    while (temp != null){
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.println("null");
  }
  
  public static void main(String[] args) {
    Node p = new Node(1);
    p.next = new Node(2);
    p.next.next = new Node(3);
    p.next.next.next = new Node(4);
    p.next.next.next.next = new Node(5);
    System.out.print("Before Insertion: ");
    display(p);
    p = insertAtPos(p, 6, 0);
    System.out.print("After Insertion: ");
    display(p);
  }
}

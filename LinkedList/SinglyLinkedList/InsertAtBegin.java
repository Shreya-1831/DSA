import java.util.*;

/* 
OUTPUT 
Before Insertion: 1 -> 2 -> 3 -> 4 -> 5 -> null
After Insertion: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null
*/

class Node {
    int data;
    Node next;
    Node (int val) {
      this.data = val;
      this.next = null;
    }
}
public class Main {
  static Node insertAtBegin (Node head, int val) {
    Node newNode = new Node(val);
    newNode.next = head;
    head = newNode;
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
    p = insertAtBegin(p, 0);
    System.out.print("After Insertion: ");
    display(p);
  }
}

import java.util.*;
/* 
OUTPUT 
Before Deletion: 1 -> 2 -> 3 -> 4 -> 5 -> null
After Deletion: 1 -> 2 -> 3 -> 4 -> null
*/

class Node {
    int data;
    Node next;
    Node (int val) {
      this.data = val;
      this.next = null;
    }
}
public class DeleteAtPos {
  static Node deleteAtPos (Node head, int x) {
    ArrayList<Node> nodes = new ArrayList<>();
    if (x == 1) {
      return head.next;
    }
    Node curr = head;
    while (curr != null) {
      nodes.add(curr);
      curr = curr.next;
    }
    Node prev = nodes.get(x-2);
    Node del = nodes.get(x-1);
    prev.next = del.next;
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
    System.out.print("Before Deletion: ");
    display(p);
    p = deleteAtPos(p, 2);
    System.out.print("After Deletion: ");
    display(p);
  }
}

import java.util.*;
/* 
OUTPUT 
Before Updation: 1 -> 2 -> 3 -> 4 -> 5 -> null
After Updation: 1 -> 2 -> 3 -> 6 -> 5 -> null
Before Updation: 1 -> 2 -> 3 -> 4 -> 5 -> null
After Updation: 6 -> 2 -> 3 -> 4 -> 5 -> null
*/

class Node {
    int data;
    Node next;
    Node (int val) {
      this.data = val;
      this.next = null;
    }
}
public class UpdateValueIteration {
  static Node updateValueIteration(Node head, int pos, int val) {
    Node temp = head;
    int curr = 0;
    while (temp != null) {
      if (curr == pos) {
        temp.data = val;
      }
      temp = temp.next;
      curr++;
    }
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
    System.out.print("Before Updation: ");
    display(p);
    p = updateValueIteration(p, 0, 6);
    System.out.print("After Updation: ");
    display(p);
  }
}

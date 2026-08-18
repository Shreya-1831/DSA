import java.util.*;
/* 
OUTPUT (1 - indexed)
Before Deletion: 1 -> 2 -> 3 -> 4 -> 5 -> null
After Deletion using Approach 1 with x == 2: 1 -> 3 -> 4 -> 5 -> null
After Deletion using Approach 2 with x == 3: 1 -> 3 -> 5 -> null
*/

class Node {
    int data;
    Node next;
    Node (int val) {
      this.data = val;
      this.next = null;
    }
}
public class DeleteAtPosOptimal {
  static Node deleteAtPosApp1 (Node head, int x) {
    if (x == 1) {
      return head.next;
    }
    Node temp = head;
    int curr = 1;
    while (temp != null) {
      if (curr == x - 1) {
        temp.next = temp.next.next;
        return head;
      }
      temp = temp.next;
      curr++;
    }
    return head;
  }

  static Node deleteAtPosApp2 (Node head, int x) {
    if (x == 1) {
      return head.next;
    }
    Node temp = head;
    int curr = 0;
    while (temp != null && curr < x - 2) {
      temp = temp.next;
      curr++;
    }
    if (temp != null && temp.next != null) {
      temp.next = temp.next.next;
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
    System.out.print("Before Deletion: ");
    display(p);
    int x = 2;
    p = deleteAtPosApp1(p, x);
    System.out.print("After Deletion using Approach 1 with x == " + x + ": ");
    display(p);
    x = 3;
    Node q = deleteAtPosApp2(p, x);
    System.out.print("After Deletion using Approach 2 with x == " + x + ": ");
    display(q);
  }
}

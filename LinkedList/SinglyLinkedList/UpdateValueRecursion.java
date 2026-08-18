import java.util.*;
/* 
OUTPUT 
Before Updation (pos == 4): 1 -> 2 -> 3 -> 4 -> 5 -> null
After Updation (pos == 4): 1 -> 2 -> 3 -> 6 -> 5 -> null
Before Updation (pos == 1): 1 -> 2 -> 3 -> 4 -> 5 -> null
After Updation (pos == 1): 6 -> 2 -> 3 -> 4 -> 5 -> null
*/

class Node {
    int data;
    Node next;
    Node (int val) {
      this.data = val;
      this.next = null;
    }
}
public class UpdateValueRecursion {
  static Node updateValueRecursion(Node head, int pos, int val) {
    if (head == null){
      return null;
    }
    Node temp = head;
    if (pos == 1) {
      temp.data = val;
    }
    temp.next = updateValueRecursion(temp.next, pos - 1, val);
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
    p = updateValueRecursion(p, 2, 6);
    System.out.print("After Updation: ");
    display(p);
  }
}

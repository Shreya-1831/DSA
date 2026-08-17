import java.util.*;
/* 
OUTPUT 
List Elements: 1 -> 2 -> 3 -> 4 -> 5 -> null
2 is found in list
List Elements: 1 -> 2 -> 3 -> 4 -> 5 -> null
6 is not found in list
*/

class Node {
    int data;
    Node next;
    Node (int val) {
      this.data = val;
      this.next = null;
    }
}
public class SearchRecursion {
  static boolean SearchRecursion(Node head, int val) {
    if (head == null) {
      return false;
    }
    if (head.data == val) {
      return true;
    }
    return SearchRecursion(head.next, val);
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
    System.out.print("List Elements: ");
    display(p);
    int data = 6;
    boolean val = SearchRecursion(p, data);
    if (val == true) {
      System.out.println(data + " is found in list");
    } else {
      System.out.println(data + " is not found in list");
    }
  }
}

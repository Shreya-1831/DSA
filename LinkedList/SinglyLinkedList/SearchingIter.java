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
public class SearchingIter {
  static boolean SearchIteration(Node head, int val) {
    Node temp = head;
    while (temp != null) {
      if (temp.data == val) {
        return true;
      }
      temp = temp.next;
    }
    return false;
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
    boolean val = SearchIteration(p, data);
    if (val == true) {
      System.out.println(data + " is found in list");
    } else {
      System.out.println(data + " is not found in list");
    }
  }
}

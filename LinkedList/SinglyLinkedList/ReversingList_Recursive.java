import java.util.*;
/* 
OUTPUT 
List Elements: 1 -> 2 -> 3 -> 4 -> 5 -> null
Reversing using standard recursive approach: 5 -> 4 -> 3 -> 2 -> 1 -> null
Reversing using helper function recursively: 5 -> 4 -> 3 -> 2 -> 1 -> null
*/

class Node {
    int data;
    Node next;
    Node (int val) {
      this.data = val;
      this.next = null;
    }
}
public class ReversingList_Recursive {
  static Node reverse(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    Node newNode = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newNode;
  }

  static Node helperFunc(Node curr, Node prev) {
    if (curr == null) return prev;
    Node next = curr.next;
    curr.next = prev;
    return helperFunc(next, curr);
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
    Node app1 = reverse(p);
    System.out.print("Reversing using standard recursive approach: ");
    display(app1);
    p = reverse(app1);
    Node app2 = helperFunc(p, null);
    System.out.print("Reversing using helper function recursively: ");
    display(app2);
  }
}

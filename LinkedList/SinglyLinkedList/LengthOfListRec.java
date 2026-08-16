/* 
OUTPUT 
1 -> 2 -> 3 -> 4 -> 5 -> null
Length of List using Recursive Approach: 5
*/
class Node {
    int data;
    Node next;
    Node (int val) {
      this.data = val;
      this.next = null;
    }
}
public class LengthOfListRec {
  static int lengthOfListRec (Node head) {
    if (head == null) {
      return 0;
    }
    return 1 + lengthOfListRec(head.next);
  }

  static void display(Node head) {
    Node temp = head;
    if (temp == null) {
      System.out.println("null");
      return;
    }
    System.out.print(temp.data + " -> ");
    display(temp.next);
  }
  
  public static void main(String[] args) {
    Node p = new Node(1);
    p.next = new Node(2);
    p.next.next = new Node(3);
    p.next.next.next = new Node(4);
    p.next.next.next.next = new Node(5);
    display(p);
    int length = lengthOfListRec(p);
    System.out.println("Length of List using Recursive Approach: " + length);
  }
}

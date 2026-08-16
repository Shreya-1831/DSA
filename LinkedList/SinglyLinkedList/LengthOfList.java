/* 
OUTPUT 
1 -> 2 -> 3 -> 4 -> 5 -> null
Length of List: 5
*/
class Node {
    int data;
    Node next;
    Node (int val) {
      this.data = val;
      this.next = null;
    }
}
public class LengthOfList {
  static int lengthOfList (Node head) {
    Node temp = head;
    int count = 0;
    while (temp != null){
      count++;
      temp = temp.next;
    }
    return count;
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
    display(p);
    int length = lengthOfList(p);
    System.out.println("Length of List: " + length);
  }
}

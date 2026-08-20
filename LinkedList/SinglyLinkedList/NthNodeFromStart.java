import java.util.*;
/* 
OUTPUT 
List Elements: 1 -> 2 -> 3 -> 4 -> 5 -> null
4th Node from start using ArrayList Approach: 4
4th Node from start using Traversal Approach: 4
4th Node from start using Two Pointers Approach: 4
*/

class Node {
    int data;
    Node next;
    Node (int val) {
      this.data = val;
      this.next = null;
    }
}
public class NthNodeFromStart {
  static int listApproach(Node head, int n) {
    ArrayList<Node> nodes = new ArrayList<>();
    Node temp = head;
    while (temp != null) {
      nodes.add(temp);
      temp = temp.next;
    }
    if (n < 1 || n > nodes.size()) {
      return -1;
    }
    return nodes.get(n-1).data;
  }

  static int traversal(Node head, int n) {
    Node temp = head;
    int curr = 1;
    while (temp != null) {
      if (curr == n) {
        return temp.data;
      }
      curr++;
      temp = temp.next;
    }
    return -1;
  }

  static int twoPointers(Node head, int n) {
    Node slow = head;
    Node fast = head;
    for (int i=1; i<n; i++) {
      if (fast == null) return -1;
      fast = fast.next;
    }
    if (fast == null) return -1;
    return fast.data;
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
    int n = 4;
    int app1 = listApproach(p, n);
    int app2 = traversal(p, n);
    int app3 = twoPointers(p, n);
    System.out.println(n + "th Node from start using ArrayList Approach: " + app1);
    System.out.println(n + "th Node from start using Traversal Approach: " + app2);
    System.out.println(n + "th Node from start using Two Pointers Approach: " + app3);
  }
}

/*
OUTPUT
List elements before deletion of first node: 
1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
List elements after deletion of first node: 
2 <-> 3 <-> 4 <-> 5 <-> null
*/

import java.util.*;
class Node {
  int data;
  Node prev;
  Node next;
  Node (int d){
    data = d;
    prev = null;
    next = null;
  }
}

public class DeleteAtBegin{
  static Node deletion(Node head) {
    if (head == null) {
      return null;
    }
    if (head != null && head.next != null) {
      head = head.next;
      head.prev = null;
    }
    return head;
  }

  static void display(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " <-> ");
      temp = temp.next;
    }
    System.out.print("null");
    System.out.println();
  }

  public static void main(String[] args) {
    Node first = new Node(1);
    Node second = new Node(2);
    Node third = new Node(3);
    Node fourth = new Node(4);
    Node fifth = new Node(5);
    first.next = second;
    second.prev = first;
    second.next = third;
    third.prev = second;
    third.next = fourth;
    fourth.prev = third;
    fourth.next = fifth;
    fifth.prev = fourth;
    System.out.println("List elements before deletion of first node: ");
    display(first);
    first = deletion(first);
    System.out.println("List elements after deletion of first node: ");
    display(first);
  }
}

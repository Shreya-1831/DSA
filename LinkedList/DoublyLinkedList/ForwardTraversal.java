/*
OUTPUT
Traversal in forward direction by iterative approach: 
1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
Traversal in forward direction by recursive approach: 
1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
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

public class ForwardTraversal{
  static void iterative(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " <-> ");
      temp = temp.next;
    }
    System.out.print("null");
    System.out.println();
  }

  static void recursive(Node head) {
    if (head == null) {
      System.out.print("null");
      return;
    }
    System.out.print(head.data + " <-> ");
    recursive(head.next);
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
    System.out.println("Traversal in forward direction by iterative approach: ");
    iterative(first);
    System.out.println("Traversal in forward direction by recursive approach: ");
    recursive(first);
  }
}

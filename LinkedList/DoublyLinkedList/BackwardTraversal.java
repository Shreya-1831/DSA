/*
OUTPUT
Traversal in backward direction by iterative approach: 
5 <-> 4 <-> 3 <-> 2 <-> 1 <-> null
Traversal in backward direction by recursive approach: 
5 <-> 4 <-> 3 <-> 2 <-> 1 <-> null
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

public class BackwardTraversal{
  static void iterative(Node tail) {
    Node temp = tail;
    while (temp != null) {
      System.out.print(temp.data + " <-> ");
      temp = temp.prev;
    }
    System.out.print("null");
    System.out.println();
  }

  static void recursive(Node tail) {
    if (tail == null) {
      System.out.print("null");
      return;
    }
    System.out.print(tail.data + " <-> ");
    recursive(tail.prev);
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
    System.out.println("Traversal in backward direction by iterative approach: ");
    iterative(fifth);
    System.out.println("Traversal in backward direction by recursive approach: ");
    recursive(fifth);
  }
}

/*
OUTPUT
List elements before insertion: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
List elements after insertion: 0 <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
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

public class InsertAtBegin{
  static Node insertion(Node head, int val) {
    Node newNode = new Node(val);
    newNode.next = head;
    if (head != null) {
      head.prev = newNode;
    }
    return newNode;
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
    System.out.print("List elements before insertion: ");
    display(first);
    first = insertion(first, 0);
    System.out.print("List elements after insertion: ");
    display(first);
  }
}

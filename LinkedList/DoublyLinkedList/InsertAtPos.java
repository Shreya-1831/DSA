/*
OUTPUT
List elements before insertion at pos = 2: 
1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
List elements after insertion at pos = 2 by first approach: 
1 <-> 6 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
List elements after insertion at pos = 2 by second approach: 
1 <-> 6 <-> 2 <-> 3 <-> 8 <-> 4 <-> 5 <-> null
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

public class InsertAtPos{
  static Node insertionapp1(Node head, int pos, int val) {
    Node newNode = new Node(val);
    int curr = 1;
    Node temp = head;
    if (pos == 1) {
      newNode.next = head;
      if (head != null) {
        head.prev = newNode;
      }
      return newNode;
    } 
    while (temp != null) {
      if (curr == pos) {
        newNode.next = temp;
        newNode.prev = temp.prev;
        temp.prev.next = newNode;
        temp.prev = newNode;
      }
      temp = temp.next;
      curr++;
    }
    return head;
  }

  static Node insertionapp2(Node head, int pos, int val) {
    Node newNode = new Node(val);
    int curr = 1;
    Node temp = head;
    if (pos == 1) {
      newNode.next = head;
      if (head != null) {
        head.prev = newNode;
      }
      return newNode;
    } 
    for (curr = 1; curr < pos - 1 && temp != null; curr++) {
      temp = temp.next;
    }
    newNode.next = temp.next;
    if (temp.next != null) {
      temp.next.prev = newNode;
    }
    temp.next = newNode;
    newNode.prev = temp;
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
    System.out.println("List elements before insertion at pos = 2: ");
    display(first);
    first = insertionapp1(first, 2, 6);
    System.out.println("List elements after insertion at pos = 2 by first approach: ");
    display(first);
    first = insertionapp2(first, 5, 8);
    System.out.println("List elements after insertion at pos = 2 by second approach: ");
    display(first);
  }
}

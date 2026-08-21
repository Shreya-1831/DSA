/*
OUTPUT
List elements before deletion: 
1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
List elements after deletion at pos = 3 by first approach: 
1 <-> 2 <-> 4 <-> 5 <-> null
List elements after deletion at pos = 3 by second approach: 
1 <-> 2 <-> 5 <-> null
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

public class DeleteAtPos{
  static Node deletionapp1(Node head, int pos) {
    Node temp = head;
    int curr = 1;
    if (pos == 1) {
      head = head.next;
      if (head != null) head.prev = null;
      return head;
    }
    while (temp != null) {
      if (curr == pos - 1) {
        if (temp.next != null && temp.next.next != null) {
          temp.next = temp.next.next;
          temp.next.prev = temp;
        }
      }
      curr++;
      temp = temp.next;
    }
    return head;
  }
  static Node deletionapp2(Node head, int pos) {
    Node temp = head;
    int curr = 1;
    if (pos == 1) {
      head = head.next;
      if (head != null) head.prev = null;
      return head;
    }
    for (curr = 1; curr < pos - 1 && temp != null; curr++){
      temp = temp.next;
    }
    temp.next = temp.next.next;
    temp.next.prev = temp;
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
    System.out.println("List elements before deletion: ");
    display(first);first = deletionapp1(first, 3);
    System.out.println("List elements after deletion at pos = 3 by first approach: ");
    display(first);
    first = deletionapp2(first, 3);
    System.out.println("List elements after deletion at pos = 3 by second approach: ");
    display(first);
  }
}

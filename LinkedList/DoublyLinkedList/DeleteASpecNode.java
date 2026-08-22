/*
OUTPUT
List elements before deletion: 
1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
List elements after deletion of 2 by first approach: 
1 <-> 3 <-> 4 <-> 5 <-> null
List elements after deletion of 3 by second approach: 
1 <-> 4 <-> 5 <-> null
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

public class DeleteASpecNode{
  static Node deletionapp1(Node head, int val) {
    Node temp = head;
    while (temp != null) {
      if (temp.data == val) {
        if (temp.prev == null) {
          head = temp.next;
          if (head != null) {
            head.prev = null;
          }
          return head;
        }
        temp = temp.prev;
        if (temp.next != null && temp.next.next != null) {
          temp.next = temp.next.next;
          temp.next.prev = temp;
        }
      }
      temp = temp.next;
    }
    return head;
  }

  static Node deletionapp2(Node head, int val) {
    Node temp = head;
    while (temp != null && temp.data != val) {
      temp = temp.next;
    }
    if (temp == null) return head;
    if (temp.prev == null) {
      head = temp.next;
      if (head != null) {
        head.prev = null;
      }
      return head;
    }
    temp.prev.next = temp.next;
    if (temp.next != null) {
      temp.next.prev = temp.prev;
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
    System.out.println("List elements before deletion: ");
    display(first);
    first = deletionapp1(first, 2);
    System.out.println("List elements after deletion of 2 by first approach: ");
    display(first);
    first = deletionapp2(first, 3);
    System.out.println("List elements after deletion of 3 by second approach: ");
    display(first);
  }
}

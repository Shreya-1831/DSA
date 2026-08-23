/*
OUTPUT
List elements before reversal: 
1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
List elements after reversal by iterative approach: 
5 <-> 4 <-> 3 <-> 2 <-> 1 <-> null
List elements after reversal by recursive approach: 
1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
List elements after reversal by using stack: 
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

public class ReversalOfList{
  static Node iteration(Node head) {
    Node curr = head;
    Node temp = null;
    while (curr != null) {
      temp = curr.prev;
      curr.prev = curr.next;
      curr.next = temp;
      curr = curr.prev;
    }
    return temp.prev;
  }

  static Node recursion(Node head) {
    if (head == null) return null;
    Node temp = head.prev;
    head.prev = head.next;
    head.next = temp;
    if (head.prev != null) {
      return recursion(head.prev);
    }
    return head;
  }

  static Node StackApproach(Node head) {
    Stack <Node> stack = new Stack<>();
    Node temp = head;
    while (temp != null) {
      stack.push(temp);
      temp = temp.next;
    }
    head = stack.pop();
    Node curr = head;
    while (!stack.isEmpty()){
      Node node = stack.pop();
      curr.next = node;
      node.prev = curr;
      curr = node;
    }
    curr.next = null;
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
    System.out.println("List elements before reversal: ");
    display(first);
    first = iteration(first);
    System.out.println("List elements after reversal by iterative approach: ");
    display(first);
    first = recursion(first);
    System.out.println("List elements after reversal by recursive approach: ");
    display(first);
    first = StackApproach(first);
    System.out.println("List elements after reversal by using stack: ");
    display(first);
  }
}

package com.rule.problem.interview.linked;

/**
 * 707. 设计链表
 */
public class MyLinkedList {
    private Node head;
    private int size;

    class Node {
        int val;
        Node next;
        public Node(int val) {
            next = null;
            this.val = val;
        }
    }


    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new Node(0);
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node node = head;
        while (index >= 0) {
            node = node.next;
            index--;
        }
        return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
       // 1 --- 2 --- 3
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node add = new Node(val);
        add.next = temp.next;
        temp.next = add;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }
}

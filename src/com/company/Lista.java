package com.company;



import java.util.ArrayList;

public class Lista<U> {

    private Node<U> head;
    private int size = this.size();


    //todo addStart
    public void addStart(U data) {

        if (head == null) {
            head = new Node<U>();
            head.setData(data);
            head.setNext(null);


        } else {
            Node<U> newNode = new Node<>();
            newNode.setData(data);
            newNode.setNext(head);
            head = newNode;
        }
        this.size++;

    }

    public void traverse() {
        Node<U> aux = head;
        while (aux != null) {
            System.out.println(aux.getData());
            aux = aux.getNext();
        }
    }
    //todo addLast

    public void addLast(U data) {
        if (head == null) {
            head = new Node<U>();
            head.setData(data);
            head.setNext(null);
        } else {
            Node<U> newNode = new Node();
            newNode.setData(data);
            Node<U> iterator = head;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        this.size++;
    }
    //todo addPostion

    public void addPosition(U data, int k) {
        if (k == 0) {
            this.addStart(data);
        } else if (k >= size()) {

            this.addLast(data);
        } else {
            Node<U> nodeNou = new Node<>();
            nodeNou.setData(data);
            Node<U> iterator = head;
            int i = 1;
            while (iterator.getNext() != null && i != k) {
                iterator = iterator.getNext();
                i++;
            }
            Node<U> node2 = iterator.getNext();
            iterator.setNext(nodeNou);
            nodeNou.setNext(node2);
        }
        this.size++;
    }
    //todo removeLast

    public void removeLast() {
        if (size() == 1)
            head = null;
        else {
            Node<U> iterator = head;
            for (int i = 0; i < size() - 2; i++)
                iterator = iterator.getNext();

            iterator.setNext(null);
        }
        this.size--;
    }


    //todo removeStart
    public void removeStart() {
        if (size() == 1)
            head = null;
        else {
            Node<U> node1 = head.getNext();
            head = node1;
        }
        this.size--;
    }

    //todo removePostion

    public void removePosition(int k) {
        if (k == 0)
            return;
        else {
            Node<U> iterator = head;
            for (int i = 1; i < k; i++)
                iterator = iterator.getNext();
            iterator.setNext(iterator.getNext().getNext());

        }
        this.size--;
    }
    //todo size


    public int size() {
        int i = 0;
        Node<U> iterator = head;
        while (iterator != null) {
            iterator = iterator.getNext();
            i++;
        }
        return i;

    }


    public Node<U> getHead() {
        return this.head;
    }

    public Node<U> getNode(int k) {
        Node<U> aux = getHead();
        int i = 0;
        while (i != k) {
            aux = aux.getNext();
            i++;
        }
        return aux;
    }

    public Node<U> getPosition(int k) {
        Node<U> aux = getHead();
        int i = 0;
        while (i != k) {
            aux = aux.getNext();
            i++;
        }
        return aux;
    }

    public void removeObject(U data){
        int i=0;
        while(this.getPosition(i)!=data)
            i++;
        this.removePosition(i+1);
    }
}
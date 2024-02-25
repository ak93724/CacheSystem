package servie.impl;

import model.DoublyLinkedList;
import servie.DoublyLLService;

public class DoublyLinkListSeriveImpl<T> implements DoublyLLService<T>{

    DoublyLinkedList<T> head;
    DoublyLinkedList<T> tail;

    @Override
    public void add(DoublyLinkedList<T> data) {
        if(head == null) {
            head = data;
            tail = data;
        }
        else {
            head.setPrevious(data);
            data.setNext(head);
            head = data;
        }
    }

    @Override
    public void remove(DoublyLinkedList<T> data) {
        if(data.getPrevious() != null) {
            data.getPrevious().setNext(data.getNext());
        }
        else {
            head = data.getNext();
        }

        if(data.getNext() != null) {
            data.getNext().setPrevious(data.getPrevious());
        }
        else {
            tail = data.getPrevious();
        }

    }

    @Override
    public DoublyLinkedList<T> getLast() {
        return tail;
    }
}

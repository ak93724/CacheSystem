package servie;

import model.DoublyLinkedList;

public interface DoublyLLService<T> {
    void add(DoublyLinkedList<T> data);

    void remove(DoublyLinkedList<T> data);

    DoublyLinkedList<T> getLast();
}

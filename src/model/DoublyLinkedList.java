package model;

public class DoublyLinkedList<T> {
    private T key;
    private DoublyLinkedList<T> next;

    private DoublyLinkedList<T> previous;

    public DoublyLinkedList(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public DoublyLinkedList<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedList<T> next) {
        this.next = next;
    }

    public DoublyLinkedList<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedList<T> previous) {
        this.previous = previous;
    }

    public void setKey(T key) {
        this.key = key;
    }
}

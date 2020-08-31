package org.academiadecodigo.bootcamp.containers;

import java.io.FileNotFoundException;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(T data)  {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public T get(int index) {

       // throw new UnsupportedOperationException();

        if (length == 0 || index >= length){
            return null;
        }
        else {
            Node iterator = head;
            for (int i = -1; i< index; i++){
                iterator = iterator.getNext();
            }
            return (T) iterator.data;
        }
    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(T data) {

       // throw new UnsupportedOperationException();
            Node iterator = head;
        for (int i=-1; i<length; i++){
            if(iterator.getData() == data){
                return i;
            }
            iterator = iterator.getNext();
        }
        return -1;
    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(T data) {

       // throw new UnsupportedOperationException();
        Node iterator = head;
        for (int i = 0; i < length; i++){
            if(iterator.getNext().getData() == data){
                iterator.setNext(iterator.getNext().getNext());
                length--;
                return true;
            }
            iterator = iterator.getNext();
        }
        return false;
    }

    @Override
    public Iterator iterator(){
        return new LinkedListIterator();
    }


    private class LinkedListIterator implements Iterator <T>{

        @Override
        public boolean hasNext(){
            return (head.getNext() != null);
        }

        @Override
        public T next(){
            head = head.next;
            return head.data;

        }
    }

    private class Node {

        private T data;
        private Node next;

        public Node(T data) {
            this.data =  data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(Node data) {
            this.data = (T)data;
        }

        public Node getNext() {
            return  next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}

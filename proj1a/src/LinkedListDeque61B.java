import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>{

    /**
     * Node class: doubly-linked, inner nested class.
     */
    private class Node{
        private T item;
        private Node next;
        private Node prev;

        public Node(Node prev, T item, Node next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Sentinel node.
     */
    private Node sentinel;
    /**
     * Size counter.
     */
    private int size;


    /**
     * Doubly linked-list construtor.
     * Sentinel and circular.
     */
    public LinkedListDeque61B(){
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Adds item to the front of the list.
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        Node oldFirst = sentinel.next;
        Node newNode = new Node(sentinel, x, oldFirst);
        sentinel.next = newNode;
        oldFirst.prev = newNode;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node oldLast = sentinel.prev;
        Node newNode = new Node(oldLast, x, sentinel);
        oldLast.next = newNode;
        sentinel.prev = newNode;
        size++;


    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node curr = sentinel.next;
        while(curr != sentinel){
            returnList.add(curr.item);
            curr = curr.next;
        }

        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        Node prevFirst = sentinel.next;
        Node newFirst = sentinel.next.next;
        sentinel.next = newFirst;
        newFirst.prev = sentinel;
        return prevFirst.item;
    }

    @Override
    public T removeLast() {
        Node prevLast = sentinel.prev;
        Node newLast = prevLast.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
        return prevLast.item;
    }

    @Override
    public T get(int index) {
        int currIndex = 0;
        Node curr = sentinel.next;

        while(currIndex < size){
            if(currIndex == index) return curr.item;
            curr = curr.next;
            currIndex++;
        }
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}

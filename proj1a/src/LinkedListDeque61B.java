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
     * Empty list represented by single sentinel node that points to itself.
     * Sentinel and circular.
     */
    public LinkedListDeque61B(){
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Adds item to the front of the deque.
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        // saves old first node, creates new node pointing to sentinel and old first node respectively
        // reconnects the pointers
        // increments size
        Node oldFirst = sentinel.next;
        Node newNode = new Node(sentinel, x, oldFirst);
        sentinel.next = newNode;
        oldFirst.prev = newNode;
        size++;
    }

    /**
     * Adds item to the end of the deque.
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        // saves old last node, creates new node pointing to sentinel and old last respectively
        // reconnects pointers
        // increments size
        Node oldLast = sentinel.prev;
        Node newNode = new Node(oldLast, x, sentinel);
        oldLast.next = newNode;
        sentinel.prev = newNode;
        size++;


    }

    /**
     * Returns a list representation of the deque.
     * @return list
     */
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

    /**
     * Checks if deque is empty in constant time.
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns the size of the deque is constant time.
     * @return the size of the deque
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if(size == 0) return null;

        Node prevFirst = sentinel.next;
        Node newFirst = sentinel.next.next;
        sentinel.next = newFirst;
        newFirst.prev = sentinel;
        return prevFirst.item;
    }

    @Override
    public T removeLast() {
        if(size == 0) return null;

        Node prevLast = sentinel.prev;
        Node newLast = prevLast.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
        return prevLast.item;
    }

    /**
     * Gets the element at the specified index.
     * @param index index to get
     * @return item found
     */
    @Override
    public T get(int index) {

        if(index >= size || index < 0) return null;
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
        if(index >= size || index < 0) return null;
        return getRecursiveHelper(sentinel.next, index);

    }

    public T getRecursiveHelper(Node curr, int index){
        if(index == 0) return curr.item;

        return getRecursiveHelper(curr.next, --index); //not index--
    }
}

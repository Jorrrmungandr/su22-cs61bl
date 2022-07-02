package deque;

public class LinkedListDeque<T> implements Deque<T>{
    private LinkedListDequeNode<T> sentinel;
    private int size;

    public static class LinkedListDequeNode<T>{
        private T item;
        private LinkedListDequeNode<T> prev;
        private LinkedListDequeNode<T> next;

        public LinkedListDequeNode(){
            prev = null;
            next = null;
        }

        public LinkedListDequeNode(T item){
            this.item = item;
            this.prev = null;
            this.next = null;
        }
    }

    public LinkedListDeque() {
        sentinel = new LinkedListDequeNode<>();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        LinkedListDequeNode<T> cur = new LinkedListDequeNode<T>(item);
        cur.next = sentinel.next;
        cur.prev = sentinel;
        sentinel.next.prev = cur;
        sentinel.next = cur;
        size++;
    }

    @Override
    public void addLast(T item) {
        LinkedListDequeNode<T> cur = new LinkedListDequeNode<T>(item);
        cur.next = sentinel;
        cur.prev = sentinel.prev;
        sentinel.prev.next = cur;
        sentinel.prev = cur;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        LinkedListDequeNode<T> cur = sentinel.next;
        while(cur != sentinel){
            if(cur.next != sentinel)
                System.out.printf("%s ", cur.item);
            else
                System.out.printf("%s\n", cur.item);
            cur = cur.next;
        }
    }

    @Override
    public T removeFirst() {
        if(isEmpty())
            return null;
        T ret = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return ret;
    }

    @Override
    public T removeLast() {
        if(isEmpty())
            return null;
        T ret = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return ret;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size)
            return null;
        LinkedListDequeNode<T> cur = sentinel.next;
        while(index-- > 0){
            cur = cur.next;
        }
        return cur.item;
    }

    public T getRecursive(int index){
        if(index < 0 || index >= size)
            return null;
        return getRecursive(index, sentinel.next);
    }

    private T getRecursive(int index, LinkedListDequeNode<T> cur){
        if(index == 0)
            return cur.item;
        return getRecursive(index-1, cur.next);
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

}

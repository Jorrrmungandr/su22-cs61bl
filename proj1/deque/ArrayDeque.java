package deque;

public class ArrayDeque<T> implements Deque<T> {

    protected T[] array;
    protected int size;
    protected int arraySize;
    protected int head, tail;

    public ArrayDeque() {
        arraySize = 8;
        array = (T[]) new Object[arraySize];
        size = 0;
        head = 0;
        tail = 1;
    }

    protected int map(int index){
        return (index % arraySize + arraySize) % arraySize;
    }

    private void resize(int newSize){
        T[] newArray = (T[]) new Object[newSize];
        int h = map(head+1), t = map(tail-1);
        for(int i=0; i<size; ++i){
            newArray[i] = array[h];
            h++;
            if(h == arraySize){
                h = 0;
            }
        }
        array = newArray;
        arraySize = newSize;
        head = newSize - 1;
        tail = size;
    }

    @Override
    public void addFirst(T item) {
        array[head] = item;
        head = map(head-1);
        size++;
        if(size == arraySize - 1) {
            resize(arraySize * 2);
        }
    }

    @Override
    public void addLast(T item) {
        array[tail] = item;
        tail = map(tail+1);
        size++;
        if(size == arraySize){
            resize(arraySize * 2);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printDeque() {
        int h = map(head + 1), t = map(tail - 1);
        if (h < t) {
            for (int i = h; i < t; ++i) {
                System.out.printf("%s ", array[i]);
            }
        } else {
            for (int i = h; i < arraySize; ++i) {
                System.out.printf("%s ", array[i]);
            }
            for (int i = 0; i < t; ++i) {
                System.out.printf("%s ", array[i]);
            }
            System.out.printf("%s\n", array[t]);
        }
    }
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T ret = array[map(head+1)];
        head = map(head+1);
        size--;
        if(arraySize > 16 && arraySize / size >= 4){
            resize(arraySize / 2);
        }
        return ret;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T ret = array[map(tail-1)];
        tail = map(tail-1);
        size--;
        if(arraySize > 16 && arraySize / size >= 4){
            resize(arraySize / 2);
        }
        return ret;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        return array[map(head+index+1)];
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

}

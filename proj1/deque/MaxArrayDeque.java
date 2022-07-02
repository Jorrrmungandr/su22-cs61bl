package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comp;

    public MaxArrayDeque(Comparator<T> c){
        super();
        this.comp = c;
    }

    public T max(){
        return max(this.comp);
    }

    public T max(Comparator<T> c){
        if(isEmpty())
            return null;
        int h = map(head+1), t = map(tail-1);
        T ret = array[h];
        if (h < t) {
            for (int i = h; i <= t; ++i) {
                ret =  c.compare(ret, array[i]) > 0 ? ret : array[i];
            }
        } else {
            for (int i = h; i < arraySize; ++i) {
                ret =  c.compare(ret, array[i]) > 0 ? ret : array[i];
            }
            for (int i = 0; i <= t; ++i) {
                ret =  c.compare(ret, array[i]) > 0 ? ret : array[i];
            }
        }
        return ret;
    }
}

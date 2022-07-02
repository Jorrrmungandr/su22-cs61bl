package deque;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {

    private int f(int x){
        return (x-1) * (x-3);
    }
    @Override
    public int compare(Integer o1, Integer o2) {
        return f(o1) - f(o2);
    }

    public static void main(String[] args) {
        MyComparator c = new MyComparator();

    }
}

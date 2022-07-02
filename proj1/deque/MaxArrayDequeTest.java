package deque;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;



public class MaxArrayDequeTest {

    public static Comparator<Integer> c1 = new MyComparator();
    public static MaxArrayDeque<Integer> mad = new MaxArrayDeque<Integer>(c1);

    @Test
    public void Test()
    {
        mad.addLast(0);
        mad.addLast(1);
        mad.addLast(2);
        mad.addLast(5);
        assertEquals(5, (int) mad.max());
    }


}

package deque;

import org.junit.Test;

import static org.junit.Assert.*;

/* Performs some basic array deque tests. */
public class ArrayDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * ArrayDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. */

    public static ArrayDeque<Integer> ad = new ArrayDeque<Integer>();

    @Test
    /** Adds a few things to the list, checks that isEmpty() is correct.
     * This is one simple test to remind you how junit tests work. You
     * should write more tests of your own.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
        assertTrue("A newly initialized aDeque should be empty", ad.isEmpty());
        ad.addFirst(0);

        assertFalse("ad1 should now contain 1 item", ad.isEmpty());

        ad = new ArrayDeque<Integer>(); //Assigns ad equal to a new, clean LinkedListDeque!

    }

    /** Adds an item, removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        ad.addFirst(1);
        ad.removeFirst();
        assertTrue(ad.isEmpty());

        ad = new ArrayDeque<Integer>();
    }
    /** Make sure that removing from an empty LinkedListDeque does nothing */
    @Test
    public void removeEmptyTest() {
        ad.removeFirst();
        ad.removeLast();
    }
    /** Make sure your LinkedListDeque also works on non-Integer types */
    @Test
    public void multipleParamsTest() {
        LinkedListDeque<String> str_deque = new LinkedListDeque<>();
        assertTrue(str_deque.isEmpty());
        str_deque.addFirst("Hello!");
        assertFalse(str_deque.isEmpty());
    }
    /** Make sure that removing from an empty LinkedListDeque returns null */
    @Test
    public void emptyNullReturn() {
        assertNull(ad.removeFirst());
        assertNull(ad.removeLast());
    }
    /** TODO: Write tests to ensure that your implementation works for really large
     * numbers of elements, and test any other methods you haven't yet tested!
     */

    /** Make sure that get the correct item */
    @Test
    public void getTest() {
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        ad.addLast(4);
        assertEquals(3, (int) ad.get(2));
        ad = new ArrayDeque<>();
    }

    @Test
    public void resizeTest() {
        for(int i=0; i<128; ++i){
            ad.addLast(1);
        }

        for(int i=0; i<100; ++i){
            ad.removeFirst();
        }

        System.out.println(ad);
    }


}

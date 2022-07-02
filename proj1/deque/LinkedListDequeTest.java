package deque;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;


/** Performs some basic linked list deque tests. */
public class LinkedListDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * LinkedListDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. Please do not import java.util.Deque here!*/

    public static LinkedListDeque<Integer> lld = new LinkedListDeque<Integer>();

    @Test
    /** Adds a few things to the list, checks that isEmpty() is correct.
     * This is one simple test to remind you how junit tests work. You
     * should write more tests of your own.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
		assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());
		lld.addFirst(0);

        assertFalse("lld1 should now contain 1 item", lld.isEmpty());

        lld = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!

    }

    /** Adds an item, removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        lld.addFirst(1);
        lld.removeFirst();
        assertTrue(lld.isEmpty());

        lld = new LinkedListDeque<Integer>();
    }
    /** Make sure that removing from an empty LinkedListDeque does nothing */
    @Test
    public void removeEmptyTest() {
        lld.removeFirst();
        lld.removeLast();
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
        assertNull(lld.removeFirst());
        assertNull(lld.removeLast());
    }
    /** TODO: Write tests to ensure that your implementation works for really large
     * numbers of elements, and test any other methods you haven't yet tested!
     */

    /** Make sure that get the correct item */
    @Test
    public void getTest() {
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.addLast(4);
        assertEquals(3, (int) lld.get(2));
        lld = new LinkedListDeque<>();
    }

    /** Make sure that getRecursive the correct item */
    @Test
    public void getRecursiveTest() {
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.addLast(4);
        assertEquals(3, (int) lld.getRecursive(2));
        lld = new LinkedListDeque<>();
    }

}

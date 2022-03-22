import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class StackTest {
    @Test public void push(){
        Stack stack = new Stack(15);
        // Test filling an empty list
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        assertDoesNotThrow(()-> "Stack is full");
        assertTrue(stack.size == 15);

        // Test push when list is full
        int failed = 0;
        try {
            stack.push(16);
        } catch (IndexOutOfBoundsException e) {
            failed = 1;
        }
        assertTrue(failed == 1);
    }
    
    @Test public void pop(){
        Stack stack = new Stack(15);
        // Test pop when list is empty
        int retval = 0;
        try {
            retval = stack.pop();
        } catch (IndexOutOfBoundsException e) {
            retval = 1;
        }
        assertTrue(retval == 1);

        // Testing that the last pushed element is the first one to pop
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        retval = stack.pop();
        assertTrue(retval == 14);

        // Test clean the list
        for (int i = 0; i < 14; i++) {
            retval = stack.pop();
        }
        assertTrue(stack.size == 0 && retval == 0);

        // Filling the list again so we can test the second pop method
        int[] retlist;
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }

        // Test pop 0 amount of elements
        retlist = stack.pop(0);
        /* 
            We dont know how to verify this test with assert..
            We want to do something like this:

            int[] temp = new int[0];
            assertTrue(retlist.equals(temp));
        */

        // Test pop 1 amount of elements
        retlist = stack.pop(1);
        assertTrue(retlist[0] == 14);

        // Test pop all other elements
        retlist = stack.pop(14);
        assertTrue(retlist[0] == 0);
        assertTrue(retlist.length == 14);

        // Test pop when list is empty
        retval = 0;
        try {
            stack.pop(5);
        } catch (IndexOutOfBoundsException e) {
            retval = 1;
        }
        assertTrue(retval == 1);
    }
}

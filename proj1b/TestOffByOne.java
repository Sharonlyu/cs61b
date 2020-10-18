import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testOffByOne() {

        assertTrue(offByOne.equalChars('t','o'));
        assertTrue(offByOne.equalChars('s','p'));
        assertTrue(offByOne.equalChars('A','B'));
        assertTrue(offByOne.equalChars('&','%'));
        assertFalse(offByOne.equalChars('A', 'C'));
        assertFalse(offByOne.equalChars('c', '3'));
        assertFalse(offByOne.equalChars('x', 'z'));


    }

    // Your tests go here.

}

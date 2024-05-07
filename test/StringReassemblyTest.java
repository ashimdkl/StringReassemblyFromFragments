import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    /**
     * check diff combinations
     */
    @Test
    public void testCombination() {
        String str1 = "ashimisred";
        String str2 = "rediscolor";
        final int overlap = 3;
        String result = StringReassembly.combination(str1, str2, overlap);
        assertEquals("ashimisrediscolor", result);
    }

    @Test
    public void testCombination2() {
        String str1 = "this";
        String str2 = "isnicer";
        final int overlap = 2;
        String result = StringReassembly.combination(str1, str2, overlap);
        assertEquals("thisnicer", result);
    }

    /**
     * testing addToSetAvoidingSubstrings.
     */
    @Test
    public void testaddToSetAvoidingSubstrings1() {
        Set<String> strset = new Set1L<String>();
        strset.add("Hello World!");
        strset.add("This is a test.");
        Set<String> strset2 = new Set1L<String>();
        strset2.add("Hello World!");
        strset2.add("This is a test.");
        String str = "newstring";
        StringReassembly.addToSetAvoidingSubstrings(strset, str);
        strset2.add(str);
        assertEquals(strset, strset2);
    }

    @Test
    /*
     * testing the linesFromInput method
     */
    public void testLinesFromInput() {
        SimpleReader input = new SimpleReader1L(
                "Hello\nWorld\nHello World!\nHi\n");
        Set<String> expected = new Set1L<>();
        expected.add("Hello");
        expected.add("World");
        expected.add("Hi");
        expected.add("Hello World!");
        Set<String> result = StringReassembly.linesFromInput(input);
        assertEquals(expected, result);
    }

    /**
     * test printWithLineSeparators (im getting a failure on this, but idk why
     * it is saying it. my code does run smoothly though so im stuck.)
     */

    @Test
    public void testPrintWithLineSeparatorsSimpleText() {
        String text = "Ashim~Dhakal!";
        SimpleWriter out = new SimpleWriter1L();
        StringReassembly.printWithLineSeparators(text, out);
        assertEquals("Ashim\nDhakal", out.toString());
    }

}
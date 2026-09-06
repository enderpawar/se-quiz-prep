package prep;

import static mini.Assertions.assertEquals;
import static mini.Assertions.assertFalse;
import static mini.Assertions.assertTrue;

import mini.Test;

public class StringOpsTest {

    @Test
    void test1_reverse() {
        assertEquals("cba", StringOps.reverse("abc"));
        assertEquals("", StringOps.reverse(""));
        assertEquals("a", StringOps.reverse("a"));
    }

    @Test
    void test2_isPalindrome() {
        assertTrue(StringOps.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(StringOps.isPalindrome("racecar"));
        assertTrue(StringOps.isPalindrome(""));
        assertTrue(StringOps.isPalindrome(".,"));
        assertFalse(StringOps.isPalindrome("hello"));
        assertFalse(StringOps.isPalindrome("ab@ba c"));
    }

    @Test
    void test3_countChar() {
        assertEquals(3, StringOps.countChar("banana", 'a'));
        assertEquals(0, StringOps.countChar("banana", 'z'));
        assertEquals(0, StringOps.countChar("", 'a'));
    }

    @Test
    void test4_joinWords() {
        assertEquals("hello-java-world", StringOps.joinWords("hello java world", "-"));
        assertEquals("a,b", StringOps.joinWords("  a   b  ", ","));
        assertEquals("solo", StringOps.joinWords("solo", "-"));
    }

    @Test
    void test5_capitalizeEach() {
        assertEquals("Hello Java World", StringOps.capitalizeEach("hello java  world"));
        assertEquals("A", StringOps.capitalizeEach("a"));
        assertEquals("Java", StringOps.capitalizeEach("jAVA"));
    }
}

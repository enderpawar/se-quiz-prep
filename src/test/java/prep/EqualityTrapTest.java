package prep;

import static mini.Assertions.assertEquals;
import static mini.Assertions.assertFalse;
import static mini.Assertions.assertTrue;

import mini.Test;

/**
 * 이 파일이 곧 정답표다. 왜 이렇게 되는지 설명할 수 있으면 이 문제는 끝난 것이다.
 */
public class EqualityTrapTest {

    @Test
    void test1_integerCache() {
        assertTrue(EqualityTrap.smallIntegersSameRef(), "127 은 Integer 캐시 안에 있다");
        assertFalse(EqualityTrap.largeIntegersSameRef(), "128 은 캐시 범위를 벗어난다");
    }

    @Test
    void test2_stringIdentity() {
        assertFalse(EqualityTrap.newStringsSameRef(), "new 는 매번 새 객체를 만든다");
        assertTrue(EqualityTrap.newStringsEqual(), "equals 는 내용을 비교한다");
        assertTrue(EqualityTrap.literalStringsSameRef(), "리터럴은 String Pool 을 공유한다");
    }

    @Test
    void test3_intDivision() {
        assertEquals(3, EqualityTrap.intDivision(7, 2));
        assertEquals(-3, EqualityTrap.intDivision(-7, 2));   // 파이썬이면 -4
        assertEquals(0, EqualityTrap.intDivision(1, 2));
    }

    @Test
    void test4_intRemainder() {
        assertEquals(1, EqualityTrap.intRemainder(7, 2));
        assertEquals(-1, EqualityTrap.intRemainder(-7, 2));  // 파이썬이면 1
        assertEquals(0, EqualityTrap.intRemainder(8, 4));
    }

    @Test
    void test5_overflow() {
        assertEquals(Integer.MIN_VALUE, EqualityTrap.overflowSum());
        assertEquals(2147483648L, EqualityTrap.safeSum());
    }

    @Test
    void test6_charArithmetic() {
        assertEquals('b', EqualityTrap.nextChar('a'));
        assertEquals('1', EqualityTrap.nextChar('0'));
    }
}

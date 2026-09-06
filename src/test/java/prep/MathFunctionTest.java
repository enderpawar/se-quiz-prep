package prep;

import static mini.Assertions.assertEquals;
import static mini.Assertions.assertTrue;

import mini.Test;

/**
 * 2025년 자동채점 과제의 테스트를 거의 그대로 옮긴 것.
 * 이 파일은 고치지 않는다. 이게 곧 명세다.
 */
public class MathFunctionTest {

    @Test
    void test1_max() {
        assertEquals(5, MathFunction.max(2.0d, 5.0d));
        assertEquals(-2, MathFunction.max(-2.0d, -5.0d));
        assertEquals(3, MathFunction.max(3.0000, 3.0000));
        assertTrue(MathFunction.max(2.0, 2.0) == 2.000);
    }

    @Test
    void test2_fact() {
        assertEquals(1, MathFunction.fact(0));
        assertEquals(1, MathFunction.fact(1));
        assertTrue(MathFunction.fact(5) == 120);
    }

    @Test
    void test3_fib() {
        // 주의: fib(0) 이 0 이 아니다. 테스트가 명세다.
        assertEquals(-1, MathFunction.fib(0));
        assertEquals(1, MathFunction.fib(1));
        assertEquals(1, MathFunction.fib(2));
        assertEquals(5, MathFunction.fib(5));
        assertTrue(MathFunction.fib(20) == 6765);
    }
}

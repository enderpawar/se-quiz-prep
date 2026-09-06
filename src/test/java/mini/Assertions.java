package mini;

import java.util.Arrays;

/**
 * JUnit 5의 org.junit.jupiter.api.Assertions 를 흉내낸 것.
 * 메서드 이름과 인자 순서를 JUnit 과 똑같이 맞춰 두었다.
 *
 * 중요: assertEquals(expected, actual) — 기대값이 앞, 실제값이 뒤다.
 *       시험에 이 순서를 묻는 문제가 나올 수 있다.
 */
public final class Assertions {

    private Assertions() {
    }

    // ---- assertEquals ----------------------------------------------------

    public static void assertEquals(long expected, long actual) {
        if (expected != actual) {
            fail(String.valueOf(expected), String.valueOf(actual), null);
        }
    }

    public static void assertEquals(long expected, long actual, String message) {
        if (expected != actual) {
            fail(String.valueOf(expected), String.valueOf(actual), message);
        }
    }

    public static void assertEquals(double expected, double actual) {
        if (Double.compare(expected, actual) != 0) {
            fail(String.valueOf(expected), String.valueOf(actual), null);
        }
    }

    public static void assertEquals(double expected, double actual, double delta) {
        if (Math.abs(expected - actual) > delta) {
            fail(String.valueOf(expected), String.valueOf(actual), null);
        }
    }

    public static void assertEquals(Object expected, Object actual) {
        if (!java.util.Objects.equals(expected, actual)) {
            fail(str(expected), str(actual), null);
        }
    }

    public static void assertEquals(Object expected, Object actual, String message) {
        if (!java.util.Objects.equals(expected, actual)) {
            fail(str(expected), str(actual), message);
        }
    }

    // ---- assertTrue / assertFalse ---------------------------------------

    public static void assertTrue(boolean condition) {
        if (!condition) {
            fail("true", "false", null);
        }
    }

    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            fail("true", "false", message);
        }
    }

    public static void assertFalse(boolean condition) {
        if (condition) {
            fail("false", "true", null);
        }
    }

    public static void assertFalse(boolean condition, String message) {
        if (condition) {
            fail("false", "true", message);
        }
    }

    // ---- null ------------------------------------------------------------

    public static void assertNull(Object actual) {
        if (actual != null) {
            fail("null", str(actual), null);
        }
    }

    public static void assertNotNull(Object actual) {
        if (actual == null) {
            fail("not null", "null", null);
        }
    }

    public static void assertNotNull(Object actual, String message) {
        if (actual == null) {
            fail("not null", "null", message);
        }
    }

    // ---- 배열 -------------------------------------------------------------

    public static void assertArrayEquals(int[] expected, int[] actual) {
        if (!Arrays.equals(expected, actual)) {
            fail(Arrays.toString(expected), Arrays.toString(actual), null);
        }
    }

    public static void assertArrayEquals(int[] expected, int[] actual, String message) {
        if (!Arrays.equals(expected, actual)) {
            fail(Arrays.toString(expected), Arrays.toString(actual), message);
        }
    }

    // ---- 내부 -------------------------------------------------------------

    private static String str(Object o) {
        if (o == null) {
            return "null";
        }
        if (o instanceof int[]) {
            return Arrays.toString((int[]) o);
        }
        if (o instanceof Object[]) {
            return Arrays.deepToString((Object[]) o);
        }
        return o.toString();
    }

    private static void fail(String expected, String actual, String message) {
        String head = (message == null || message.isEmpty()) ? "" : message + " ==> ";
        throw new AssertionError(head + "expected: <" + expected + "> but was: <" + actual + ">");
    }
}

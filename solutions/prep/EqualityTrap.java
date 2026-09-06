package prep;

/**
 * 각 메서드 위에 "왜 그런가"를 한 줄로 적어 두었다. 이 설명을 말로 할 수 있으면 된 것이다.
 */
public class EqualityTrap {

    /** -128 ~ 127 은 Integer 캐시에 미리 만들어져 있어 같은 객체가 재사용된다 → true */
    public static boolean smallIntegersSameRef() {
        Integer a = 127;
        Integer b = 127;
        return a == b;
    }

    /** 128 은 캐시 밖이라 매번 새 객체가 만들어진다 → false */
    public static boolean largeIntegersSameRef() {
        Integer a = 128;
        Integer b = 128;
        return a == b;
    }

    /** new 는 무조건 새 객체를 만든다. == 는 주소 비교라 다르다 → false */
    public static boolean newStringsSameRef() {
        String a = new String("hi");
        String b = new String("hi");
        return a == b;
    }

    /** equals 는 내용을 비교한다 → true */
    public static boolean newStringsEqual() {
        String a = new String("hi");
        String b = new String("hi");
        return a.equals(b);
    }

    /** 리터럴은 String Pool 에 하나만 만들어져 공유된다 → true (우연히 맞는 것뿐이다) */
    public static boolean literalStringsSameRef() {
        String a = "hi";
        String b = "hi";
        return a == b;
    }

    /** 자바 int 나눗셈은 0 방향으로 버린다. -7 / 2 == -3 (파이썬 // 는 -4) */
    public static int intDivision(int a, int b) {
        return a / b;
    }

    /** 자바 나머지는 왼쪽 피연산자의 부호를 따른다. -7 % 2 == -1 (파이썬은 1) */
    public static int intRemainder(int a, int b) {
        return a % b;
    }

    /** int 는 32비트라 한 바퀴 돌아 Integer.MIN_VALUE 가 된다 */
    public static int overflowSum() {
        int max = Integer.MAX_VALUE;
        return max + 1;
    }

    /** 더하기 전에 long 으로 넓혀야 한다. (long)(MAX + 1) 은 이미 늦었다 */
    public static long safeSum() {
        return (long) Integer.MAX_VALUE + 1;
    }

    /** 'a' + 1 의 결과 타입은 int 다. char 로 되돌리려면 캐스팅이 필요하다 */
    public static char nextChar(char c) {
        return (char) (c + 1);
    }
}

package prep;

/**
 * [A5] 자바 함정 모음. 이 문제만 성격이 다르다.
 *
 * 여기 있는 메서드들은 "자바가 실제로 어떻게 동작하는가"를 그대로 돌려주면 된다.
 * 테스트 파일에 정답이 적혀 있다. 맞히는 게 목적이 아니라, 왜 그런지 알고 넘어가는 게 목적이다.
 *
 * ★ 리터럴로 때우지 말 것. ★
 *   return true;  이렇게 쓰면 통과는 하지만 아무것도 안 배운다.
 *   실제로 변수를 만들고 연산해서 그 결과를 돌려줄 것.
 *
 * 객관식으로 나오기 딱 좋은 것들만 골랐다.
 */
public class EqualityTrap {

    /**
     * Integer a = 127, b = 127 일 때 a == b 의 값.
     *
     * 힌트: 자바는 -128 ~ 127 범위의 Integer 객체를 미리 만들어 재사용한다 (Integer 캐시).
     */
    public static boolean smallIntegersSameRef() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Integer a = 128, b = 128 일 때 a == b 의 값.
     *
     * 힌트: 127 을 넘어가면 캐시를 벗어난다. 위 메서드와 결과를 비교해 볼 것.
     *       그래서 래퍼 타입 비교는 항상 .equals() 를 써야 한다.
     */
    public static boolean largeIntegersSameRef() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * new String("hi") == new String("hi") 의 값.
     *
     * 힌트: == 는 참조(주소) 비교다. new 는 매번 새 객체를 만든다.
     */
    public static boolean newStringsSameRef() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * new String("hi").equals(new String("hi")) 의 값.
     *
     * 힌트: .equals() 는 내용 비교다.
     */
    public static boolean newStringsEqual() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 문자열 리터럴 "hi" == "hi" 의 값.
     *
     * 힌트: 리터럴은 String Pool 에 하나만 만들어져 공유된다.
     *       그래서 == 가 우연히 true 가 된다. 이 "우연"이 함정의 핵심이다.
     */
    public static boolean literalStringsSameRef() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 자바에서 a / b 를 계산한 결과 (int 나눗셈).
     *
     * 힌트: 파이썬의 // 와 다르다.
     *       파이썬 -7 // 2 는 -4 (음의 무한대 방향으로 내림)
     *       자바   -7 /  2 는 ?   (0 방향으로 버림)
     */
    public static int intDivision(int a, int b) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 자바에서 a % b 를 계산한 결과.
     *
     * 힌트: 파이썬 -7 % 2 는 1 이다. 자바는 다르다.
     *       자바의 나머지는 왼쪽 피연산자의 부호를 따라간다.
     */
    public static int intRemainder(int a, int b) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * int 로 Integer.MAX_VALUE + 1 을 계산한 결과.
     *
     * 힌트: 파이썬 정수는 무한히 커지지만 자바 int 는 32비트다. 한 바퀴 돈다.
     */
    public static int overflowSum() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * long 으로 안전하게 계산한 Integer.MAX_VALUE + 1.
     *
     * 힌트: (long) Integer.MAX_VALUE + 1
     *       캐스팅을 어디에 붙이느냐가 중요하다.
     *       (long)(Integer.MAX_VALUE + 1) 은 이미 넘친 뒤라 소용없다.
     */
    public static long safeSum() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * char 는 정수처럼 계산된다. 'a' + 1 을 char 로 되돌린 값.
     *
     * 힌트: 'a' + 1 의 타입은 char 가 아니라 int 다. 다시 (char) 로 캐스팅해야 한다.
     */
    public static char nextChar(char c) {
        throw new UnsupportedOperationException("TODO");
    }
}

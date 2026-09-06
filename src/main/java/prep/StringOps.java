package prep;

/**
 * [A3] 문자열. 자바 문자열은 파이썬과 다루는 법이 꽤 다르다.
 *
 * 반드시 기억할 것
 *   - s[i] 가 없다. s.charAt(i) 를 쓴다.
 *   - s[a:b] 가 없다. s.substring(a, b) 를 쓴다. (b 는 포함 안 됨)
 *   - 문자열은 불변이다. 반복문 안에서 s += x 하면 매번 새 객체를 만든다.
 *     누적할 때는 StringBuilder 를 쓴다.
 *   - 비교는 == 가 아니라 .equals() 다. 이건 시험에 거의 확실히 나온다.
 */
public class StringOps {

    /**
     * 뒤집은 문자열.
     *
     * 파이썬: s[::-1]
     * 자바 힌트: new StringBuilder(s).reverse().toString()
     *            직접 for 문으로 짜 보는 것도 좋다.
     */
    public static String reverse(String s) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 팰린드롬인지 판정한다. 영문자와 숫자만 보고, 대소문자는 무시한다.
     * 공백과 문장부호는 없는 셈 친다.
     *
     * 예: "A man, a plan, a canal: Panama" → true
     *
     * 자바 힌트: Character.isLetterOrDigit(c), Character.toLowerCase(c)
     */
    public static boolean isPalindrome(String s) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 문자 c 가 몇 번 나오는지 센다.
     *
     * 파이썬: s.count(c)
     * 자바 힌트: for (int i = 0; i < s.length(); i++) { s.charAt(i) ... }
     */
    public static int countChar(String s, char c) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 공백으로 나눈 단어들을 sep 로 다시 잇는다.
     *
     * 예: joinWords("hello java world", "-") → "hello-java-world"
     *
     * 파이썬: sep.join(sentence.split())
     * 자바 힌트: sentence.trim().split("\\s+") 로 나누고 String.join(sep, 배열)
     *            split 의 인자는 문자열이 아니라 정규식이다.
     */
    public static String joinWords(String sentence, String sep) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 각 단어의 첫 글자를 대문자로 바꾼다. 단어 사이 공백은 하나로 정리한다.
     *
     * 예: "hello java  world" → "Hello Java World"
     */
    public static String capitalizeEach(String sentence) {
        throw new UnsupportedOperationException("TODO");
    }
}

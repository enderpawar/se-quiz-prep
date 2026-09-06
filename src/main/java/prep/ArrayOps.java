package prep;

/**
 * [A2] 배열. 파이썬 list 와 자바 배열의 차이가 몸에 배게 하는 게 목적이다.
 *
 * 반드시 기억할 것
 *   - 배열 길이는 arr.length     (괄호 없음, 필드다)
 *   - 문자열 길이는 s.length()   (괄호 있음, 메서드다)
 *   - 리스트 길이는 list.size()
 *   - 배열은 크기가 고정이다. append 가 없다.
 *   - new int[n] 은 전부 0 으로 자동 초기화된다.
 */
public class ArrayOps {

    /**
     * 배열에서 가장 큰 값. 빈 배열이면 Integer.MIN_VALUE 를 돌려준다.
     *
     * 파이썬: max(arr) if arr else -inf
     * 자바 힌트: for (int x : arr) 향상된 for 문
     */
    public static int maxOf(int[] arr) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 순서를 뒤집은 새 배열. 원본은 건드리지 않는다.
     *
     * 파이썬: arr[::-1]
     * 자바에는 [::-1] 같은 게 없다. 새 배열을 만들고 직접 채워야 한다.
     */
    public static int[] reversed(int[] arr) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 오름차순 정렬된 새 배열. 원본은 건드리지 않는다.
     *
     * 파이썬: sorted(arr)
     * 자바 힌트: Arrays.copyOf 로 복사한 뒤 Arrays.sort
     *            (Arrays.sort 는 원본을 그 자리에서 바꾼다. 파이썬 list.sort() 쪽에 가깝다)
     */
    public static int[] sortedCopy(int[] arr) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 2차원 배열의 모든 값을 더한다.
     *
     * 자바 힌트: grid.length 가 행 개수, grid[0].length 가 열 개수
     */
    public static int sumOfGrid(int[][] grid) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 길이 n 짜리 배열을 만들어 전부 value 로 채운다.
     *
     * 파이썬: [value] * n
     * 자바 힌트: Arrays.fill
     */
    public static int[] filled(int n, int value) {
        throw new UnsupportedOperationException("TODO");
    }
}

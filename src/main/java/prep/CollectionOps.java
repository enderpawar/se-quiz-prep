package prep;

import java.util.List;
import java.util.Map;

/**
 * [A4] 컬렉션. 파이썬 dict / set / list / deque / heapq 를 자바로 옮기는 훈련.
 *
 * 대응표
 *   dict   → Map<K, V>      new HashMap<>()
 *   set    → Set<E>         new HashSet<>()
 *   list   → List<E>        new ArrayList<>()
 *   deque  → Deque<E>       new ArrayDeque<>()
 *   heapq  → PriorityQueue<E>   (기본은 최소 힙. 파이썬 heapq 와 같다)
 *
 * 선언은 인터페이스로, 생성은 구현체로 하는 습관을 들이자.
 *   List<Integer> nums = new ArrayList<>();
 */
public class CollectionOps {

    /**
     * 각 문자가 몇 번 나오는지 세어 Map 으로 돌려준다.
     *
     * 파이썬: Counter(s)  또는  d[c] = d.get(c, 0) + 1
     * 자바 힌트: map.put(c, map.getOrDefault(c, 0) + 1);
     *            더 짧게는 map.merge(c, 1, Integer::sum);
     */
    public static Map<Character, Integer> charFrequency(String s) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 중복을 없애고 오름차순으로 정렬한 리스트.
     *
     * 파이썬: sorted(set(arr))
     * 자바 힌트: HashSet 에 넣었다가 ArrayList 로 옮기고 Collections.sort
     */
    public static List<Integer> dedupSorted(int[] arr) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 길이가 짧은 순으로, 길이가 같으면 사전순으로 정렬한 새 리스트.
     * 원본 리스트는 건드리지 않는다.
     *
     * 파이썬: sorted(words, key=lambda w: (len(w), w))
     * 자바 힌트: Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())
     */
    public static List<String> sortByLengthThenAlpha(List<String> words) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 가장 큰 값 k 개를 큰 것부터 순서대로 담은 배열.
     * k 가 배열 길이보다 크면 있는 만큼만 돌려준다.
     *
     * 파이썬: heapq.nlargest(k, arr)
     * 자바 힌트: PriorityQueue 는 기본이 최소 힙이다.
     *            큰 것부터 꺼내려면 new PriorityQueue<>(Comparator.reverseOrder())
     */
    public static int[] topK(int[] arr, int k) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * 왼쪽으로 k 칸 회전시킨 새 리스트.
     * k 가 리스트 길이보다 커도 동작해야 한다.
     *
     * 예: rotateLeft([1,2,3,4,5], 2) → [3,4,5,1,2]
     *
     * 파이썬: d = deque(list); d.rotate(-k)
     * 자바 힌트: ArrayDeque 에 넣고 pollFirst / addLast 를 k 번,
     *            또는 인덱스 계산 (i + k) % n 으로 바로 만들 수도 있다.
     */
    public static List<Integer> rotateLeft(List<Integer> list, int k) {
        throw new UnsupportedOperationException("TODO");
    }
}

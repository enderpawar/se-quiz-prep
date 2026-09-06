package prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class CollectionOps {

    public static Map<Character, Integer> charFrequency(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 아래 두 줄은 같은 뜻이다. 둘 다 알아 두면 좋다.
            // counts.put(c, counts.getOrDefault(c, 0) + 1);
            counts.merge(c, 1, Integer::sum);
        }
        return counts;
    }

    public static List<Integer> dedupSorted(int[] arr) {
        Set<Integer> unique = new HashSet<>();
        for (int x : arr) {
            unique.add(x);
        }
        List<Integer> result = new ArrayList<>(unique);
        Collections.sort(result);
        return result;
    }

    public static List<String> sortByLengthThenAlpha(List<String> words) {
        List<String> copy = new ArrayList<>(words);
        copy.sort(Comparator.<String>comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()));
        return copy;
    }

    public static int[] topK(int[] arr, int k) {
        // PriorityQueue 는 기본이 최소 힙이라, 큰 것부터 꺼내려면 비교기를 뒤집는다.
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int x : arr) {
            heap.add(x);
        }
        int size = Math.min(Math.max(k, 0), arr.length);
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

    public static List<Integer> rotateLeft(List<Integer> list, int k) {
        int n = list.size();
        List<Integer> result = new ArrayList<>(n);
        if (n == 0) {
            return result;                    // n 이 0 이면 % 연산에서 터진다. 먼저 걸러낸다.
        }
        int shift = ((k % n) + n) % n;        // k 가 음수여도 안전하게
        for (int i = 0; i < n; i++) {
            result.add(list.get((i + shift) % n));
        }
        return result;
    }
}

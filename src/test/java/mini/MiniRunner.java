package mini;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 아주 작은 테스트 러너. @Test 가 붙은 메서드를 찾아 실행하고 결과를 정리해서 보여준다.
 * 실제 수업에서는 이 역할을 Gradle + JUnit 5 가 한다 (gradle test).
 */
public final class MiniRunner {

    /** {문제번호, 테스트 클래스, 설명} */
    private static final String[][] SUITES = {
            {"A1", "prep.MathFunctionTest", "MathFunction  ·  2025년 실제 출제 형식"},
            {"A2", "prep.ArrayOpsTest", "ArrayOps  ·  배열"},
            {"A3", "prep.StringOpsTest", "StringOps  ·  문자열"},
            {"A4", "prep.CollectionOpsTest", "CollectionOps  ·  컬렉션"},
            {"A5", "prep.EqualityTrapTest", "EqualityTrap  ·  자바 함정"},
            {"B1", "prep.TreeTraversalTest", "TreeTraversal  ·  트리 순회"},
            {"B2", "prep.LevelOrderTest", "LevelOrder  ·  BFS 레벨 순회"},
            {"B3", "prep.BstOpsTest", "BstOps  ·  이진 탐색 트리"},
            {"B4", "prep.GraphSearchTest", "GraphSearch  ·  그래프 BFS/DFS"},
            {"B5", "prep.GridBfsTest", "GridBfs  ·  격자 탐색"},
    };

    private static final String LINE =
            "────────────────────────────────────────────────────────";

    private int passed;
    private int failed;
    private int todo;

    public static void main(String[] args) throws Exception {
        String filter = (args.length > 0 && !args[0].isBlank()) ? args[0].trim() : null;
        MiniRunner runner = new MiniRunner();
        runner.runAll(filter);
    }

    private void runAll(String filter) throws Exception {
        List<String[]> selected = new ArrayList<>();
        for (String[] suite : SUITES) {
            if (filter == null || matches(suite, filter)) {
                selected.add(suite);
            }
        }

        if (selected.isEmpty()) {
            System.out.println("'" + filter + "' 와 맞는 문제가 없습니다.");
            System.out.println("사용 가능: A1 A2 A3 A4 A5 B1 B2 B3 B4 B5, 또는 클래스 이름 일부");
            System.exit(2);
        }

        for (String[] suite : selected) {
            runSuite(suite);
        }

        int total = passed + failed + todo;
        System.out.println(LINE);
        System.out.printf("결과: %d / %d 통과", passed, total);
        if (todo > 0 || failed > 0) {
            System.out.printf("     (아직 안 푼 것 %d, 틀린 것 %d)", todo, failed);
        }
        System.out.println();
        if (passed == total) {
            System.out.println("전부 통과했습니다.");
        }
        System.exit(failed + todo == 0 ? 0 : 1);
    }

    private static boolean matches(String[] suite, String filter) {
        String id = suite[0];
        String cls = suite[1].substring(suite[1].lastIndexOf('.') + 1);
        return id.equalsIgnoreCase(filter)
                || cls.toLowerCase().startsWith(filter.toLowerCase())
                || cls.toLowerCase().startsWith(filter.toLowerCase() + "test");
    }

    private void runSuite(String[] suite) throws Exception {
        System.out.println();
        System.out.println("=== " + suite[0] + "  " + suite[2] + " ===");

        Class<?> clazz = Class.forName(suite[1]);
        Object instance = clazz.getDeclaredConstructor().newInstance();

        List<Method> tests = new ArrayList<>();
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests.add(m);
            }
        }
        tests.sort(Comparator.comparing(Method::getName));

        for (Method m : tests) {
            m.setAccessible(true);
            try {
                m.invoke(instance);
                passed++;
                System.out.println("  [PASS] " + m.getName());
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause instanceof UnsupportedOperationException) {
                    todo++;
                    System.out.println("  [TODO] " + m.getName() + "   아직 구현 안 됨");
                } else if (cause instanceof AssertionError) {
                    failed++;
                    System.out.println("  [FAIL] " + m.getName() + "   " + cause.getMessage());
                } else {
                    failed++;
                    System.out.println("  [FAIL] " + m.getName() + "   "
                            + cause.getClass().getSimpleName() + ": " + cause.getMessage());
                    printTopFrame(cause);
                }
            }
        }
    }

    private static void printTopFrame(Throwable t) {
        StackTraceElement[] frames = t.getStackTrace();
        Arrays.stream(frames)
                .filter(f -> f.getClassName().startsWith("prep."))
                .findFirst()
                .ifPresent(f -> System.out.println("         → " + f));
    }
}

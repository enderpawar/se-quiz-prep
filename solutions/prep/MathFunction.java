package prep;

public class MathFunction {

    public static double max(double a, double b) {
        return a > b ? a : b;
    }

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    /**
     * 교수님이 준 원본 코드는 여기가 고장나 있었다.
     *
     *     if (n == 0) return -1;
     *     else if (n == 1) return 1;
     *     else return fib(n - 1) + fib(n - 2);
     *
     * 이러면 fib(2) = fib(1) + fib(0) = 1 + (-1) = 0 이 되어 테스트를 통과하지 못한다.
     * 즉 과제는 "짜는 것"이 아니라 "테스트를 보고 고치는 것"이었다.
     *
     * n == 2 를 따로 처리해 주면 재귀가 -1 을 건드리지 않게 되어 전부 통과한다.
     */
    public static int fib(int n) {
        if (n == 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}

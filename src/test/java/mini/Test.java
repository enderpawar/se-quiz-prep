package mini;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * JUnit 5의 org.junit.jupiter.api.Test 와 동일한 역할.
 * 외부 라이브러리 없이 돌리기 위해 직접 정의한 것뿐이고, 쓰는 방법은 똑같다.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}

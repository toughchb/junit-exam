import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class MyTest {

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }

    @Test
    @DisplayName("던지는 예외를 테스트 할 수 있다.")
    void shouldThrowException() {
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Not supported");
        });
        System.out.println(exception.getMessage());
        Assertions.assertThat(exception.getMessage()).startsWith("Not supported");

        //assertEquals(exception.getMessage(), "Not supported");
    }

    @Test
    void numberAdd() {
        assertEquals(3, 1+2);
        Assertions.assertThat(1 + 2).isEqualTo(3);
    }

    @Test
    @DisplayName("╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @DisplayName("😱")
    void testWithDisplayNameContainingEmoji() {
    }

    @Test
    @DisplayName("테스트를 스킵시킬수 있다.")
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @RepeatedTest(10)
    void repeatedTest() {
        System.out.println("repeat");
    }


    @Test
    @Disabled("비활성화 테스트")
    void trueAssumption() {
        assumeTrue(5 > 1);
        assertEquals(7, 5+2);
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void failsIfExecutionTimeExceeds100Milliseconds() throws InterruptedException {
        // fails if execution time exceeds 100 milliseconds
        //Thread.sleep(1000);
    }

    @Test
    void assertAllTest() {
        assertAll(
                () -> assertTrue(true),
                () -> assertTrue(true),
                () -> assertEquals(3,1+2)
        );
    }

}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.condition.JRE.*;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.MAC;

public class ConditionalTest {


    //OS Conditional Test
    @Test
    @EnabledOnOs(MAC)
    void onlyOnMacOs() {
        // ...
    }
    @Test
    @EnabledOnOs({ LINUX, MAC })
    void onLinuxOrMac() {
        // ...
    }

    //JAVA Conditional Test

    @Test
    @EnabledOnJre({JAVA_9, JAVA_10})
    void onJava9Or10() {
        // ...

    }

    @Test
    @EnabledForJreRange(min = JAVA_9)
    void fromJava9toCurrentJavaFeatureNumber() {
        // ...
    }

    @Test
    @EnabledForJreRange(max = JAVA_11)
    void fromJava8To11() {
        // ...
    }


    // Environment Variable Conditional Test
    @Test
    @EnabledIfEnvironmentVariable(named = "SQUERY_JDBC_HOME", matches = "D:*")
    void envVariableTest() {

    }
}

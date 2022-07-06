package be.yildizgames.common.logging.logback;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Grégory Van den Borre
 */
class LogbackEngineProviderTest {

    @Test
    void happyFlow() {
        LogbackEngineProvider provider = new LogbackEngineProvider();
        Assertions.assertNotNull(provider.getLogEngine());
    }
}

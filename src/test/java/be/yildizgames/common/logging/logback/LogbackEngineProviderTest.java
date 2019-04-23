package be.yildizgames.common.logging.logback;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogbackEngineProviderTest {

    @Test
    public void happyFlow() {
        LogbackEngineProvider provider = new LogbackEngineProvider();
        Assertions.assertNotNull(provider.getLogEngine());
    }
}

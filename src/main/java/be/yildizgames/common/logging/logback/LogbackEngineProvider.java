package be.yildizgames.common.logging.logback;

import be.yildizgames.common.logging.LogEngine;
import be.yildizgames.common.logging.LogEngineProvider;

/**
 * Provide the log engine.
 * @author Grégory Van den Borre
 */
public class LogbackEngineProvider implements LogEngineProvider {

    /**
     * Provide the engine.
     * @return The log engine.
     */
    @Override
    public final LogEngine getLogEngine() {
        return new LogbackLogEngine();
    }
}

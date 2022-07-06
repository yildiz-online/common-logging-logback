/*
 *
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 * Copyright (c) 2019 Grégory Van den Borre
 *
 * More infos available: https://engine.yildiz-games.be
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without
 * limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 *
 */

package be.yildizgames.common.logging.logback;

import be.yildizgames.common.logging.LoggerConfiguration;
import be.yildizgames.common.logging.LoggerLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author Grégory Van den Borre
 */
class LogbackLogEngineTest {

    @Nested
    class ConfigureFromProperties {

        private final String PATTERN_OK = "%n";

        @Test
        void nullParam() {
            LogbackLogEngine engine = new LogbackLogEngine();
            Assertions.assertThrows(NullPointerException.class, () -> engine.configureFromProperties(null));
        }

        @Test
        void logbackXmlNotExist() throws IOException {
            LogbackLogEngine engine = new LogbackLogEngine();
            engine.configureFromProperties(givenAConfiguration(PATTERN_OK, LoggerLevel.INFO, LoggerConfiguration.SupportedOutput.CONSOLE));
        }
    }

    private static LoggerConfiguration givenAConfiguration(String pattern, LoggerLevel level, LoggerConfiguration.SupportedOutput output) {
        return new LoggerConfiguration() {
            @Override
            public String getLoggerPattern() {
                return pattern;
            }

            @Override
            public LoggerLevel getLoggerLevel() {
                return level;
            }

            @Override
            public SupportedOutput getLoggerOutput() {
                return output;
            }

            @Override
            public String getLoggerTcpHost() {
                return "localhost";
            }

            @Override
            public int getLoggerTcpPort() {
                return 10;
            }

            @Override
            public String getLoggerOutputFile() {
                return "test.log";
            }

            @Override
            public String getLoggerConfigurationFile() {
                return "not/notExist.xml";
            }

            @Override
            public List<String> getLoggerToDisable() {
                return Collections.emptyList();
            }
        };
    }

}

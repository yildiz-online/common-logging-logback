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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * @author Grégory Van den Borre
 */
public class LogbackConfigFileGeneratorTest {

    @Nested
    public class Generate {

        @Test
        public void file() {
            LogbackConfigFileGenerator generator = new be.yildizgames.common.logging.logback.LogbackConfigFileGenerator();
            String result = generator.generate(new DummyLoggerConfiguration(LoggerConfiguration.SupportedOutput.FILE));
            Assertions.assertEquals(result,
                    "<configuration>\n"
                            + "  <timestamp key=\"byDay\" datePattern=\"yyyy-MM-dd\"/>\n"
                            + "  <appender name=\"FILE\" class=\"ch.qos.logback.core.FileAppender\">\n"
                            + "    <file>/output-${byDay}.txt </file>\n"
                            + "    <append>true</append>\n"
                            + "    <encoder>\n"
                            + "    <pattern>%n</pattern>\n"
                            + "    </encoder>\n"
                            + "  </appender>\n"
                            + "  <root level=\"DEBUG\">\n"
                            + "    <appender-ref ref=\"FILE\" />\n"
                            + "  </root>\n"
                            + "</configuration>\n"
                    );
        }

        @Test
        public void tcp() {
            LogbackConfigFileGenerator generator = new be.yildizgames.common.logging.logback.LogbackConfigFileGenerator();
            String result = generator.generate(new DummyLoggerConfiguration(LoggerConfiguration.SupportedOutput.TCP));
            Assertions.assertEquals(result,
                    "<configuration>\n"
                            + "  <appender name=\"TCP\" class=\"com.splunk.logging.TcpAppender\">\n"
                            + "    <RemoteHost>localhost</RemoteHost>\n"
                            + "    <Port>25</Port>\n"
                            + "    <layout class=\"ch.qos.logback.classic.PatternLayout\">\n"
                            + "    <pattern>%n</pattern>\n"
                            + "    </layout>\n"
                            + "  </appender>\n"
                            + "  <root level=\"DEBUG\">\n"
                            + "    <appender-ref ref=\"TCP\" />\n"
                            + "  </root>\n"
                            + "</configuration>\n"
            );
        }
    }
}

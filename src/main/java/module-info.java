/**
 * @author Grégory Van den Borre
 */
module be.yildizgames.common.logging.logback {

    requires be.yildizgames.common.exception;
    requires be.yildizgames.common.util;
    requires be.yildizgames.common.logging;
    requires splunk.library.javalogging;
    requires logback.classic;
    requires slf4j.api;
    requires logback.core;

    exports be.yildizgames.common.logging.logback;
}
package zest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.regex.Pattern;

public class CompareVersionNumbersTest {

    private static final Logger logger = LoggerFactory.getLogger(CompareVersionNumbersTest.class);

    @Test
    public void testSomeInputIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CompareVersionNumbers.compareVersion(null, "3.0.1");
        });
    }
}

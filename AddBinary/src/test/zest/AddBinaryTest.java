package zest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddBinaryTest {

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void test() {
        AddBinary.addBinary("1101", "0011");
    }
}
package zest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseIntegerTest {

    @Test
    public void test0Case() {
        int test = 0;
        test = ReverseInteger.reverse(test);
        assertThat(test).isEqualTo(0);
    }

    @Test
    public void testNegativeCase() {
        int test = -1;
        test = ReverseInteger.reverse(test);
        assertThat(test).isEqualTo(-1);
    }

    @Test
    public void test12Case() {
        int test = 12;
        test = ReverseInteger.reverse(test);
        assertThat(test).isEqualTo(21);
    }

    @Test
    public void test123Case() {
        int test = 123;
        test = ReverseInteger.reverse(test);
        assertThat(test).isEqualTo(321);
    }

    @Test
    public void testLargeCase() {
        int test = 2143847412;
        test = ReverseInteger.reverse(test);
        assertThat(test).isEqualTo(2147483412);
    }

    @Test
    public void testOverflowCase() {
        int test = 2147483646;
        test = ReverseInteger.reverse(test);
        assertThat(test).isEqualTo(0);
    }

}
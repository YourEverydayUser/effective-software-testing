package zest;

import java.util.regex.Pattern;

public class AddBinary {

    private static final Pattern VALID_BINARY_NUMBER =
            Pattern.compile("0$|^1[01]{0,9999}");

    /**
     * Adds two binary strings and returns the result as a binary string.
     *
     * @param a first binary string
     * @param b second binary string
     * @return binary sum of a and b
     * @throws IllegalArgumentException if a or b is null
     */
    public static String addBinary(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Input strings cannot be null");
        }

        if (!VALID_BINARY_NUMBER.matcher(a).matches() || !VALID_BINARY_NUMBER.matcher(b).matches()) {
            throw new IllegalArgumentException("Input numbers are not valid. They should match the following " +
                    "pattern: 0$|^1[0|1]{1,10000}");
        }

        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {

            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1) result.append('1');
        return result.reverse().toString();
    }

}
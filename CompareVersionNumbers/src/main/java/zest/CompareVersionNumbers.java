package zest;

import java.util.regex.Pattern;

public class CompareVersionNumbers {

    private static final Pattern VALID_VERSION_NUMBER =
            Pattern.compile("^\\d+(\\.\\d+){0,500}$");

    /**
     * Compares two version strings.
     *
     * @param version1 first version string
     * @param version2 second version string
     * @return -1 if version1 < version2,
     *          1 if version1 > version2,
     *          0 if equal
     * @throws IllegalArgumentException if either input is null
     */
    public static int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            throw new IllegalArgumentException("Version strings cannot be null");
        }

        if (!VALID_VERSION_NUMBER.matcher(version1).matches() ||
            !VALID_VERSION_NUMBER.matcher(version2).matches())
        {
            throw new IllegalArgumentException(String.format("One of the two version numbers 1: %s, 2: %s " +
                    "does not match the required form given by the pattern: ^\\d+(\\.\\d+)*$", version1, version2));
        }

        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");

        if (v1Parts.length > v2Parts.length) {
            return 1;
        } else if (v1Parts.length < v2Parts.length) {
            return -1;
        }

        for (int i = v1Parts.length - 1; i >= 0; i--) {
            int num1 = parseRevision(v1Parts[i]);
            int num2 = parseRevision(v2Parts[i]);

            if (num1 > num2) {
                return -1;
            } else if (num1 < num2) {
                return 1;
            }
        }

        return 0;
    }

    private static int parseRevision(String revision) {
        try {
            return Integer.parseInt(revision);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format("Revision is not a valid 32-bit signed integer: %s", revision), e);
        }
    }
}
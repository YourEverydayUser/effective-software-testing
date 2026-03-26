package zest;

import java.util.regex.Pattern;

public class ExcelSheetColumnNumber {

    private static final Pattern VALID_COLUMN_NAME =
            Pattern.compile("^[A-Z]+$");

    /**
     * Converts an Excel column title (e.g., "A", "AB", "ZY")
     * into its corresponding column number.
     *
     * @param columnTitle the Excel column title
     * @return corresponding column number
     * @throws IllegalArgumentException if columnTitle is null, empty, or invalid
     */
    public static int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.isEmpty()) {
            throw new IllegalArgumentException("Column title cannot be null or empty");
        }

        if (!VALID_COLUMN_NAME.matcher(columnTitle).matches()) {
            throw new IllegalArgumentException("Invalid column title format");
        }

        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            result = result * 26 + (c - 'A' + 1);
        }

        return result;
    }

}
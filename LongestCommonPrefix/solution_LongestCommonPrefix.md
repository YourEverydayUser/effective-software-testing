## Specification-based Testing

I identified the following partitions for testing:
- **Normal cases with prefix**: Strings with common prefix of varying lengths, all strings identical, entire first word is the prefix
- **No prefix cases**: Strings starting with different characters, resulting in empty string
- **Array size partitions**: Empty array, single string, multiple strings
- **Edge cases**: One string is empty (forces empty prefix), single character prefix, first string is longest
- **Error cases**: Null array (should throw IllegalArgumentException)

The boundaries I focused on were empty array, single string array, and the transition from having a prefix to having no prefix.

## Test Cases

I started with the most basic test case where there is a common prefix among strings like `["brother", "bread", "breast"]` which should return `"br"`. Then I tested the case where all strings are identical, and when the entire first word is the prefix.

After that I tested edge cases: no common prefix at all `["brother", "sister", "father"]`, an empty array `[]`, a single string in the array, and when one string is empty. I also tested single character prefix and when the first string is the longest and needs to be shrunk down to match shorter strings.

Finally I added the null array test to ensure it throws an `IllegalArgumentException` as specified in the documentation.

## Structural Testing

I ran the coverage check and got 83% line coverage (10/12 lines). I tried to figure out which lines were missing by checking the PIT HTML report. I found that line 27 (`return "";` inside the `isEmpty()` check) was not covered. This line appears to be unreachable code because an empty string is technically a prefix of any string, so the `startsWith()` check would pass before we ever reach the `isEmpty()` condition. I tried adding a test with completely different single characters `["a", "b"]` but it still didn't cover that line.

## Mutation Testing

I ran PIT mutation tests and achieved 100% mutation coverage (8/8 mutants killed). The mutations included changing conditional boundaries, negating conditionals, and replacing integer operations. All were successfully killed by my test suite, which means all my assertions are strong and properly test the code.

## Issues

The only issue was trying to reach 100% line coverage. After investigation, the missing line appears to be unreachable due to how Java's `startsWith()` method works with empty strings. Since I have 100% mutation coverage and the uncovered line seems to be defensive/unreachable code, I decided 83% line coverage is acceptable. LLM was used to help identify edge test cases and structure the solution report

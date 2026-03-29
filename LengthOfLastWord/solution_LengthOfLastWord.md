## Specification-based Testing

I identified the following partitions for testing:
- **Normal cases**: Single word, multiple words with spaces between them
- **Edge cases with spaces**: Trailing spaces at the end, leading spaces at the beginning, multiple spaces between words
- **Boundary cases**: Empty string (returns 0), single character word, string with only spaces
- **Error cases**: Null input (should throw IllegalArgumentException)

The boundaries I tested were the minimum (empty string, single char) and the behavior with different space configurations since the method needs to skip trailing spaces.

## Test Cases

I started with the most basic test case, a single word without any spaces. Then I tested multiple words. Then I checked whether a lot of spaces in the end of the word, in the beginning of the word or in between words will affect it. After that I checked for an empty string, a single char and only spaces. And at the end I also checked for null input.

## Structural Testing

I used the built-in coverage tool in IntelliJ and achieved 100% line coverage (11/11 lines). Both while loops in the implementation were fully covered - the first loop that skips trailing spaces (lines 22-24) and the second loop that counts the last word characters (lines 27-30). All branches and conditions were executed by my test suite.

## Mutation Testing

I ran PIT mutation tests and achieved 100% mutation coverage with 6/6 mutants killed. The mutations included changing conditional boundaries, negating conditionals, and replacing integer operations. All mutants were caught by my test assertions, showing that my tests are strong enough to detect code changes.

## Issues

I had no other bugs or issues while doing this task. LLM was used to help understand how to structure tests and write the solution report
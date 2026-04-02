## Specification-based Testing

I identified the following partitions for testing:
- **Match position partitions**: Needle found at beginning, middle, or end of haystack
- **No match partition**: Needle not found in haystack at all
- **Boundary cases**: Single character matches, empty strings, needle longer than haystack
- **Error cases**: Null haystack or null needle (should throw IllegalArgumentException)

The key boundaries were when the needle appears at the very start (index 0) or very end of the haystack, and when needle length exceeds haystack length.

## Test Cases

I started with the most basic tests, whether the matching string was found in the beginning, in the middle, in the end, or was not found at all.

Then I tested the single char match case, and single char no match case. Then I tested the match at the very end of the loop.

I thought I was pretty much done with the cases and added two more tests for null cases to throw an `IllegalArgumentException`.

## Structural Testing

I checked the test coverage using the built-in JaCoCo tool in IntelliJ IDEA and found that it was only 93% covered. I missed the case where the length of the needle is longer than the length of the haystack, so I added it as well and achieved 100% test coverage. This edge case was important because it tests the early return condition in the code.

## Mutation Testing

I set up the `pom.xml` file with PIT and ran mutation tests. All mutants were killed successfully, achieving 100% mutation coverage. This confirmed that my assertions are strong enough to catch code changes and potential bugs.

## Issues

I had no other bugs or issues while doing this exercise. LLM was used to help structure the test approach and format the solution report
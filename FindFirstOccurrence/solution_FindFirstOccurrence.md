## Test Cases

I started with the most basic tests, whether the matching string was found in the beginning, in the middle, in the end, or was not found at all.

Then I tested the single char match case, and single char no match case. Then I tested the match at the very end of the loop.

I thought I was pretty much done with the cases and added two more tests for null cases to throw an `IllegalArgumentException`.

## Build & Mutation Testing

For the next step I set up the `pom.xml` file, ran all the tests successfully, and tested for the mutants — it was successful as well since I have proper assertions.

## Test Coverage

I checked the test coverage using the built-in JaCoCo tool in IntelliJ IDEA and found that it was only 93% covered. I missed the case where the length of the needle is longer than the length of the haystack, so I added it as well and achieved 100% test coverage.

## Issues

I had no other bugs or issues while doing this exercise. LLM was used only to format current md file to make it look better
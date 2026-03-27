## Test Cases

I started with the basic test where I have mixed zeros and non-zeros `[1, 0, 2, 0, 3]` which should become `[1, 2, 3, 0, 0]`. Then I tested all zeros and no zeros cases to make sure those work properly.

After that I tested zeros at the start and at the end of the array. I also added tests for single element array, empty array, and null array to make sure the exception is thrown correctly.

Finally I added a two element test `[0, 1]` to catch edge cases with small arrays.

## Mutation Tests

Since pom.xml was already configured with PIT, I ran the mutation tests and checked the results to make sure my assertions are strong enough.

## Test Coverage

I ran the coverage check and verified that all the important code paths were covered by my tests.

## Issues

When I first ran my tests, they failed! I discovered there was a bug in the implementation code on line 20. The loop was using `i < numbers.length-1` instead of `i < numbers.length`, which meant it was skipping the last element of the array. This caused tests like `singleElement` and `twoElements` to fail. After fixing the bug by removing the `-1`, all tests passed. This showed me how important testing is - my tests caught a real bug in the code! After the fix, I got 100% mutation coverage (7/7 mutants killed) and 92% line coverage. LLM was used only to format current md file to make it look better

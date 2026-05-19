# Solution

## Contracts

**Preconditions:**
- `nums` must not be null
- `nums.length` must be in [1, 2000]
- Each element must be in [-10^6, 10^6]

**Postconditions:**
- Result is always >= 1

**Invariants:**
- `lengths[i]` always represents the length of the longest increasing subsequence ending at index i
- `counts[i]` always represents the number of such subsequences

## Specification-based Testing

I identified the following partitions for testing:
- **Normal cases**: Arrays with distinct increasing elements `[1,3,5,4,7]`, all identical elements `[2,2,2,2,2]`
- **Single element**: A single element array, which should always return 1
- **Monotone arrays**: Fully increasing `[1,2,3,4,5]` (one LIS), fully decreasing `[5,4,3,2,1]` (five LIS of length 1)
- **Error cases**: Null array, empty array, elements outside the valid range

The boundaries I focused on were the null/empty input, single element arrays, and the transition between all-identical and strictly increasing elements

## Test Cases

I started with the two examples from the README — `[1,3,5,4,7]` expected 2 and `[2,2,2,2,2]` expected 5. These immediately caught the initialization bug (see below)

Then I added monotone cases: a fully increasing array has exactly one LIS while a fully decreasing array has as many LIS as elements since each element is its own subsequence of length 1 and I also added a single element test since that is the smallest valid input by the constraints

For contract testing I added null, empty array and an out-of-range element all of which should throw `IllegalArgumentException`

## Structural Testing

After writing the initial tests I ran built-in tool by IntelliJ IDEA and got 100% line coverage. The contract checks and the main DP loop are all exercised by the test cases above

## Property-Based Testing

I used jqwik with two properties:

- `resultAlwaysPositive`: for any valid array, the result should be at least 1. I used `Assume.that()` to filter out inputs that violate the preconditions since `@IntRange` does not apply cleanly to primitive arrays in jqwik
- `singleElementAlwaysOne`: for any single valid integer, the result should be exactly 1

Both properties ran 1000 tries and passed

## Bug Found

`counts` array was initialized to `0` instead of `1`. Each element is its own subsequence of length 1, so the count should start at 1. With the original initialization, every element starts with a count of zero and the inner loop only updates counts when `nums[i] > nums[j]` — so for arrays like `[2,2,2,2,2]` where no element is strictly greater than another, counts stay at zero and the method always returns 0

**Fix:** `Arrays.fill(counts, 1);`

## AI Usage

AI was used as a tutor to work through the logic of the DP algorithm and identify the initialization bug and structurizing this md file. All test cases and contract decisions are my own
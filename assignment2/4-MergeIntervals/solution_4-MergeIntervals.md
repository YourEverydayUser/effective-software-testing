# Solution

## Bug Found

The method called `intervals[0]` before checking if the array was empty. An empty
array throws `ArrayIndexOutOfBoundsException` immediately. The README says the
valid range is [0, 10^4], so empty is explicitly allowed

Fix: `if (intervals.length == 0) return new int[0][];` before the sort

## Contracts

Preconditions:
- `intervals` is not null
- `intervals.length` is in [0, 10^4]
- each interval has exactly 2 elements and `start <= end`

Postcondition: result length is <= input length (merging can only reduce or maintain count)

Invariants: the result intervals are sorted by start and non-overlapping

## Test Cases

I started with the two README examples. Then I added an empty array, which crashed
immediately  that's how I found the bug. After the fix I added a single interval
(should come back unchanged), no overlap at all, complete overlap (all merge into
one), and unsorted input to verify the sort step actually runs

For contract tests: null input, a malformed interval with 3 elements, `start > end`,
and an array of 10001 intervals

## Structural Testing

I used IntelliJ's built-in coverage runner. After adding the empty array test the
coverage hit 100% — that was the one branch the original code never reached.

## Property-Based Testing

First attempt at `resultIsNeverLongerThanInput` used `Assume.that()` to filter
invalid inputs from randomly generated `int[][]`. This exhausted after 1000 tries
with 999 rejections, jqwik generates inner arrays of random length, so almost
everything got filtered before it could run

Fixed by constructing valid intervals directly from two int arrays using
`Math.min/max` to guarantee `start <= end`, which removed the need for filtering
entirely. After that both properties passed cleanly

Properties:
- `resultIsNeverLongerThanInput`: merging can only reduce or maintain interval count
- `singleIntervalUnchanged`: a single valid interval should come back identical

## AI Usage

AI was used to help indetifying the edge cases and structurize the final report and make md file prettier. Test cases and contract design
are my own
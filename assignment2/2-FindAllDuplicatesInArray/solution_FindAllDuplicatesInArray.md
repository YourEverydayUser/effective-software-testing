# Initial Analysis
executed the algorithm on the three README examples and all produced the expected output.
The sign-flip trick (negate `nums[value-1]` on first visit, detect a duplicate on the
second visit) is the standard O(n) approach and I didn't find a bug in it.

# Designing Constraints
Pre-conditions: the array cannot be null, its length must be in [1, 100000], and every
element must be in [1, length]. The problem also says each value appears once or twice —
we don't check that explicitly since the post-condition on the result size catches it.

Post-condition: the number of duplicates returned is at most length / 2.

Invariant: the algorithm mutates its input via sign flips, so we run on a copy and
check that the caller's array is unchanged before returning.

# Designing Testcases
First the contract checks: null, wrong length, values below 1 and above n.

For the functionality:
- the three examples from the readme
- an array with no duplicates returns empty
- an array where every value is duplicated

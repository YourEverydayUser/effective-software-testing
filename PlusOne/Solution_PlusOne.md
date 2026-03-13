# Solution for the PlusOne

The documentation of the decision and steps taken for testing the PlusOne solution.


## 1. Specification-based testing
### 1. Understand the requirement, inputs, and outputs
Takes an array as input, which entries are single digit entries. Then adds 1 to the last one, if that is a 10,
the 1 gets carried to the entry before. Can add to the length of the array.

### 2. Explore the program
### 3. Judiciously explore the possible inputs and outputs, and identify the partitions.
Inputs: Array of integers, length of array: 1-100, entries: integers 0-9
Outputs: Array of integers, length 1-101, entries: integers 0-9

### 4. Identify the boundaries
Length of array: Can't be 0 or 101
Entry of array: Can't be negative or be 10 or bigger

### 5. Devise test cases based on the partitions and boundaries
- Null, empty array, array of length 1, array of length 100, array of length 101
- Leading entry with a 9, last entry a 9, entry with 1, entry with 10, leading 0s
- Array of length 100 with all entries a 9

### 6. Automate the test cases
1. Bug: If all entries are 9, then the output is a digit too short, a 0 is missing. Found by test9Case, input: 9,
expected output: 10, actual output: 1. Fixed by changing line 27 'int[] result = new int[digits.length];' 
to 'int[] result = new int[digits.length + 1];'

### 7. Augment the test suite with creativity and experience
Testing for leading zeroes reveals that the program also works for arrays with leading zeroes in returning [0,0,1,0] for [0,0,0,9].
Here one would need more information if this is wanted or if an exception should be thrown, since the Requirements are unclear for this case.

## 2. Structural testing

## 3. Mutation testing
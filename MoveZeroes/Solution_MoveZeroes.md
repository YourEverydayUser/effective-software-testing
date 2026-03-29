# Solution for Move Zeroes
The documentation of the decision and steps taken for testing the Move Zeroes solution.

## 1. Specification-based testing
### 1. Understand the requirement, inputs, and outputs
The program takes an array of integers. The task is to rearrange the elements of the array in such a way, that all zeroes are placed at the end of the array, 
whilst the relative order of the rest of the array isn't changed. This task must be done in-place

### 2. Explore the program
The program takes an array of integers. It goes through the array and checks if the entry is a zero. If it is, it skips it and goes to the next entry.
If it is not, it overwrites the first entry that is a 0 or the entry itself, it also counts this. If it has done this for all entries,
it adds as many zeroes to the end, as entries were skipped because they were 0.

### 3. Judiciously explore the possible inputs and outputs, and identify the partitions
Input: An array of integers
Output: The same array, as the operation is done in-place

### 4. Identify the boundaries
Empty array
For an entry the min and max integers, also having zeroes

### 5. Devise test cases based on the partitions and boundaries
Null, array of length 1, array with only 0s as entries, array with no zeroes, array with negative numbers,
already sorted array, unsorted array

### 6. Automate the test cases
Running tests it shows that all tests that contain at least one entry, that isn't a 0 fail.
Looking at the results, we see that always one entry too much is replaced with a 0.
Comparing with the code, we see at line 20, that the last position isn't checked for a 0.
As this isn't bad, if there is a 0 it wouldn't be needed to moved to the back, it also doesn't increase the insertPosition count.
This leads to a 0 more being added. Replacing the 'i < numbers.length-1' with 'i < numbers.length' solved the problem.

### 7. Augment the test suite with creativity and experience
Created another test, with some larger positive and negative number and the min and max integer values, this also passed.
Created a test with a very long array (1000000 entries), this test also passed.

## 2. Structural testing
Running code coverage shows that all relevant lines and branches are covered.

## 3. Mutation testing
Running the PITest shows that out of 7 generated mutations all 7 were killed.
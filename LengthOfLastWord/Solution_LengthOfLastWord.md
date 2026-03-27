# Solution for the Length of Last Word

The documentation of the decision and steps taken for testing the Length of Last Word solution.

## 1. Specification-based testing
### 1. Understand the requirement, inputs, and outputs
The program takes a string as an input, which consists of letters and spaces. It returns the number of letters in the string that are after the last letter.

### 2. Explore the program
The program takes a string, skips trailing spaces at the end and then counts the number of letters before a space appears or the beginning of the string is reached.

### 3. Judiciously explore the possible inputs and outputs, and identify the partitions
Input: String containing English letters and spaces, length: 1 to 10^4
Output: Integer, max 10^4

### 4. Identify the boundaries
Word of length 1, Word of length 10000

### 5. Devise test cases based on the partitions and boundaries
Null, empty, one letter, Spaces at the beginning and end, multiple words

### 6. Automate the test cases
The program didn't test for the empty string. Changed the test and exception message at lines 14 and 15.
All other tests passed.

### 7. Augment the test suite with creativity and experience
Added tests for edge cases with leading, trailing spaces and multiple consecutive spaces in the middle of the string, they passed.

## 2. Structural testing
Line 22 was not fully covered, adding a test with only spaces changed that.
Such a string wouldn't be allowed according to the constraints, however it returned 0.

## 3. Mutation testing
Running the PITest shows out of 11 mutations 10 were killed.
The one mutation that survived changed the boundary condition on line 22
This while loop only changes i and not length, so any strings that reach i==0 are only spaces
In that case the second while loop isn't executed and length, which is the return value isn't changed

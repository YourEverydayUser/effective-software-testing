# Solution for the Find First Occurrence

The documentation of the decision and steps taken for testing the Find First Occurrence solution.

## 1. Specification-based testing
### 1. Understand the requirement, inputs, and outputs
The program takes two strings consisting of lowercase English letters. It then checks if the second string is part of the first.
If so it returns the index of the position of the first letter in the first string. If the second string is not part of the first string the program returns -1

### 2. Explore the program
The example in the README.md is inaccurate, as the program takes both the needle and the haystack as input, there it says the needle is the output.
The output is the index of the position of the needle string in the haystack string.

### 3. Judiciously explore the possible inputs and outputs, and identify the partitions.
Input: Two Strings:
First String: lower case letters, length: 1 to 10^4
Second String: lower case letters, length: 1 to 10^4
Output: Natural Number, 0 to (10^4)-1 or -1

### 4. Identify the boundaries
The boundaries are the length of the strings, i.e. strings of length 1 and of length 10^4


### 5. Devise test cases based on the partitions and boundaries
Both null, both empty, one null, one empty, one string length one, one string length 10^4, both length 10^4

### 6. Automate the test cases
Running tests shows that an exception is thrown in case of a null string but not in case of an empty string.
The exceptions at lines 15-16 were changed accordingly.

### 7. Augment the test suite with creativity and experience
Test with multiple occurrences added, returned the index of the first occurrence.

## 2. Structural testing
Running the code coverage tools shows that all lines and branches are already covered. 

## 3. Mutation testing
All mutants were killed.

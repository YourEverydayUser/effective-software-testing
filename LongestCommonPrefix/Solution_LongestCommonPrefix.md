# Solution for Longest Common Prefix
The documentation of the decision and steps taken for testing the Longest Common Prefix solution.

## 1. Specification-based testing
### 1. Understand the requirement, inputs, and outputs
The program takes an array of strings as an input. It then checks for the longest sequence that all strings in the array have in common at the beginning of the string.

### 2. Explore the program


### 3. Judiciously explore the possible inputs and outputs, and identify the partitions
Input: An array of length 1 to 200, each entry a string of length 0 to 200.
Output: A string of length 0 to 200

### 4. Identify the boundaries


### 5. Devise test cases based on the partitions and boundaries
Null array, empty array, array with 1 entry, array with 200 entry, entry of length 1, entry of length 200
Common prefix of length 0, length 1, length 200

### 6. Automate the test cases
An empty array returns an empty string, check if this is wanted.
Else everything passes.

### 7. Augment the test suite with creativity and experience

## 2. Structural testing
The code coverage shows that the if statement on line 26 never is true.
For it to be true, the prefix has to be shortend to "", in that case is would be at the beginning of the word, and the while loop breaks.
Thus the if statement and its content can be deleted. (I added "//")

## 3. Mutation testing
Running the PITest showed that all 7 generated Mutants were killed.

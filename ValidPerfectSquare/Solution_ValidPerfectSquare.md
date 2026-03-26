# Solution for the Valid Perfect Square

The documentation of the decision and steps taken for testing the Valid Perfect Square solution.

## 1. Specification-based testing
### 1. Understand the requirement, inputs, and outputs
Takes a positive integer and checks whether the square root of that number is a natural number.
Therefor input needs to be a positive integer, the output is true (for a perfect square) or false (every other number)

### 2. Explore the program
The program takes a number and searches for a natural square root. If the square root is found it returns 'true', if there is no natural square root it returns 'false'


### 3. Judiciously explore the possible inputs and outputs, and identify the partitions.
Input: A positive integer between 1 and 2^32-1
Outputs: True, False

### 4. Identify the boundaries
Lower boundary: 0, Upper boundary: int_max

### 5. Devise test cases based on the partitions and boundaries
Negative, 0, 1, 2, 4, the max integer

### 6. Automate the test cases
All tests pass

### 7. Augment the test suite with creativity and experience
Tests with larger squares fail, looking closer there is a bug in the while-statement on line 24.
There is a < but there should be a <=
After replacing 'while (left < right)' with 'while (left <= right)' the tests all pass.

## 2. Structural testing

Running the program with code coverage gave a full coverage.

## 3. Mutation testing
Out of 17 generated mutations, 16 were killed.
The mutation that survided, changed the conditional boundary in line 30 from a < to <=.
As it is a 'else if' and the 'if' condition before checks for this exact equality, this makes no difference.

# Solution for the Sort Colors

The documentation of the decisions and steps taken for testing the Compare Version Numbers solution.

## 1. Specification-based testing
### 1. Understand the requirement, inputs, and outputs
The program should compare two version strings according to the Semantic Versioning 
convention. Starting from left to right, the program should compare the numbers
of the two strings and if the number of version a is bigger, version a is considered
greater.

### 2. Explore the program

### 3. Judiciously explore the possible inputs and outputs, and identify the partitions.
Inputs: two strings with length between 1 and 500. They should only contain digits and
dots. Additionally, we have to check that the semantics of the versions string is valid
and each revision value fits within a 32-bit signed integer.

Output: an integer 

### 4. Identify the boundaries
Length of input array: min 1, max 10^5
Entries of input array: integer, min 0, max 10^4

### 5. Devise test cases based on the partitions and boundaries
Null, Empty array, Array with 1 element, Array larger than allowed
negative entries, values too big, ascending values array, descending values array, 
test with two maxima

### 6. Automate the test cases
### 7. Augment the test suite with creativity and experience

## 2. Structural testing

## 3. Mutation testing
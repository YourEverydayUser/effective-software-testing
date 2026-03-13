# Solution for the Sort Colors

The documentation of the decisions and steps taken for testing the Sort Colors solution.

## 1. Specification-based testing
### 1. Understand the requirement, inputs, and outputs
The program takes an array of integers as an input. The integers represent colors and should be either 0, 1, or 2.
The program sorts them by going through the array, starting at position 0. The output should be an integer array,
with first zeroes then ones and then twos, if those were in the original array.
The requirements state that the input array length should be at least 1 and max 300.
The program should not create an additional array for sorting and sort in-place.
The program must be able to handle edge cases such as edge cases.

### 2. Explore the program

### 3. Judiciously explore the possible inputs and outputs, and identify the partitions.
Inputs: array containing only 0, 1, and 2
Outputs: No output, the program sorts the array in-place

### 4. Identify the boundaries
Length of input array: min 1, max 300
Entries of input array: integer, min 0, max 2

### 5. Devise test cases based on the partitions and boundaries
Null, Empty array, Array of length 1, Array of length 2
Entries all 0, Entries already sorted ({0,1,2}), Entry a 3

### 6. Automate the test cases
### 7. Augment the test suite with creativity and experience

## 2. Structural testing

## 3. Mutation testing
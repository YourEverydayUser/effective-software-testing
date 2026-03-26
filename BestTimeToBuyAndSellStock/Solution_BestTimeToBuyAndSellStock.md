# Solution for the Best time to buy and sell stock exercise

## 1. Specification-based testing
### 1. Understand the requirement, inputs, and outputs
The program takes an array of integers as an input. The integers represent the price of some arbitrary stock 
over a period of time which is given by the length of the array, and each timestep representing
one day. The stock values cannot be negative or larger than 10^4. The program should calculate 
the highest possible profit, by buying it at day x and selling it at day x + y. It's important
to note that the program should not get stuck in local maxima. 

### 2. Explore the program

### 3. Judiciously explore the possible inputs and outputs, and identify the partitions.
Inputs: array containing values between 0 and 10^4

### 4. Identify the boundaries
Length of input array: min 1, max 10^5
Entries of input array: integer, min 0, max 10^4

### 5. Devise test cases based on the partitions and boundaries
Null, Empty array, Array with 1 element, Array larger than allowed
negative entries, values too big, ascending values array, descending values array, 
test with two maxima
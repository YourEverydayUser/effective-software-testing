# Solution for the Reverse Integer

The documentation of the decision and steps taken for testing the Reverse Integer solution.


## 1. Specification-based testing
### 1. Understand the requirement, inputs, and outputs
Takes an integer number and reverses the order of the digits of that number

### 2. Explore the program
It creates a new integer. It then gets the last digit of the input number via modulo10 operation.
It adds the last digit to the new integer and multiplies the new by 10 before adding the new last digit.

### 3. Judiciously explore the possible inputs and outputs, and identify the partitions.
Input: A signed 32-bit integer x

### 4. Identify the boundaries
Input: max 32-bit
Output: max 32-bit, if overflows then it outputs a 0

### 5. Devise test cases based on the partitions and boundaries
Null, 0, -1, 123, 2'143'847'412, 2’147’483’646

### 6. Automate the test cases
No Bugs found with the tests mentioned in the previous step.

### 7. Augment the test suite with creativity and experience
Added a test with an integer ending with 0, ie. 10000, test passed and returned 1.


## 2. Structural testing
Running the test with code coverage shows that 90% of lines are covered but only 50% of Branches.
Looking at the conditions, for those condition to be fulfilled the reversed number would need to be larger than 2147483647.
If we reverse that number we get 7463847412 which is too large for an integer so it is an invalid input. 
So the conditions cannot be met. The same logic applies to the underflow test.
As those checks ('digit > 7' and 'digit < -8' as well as the equals max/min) on line 21 resp line 27 are useless, they were removed.


## 3. Mutation testing
Out of 10 generated mutations 8 were killed. It shows that a changed boundary at line 21 and 27 didn't catch.
There it tests for under- and overflow. For the changed boundary (from < to <=) to catch it would need to be 7463847421,
like in the test before this cannot be met, as the input number cannot be that large. So those mutants not being killed is ok.

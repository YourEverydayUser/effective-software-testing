# Initial Analysis
There is a bug on line 7 where we set the first entry to 0 without 
considering the actual cost coming from the cost array.

# Designing Constraints
We have a pre-condition where the array should have a min length of 2
and a max length of 1000. So we add a check for that. 
For the second constraint we need to check the value of each element
during iteration. 
Since each element is a natural number n >= 0, we have an 
implicit post-condition that the total cost c also has to 
be >= 0, but since we already check each element in the
array we don't have to check that.

# Designing Testcases
First we can add various test-cases to confirm the different constraint 
checks we added work as expected. 

For the functionality of the method:

First off just testing the 2 examples from the readme.
- expensive last step should be skipped
- array with constant cost always takes stepsize 2 to minimize cost

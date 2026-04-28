# Knapsack

This section explains the concept, its importance, and when to use it.

Knapsack

KNAPSACK PROBLEM

Its is a problem in combinatorial optimization

The algorithmic approach and key insights for solving this problem.

If we can take fractions of the given items, then the greedy approach can be used

In this case we are not able to take fractions: we have to decide whether to take an item or not

Solves larger problem by relating it to overlapping subproblems and then solves the subproblems

We have to define subproblems: we have n items so we have to make n decisions whether to take the item with given index or not

S[i][w] = Math.max(  S[i-1][w]  ;  vi + S[i-1][w-wi]  )

**Running time of Knapsack: O(n*W)**

EXAMPLE

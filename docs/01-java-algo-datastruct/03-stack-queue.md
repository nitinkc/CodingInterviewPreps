# 3.1.Stack Queue

This section explains the concept, its importance, and when to use it.

3.1.Stack Queue

**Providing oversized data input to a program that does not check the length of input -> such a program may copy the data in its entirety to a location on the stack, and in so doing it may change the return addresses for procedures that have called it. An attacker can experiment to find a specific type of data that can be provided to such a program such that the return address of the current procedure is reset to point to an area within the stack itself (and within the data provided by the attacker), which in turn contains instructions that carry out unauthorized operations**

The algorithmic approach and key insights for solving this problem.

Usually: we can avoid using stacks with recursive algorithms

STACK

It is an abstract data type (interface)

In stack-oriented programming languages

Most important application of stacks: stack memory

Every time a function declares a new variable it is pushed onto the stack

The heap is a region of memory that is not managed automatically for you

There are several situations when recursive methods are quite handy

Depth-first search

Factorial: with recursion

Factorial: factorial(4)

QUEUE

When a resource is shared with several consumers ( threads ): we store them in a queue

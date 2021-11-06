<p>i takes values 2, 2<sup>k</sup>, (2<sup>k</sup>)<sup>k</sup> = 2<sup>k<sup>2</sup></sup>, (2<sup>k<sup>2</sup></sup>)<sup>k</sup> = 2<sup>k<sup>3</sup></sup>, …, 2<sup>k</sup><sup><sup>log<sub>k</sub>(log(n))</sup></sup>. 

The last term must be less than or equal to n, and we have 2<sup>k</sup><sup><sup>log<sub>k</sub>(log(n))</sup></sup> = 2<sup>log(n)</sup> = n, which completely agrees with the value of our last term. 

So there are in total log<sub>k</sub>(log(n)) many iterations, and each iteration takes a constant amount of time to run, therefore the total time complexity is O(log(log(n))).</p>
# Topological Sort

**Category:** Famous Algorithms

```
## Problem Statement

Topological Sort
You're given a list of arbitrary jobs that need to be completed; these jobs are represented by distinct integers. You're also given a list of dependencies. A dependency is represented as a pair of
jobs where the rst job is a prerequisite of the second one. In other words, the second job depends on the rst one; it can only be completed once the rst job is completed.
Write a function that takes in a list of jobs and a list of dependencies and returns a list containing a valid order in which the given jobs can be completed. If no such order exists, the function
should return an empty array.
Sample Input
jobs = [1, 2, 3, 4]
deps = [[1, 2], [1, 3], [3, 2], [4, 2], [4, 3]]
Sample Output
[1, 4, 3, 2] or [4, 1, 3, 2]
Hints
Hint 1
Try representing the jobs and dependencies as a graph, where each vertex is a job and each edge is a dependency. How can you traverse this graph to topologically sort the list of jobs?
Hint 2
One approach to solving this problem is to traverse the graph mentioned in Hint #1 using Depth-rst Search. Starting at a random job, traverse its prerequisite jobs in Depth-rst Search
fashion until you reach a job with no prerequisites; such a job can safely be appended to the nal order. Once you've traversed and added all prerequisites of a job to the nal order, you
can append the job in question to the order. This approach will have to track whether nodes have been traversed already, whether they're in the process of being traversed (which would
indicate a cycle in the graph and therefore no valid topological order), or whether they're ready to be traversed.
Hint 3
Another approach to solving this problem is to traverse the graph mentioned in Hint #1 starting specically with jobs that have no prerequisites. Keep track of all the jobs that have no
prerequisites, traverse them one by one, and append them to the nal order. For all of these jobs, remove their dependencies from the graph and update the number of prerequisites
for each of these dependencies accordingly (these dependencies should now have one prerequisite less since one of their prerequisite job has just been added to the nal order). As you
update the number of prerequisites for these other jobs, keep track of the ones that no longer have prerequisites and that are ready to be traversed. You'll eventually go through all of
the jobs if there are no cycles in the graph. If there is a cycle in the graph, there will still be jobs with prerequisites and you'll know that there is no valid topological order. This approach
will involve keeping track of the number of prerequisites per job as well as all the actual dependencies of each job.
Optimal Space & Time Complexity
O(j + d) time | O(j + d) space - where j is the number of jobs and d is the number of dependencies

```
---

## Approach & Solution

### Solution 1

```
Solution 1 Solution 2
orderedJobs.add(node.job);
removeDeps(node, nodesWithNoPrereqs);
}
boolean graphHasEdges = false;
for (JobNode node : graph.nodes) {
if (node.numOfPrereqs > 0) {
graphHasEdges = true;
}
}
return graphHasEdges ? new ArrayList<Integer>() : orderedJobs;
}
public static void removeDeps(JobNode node, List<JobNode> nodesWithNoPrereqs) {
while (node.deps.size() > 0) {
JobNode dep = node.deps.get(node.deps.size() - 1);
node.deps.remove(node.deps.size() - 1);
dep.numOfPrereqs--;
if (dep.numOfPrereqs == 0) nodesWithNoPrereqs.add(dep);
}
}
static class JobGraph {
public List<JobNode> nodes;
public Map<Integer, JobNode> graph;
public JobGraph(List<Integer> jobs) {
nodes = new ArrayList<JobNode>();
graph = new HashMap<Integer, JobNode>();
for (Integer job : jobs) {
addNode(job);
}
}
public void addDep(Integer job, Integer dep) {
JobNode jobNode = getNode(job);
JobNode depNode = getNode(dep);
jobNode.deps.add(depNode);
depNode.numOfPrereqs++;
}
public void addNode(Integer job) {
graph.put(job, new JobNode(job));
nodes.add(graph.get(job));
}
public JobNode getNode(Integer job) {
if (!graph.containsKey(job)) addNode(job);
return graph.get(job);
}
}
static class JobNode {
public Integer job;
public List<JobNode> deps;
public Integer numOfPrereqs;
public JobNode(Integer job) {
this.job = job;
deps = new ArrayList<JobNode>();
numOfPrereqs = 0;
}
}
}

### Solution 2

```
Solution 1 Solution 2
2
3 import java.util.*;
4
5 class Program {
6 // O(j + d) time | O(j + d) space
7 public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
8 JobGraph jobGraph = createJobGraph(jobs, deps);
9 return getOrderedJobs(jobGraph);
10 }
11
12 public static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
13 JobGraph graph = new JobGraph(jobs);
14 for (Integer[] dep : deps) {
15 graph.addDep(dep[0], dep[1]);
16 }
17 return graph;
18 }
19
20 public static List<Integer> getOrderedJobs(JobGraph graph) {
21 List<Integer> orderedJobs = new ArrayList<Integer>();
22 List<JobNode> nodesWithNoPrereqs = new ArrayList<JobNode>();
23 for (JobNode node : graph.nodes) {
24 if (node.numOfPrereqs == 0) {
25 nodesWithNoPrereqs.add(node);
26 }
27 }
28 while (nodesWithNoPrereqs.size() > 0) {
29 JobNode node = nodesWithNoPrereqs.get(nodesWithNoPrereqs.size() - 1);
30 nodesWithNoPrereqs.remove(nodesWithNoPrereqs.size() - 1);
31 orderedJobs.add(node.job);
32 removeDeps(node, nodesWithNoPrereqs);
33 }
34 boolean graphHasEdges = false;
35 for (JobNode node : graph.nodes) {
36 if (node.numOfPrereqs > 0) {
37 graphHasEdges = true;
38 }
39 }
40 return graphHasEdges ? new ArrayList<Integer>() : orderedJobs;
41 }
42
43 public static void removeDeps(JobNode node, List<JobNode> nodesWithNoPrereqs) {
44 while (node.deps.size() > 0) {
45 JobNode dep = node.deps.get(node.deps.size() - 1);
46 node.deps.remove(node.deps.size() - 1);
47 dep.numOfPrereqs--;
48 if (dep.numOfPrereqs == 0) nodesWithNoPrereqs.add(dep);
49 }
50 }
51
52 static class JobGraph {
53 public List<JobNode> nodes;
54 public Map<Integer, JobNode> graph;
55
56 public JobGraph(List<Integer> jobs) {
57 nodes = new ArrayList<JobNode>();
58 graph = new HashMap<Integer, JobNode>();
59 for (Integer job : jobs) {
60 addNode(job);
61 }
62 }
63
64 public void addDep(Integer job, Integer dep) {
65 JobNode jobNode = getNode(job);
66 JobNode depNode = getNode(dep);
67 jobNode.deps.add(depNode);
68 depNode.numOfPrereqs++;
69 }
70
71 public void addNode(Integer job) {
72 graph.put(job, new JobNode(job));

### Solution 3

```
Solution 1 Solution 2
while (nodes.size() > 0) {
JobNode node = nodes.get(nodes.size() - 1);
nodes.remove(nodes.size() - 1);
boolean containsCycle = depthFirstTraverse(node, orderedJobs);
if (containsCycle) return new ArrayList<Integer>();
}
return orderedJobs;
}
public static boolean depthFirstTraverse(JobNode node, List<Integer> orderedJobs) {
if (node.visited) return false;
if (node.visiting) return true;
node.visiting = true;
for (JobNode prereqNode : node.prereqs) {
boolean containsCycle = depthFirstTraverse(prereqNode, orderedJobs);
if (containsCycle) return true;
}
node.visited = true;
node.visiting = false;
orderedJobs.add(node.job);
return false;
}
static class JobGraph {
public List<JobNode> nodes;
public Map<Integer, JobNode> graph;
public JobGraph(List<Integer> jobs) {
nodes = new ArrayList<JobNode>();
graph = new HashMap<Integer, JobNode>();
for (Integer job : jobs) {
addNode(job);
}
}
public void addPrereq(Integer job, Integer prereq) {
JobNode jobNode = getNode(job);
JobNode prereqNode = getNode(prereq);
jobNode.prereqs.add(prereqNode);
}
public void addNode(Integer job) {
graph.put(job, new JobNode(job));
nodes.add(graph.get(job));
}
public JobNode getNode(Integer job) {
if (!graph.containsKey(job)) addNode(job);
return graph.get(job);
}
}
static class JobNode {
public Integer job;
public List<JobNode> prereqs;
public boolean visited;
public boolean visiting;
public JobNode(Integer job) {
this.job = job;
prereqs = new ArrayList<JobNode>();
visited = false;
visiting = false;
}
}
}

### Solution 4

```
Solution 1 Solution 2
2
3 import java.util.*;
4
5 class Program {
6 // O(j + d) time | O(j + d) space
7 public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
8 JobGraph jobGraph = createJobGraph(jobs, deps);
9 return getOrderedJobs(jobGraph);
10 }
11
12 public static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
13 JobGraph graph = new JobGraph(jobs);
14 for (Integer[] dep : deps) {
15 graph.addPrereq(dep[1], dep[0]);
16 }
17 return graph;
18 }
19
20 public static List<Integer> getOrderedJobs(JobGraph graph) {
21 List<Integer> orderedJobs = new ArrayList<Integer>();
22 List<JobNode> nodes = new ArrayList<JobNode>(graph.nodes);
23 while (nodes.size() > 0) {
24 JobNode node = nodes.get(nodes.size() - 1);
25 nodes.remove(nodes.size() - 1);
26 boolean containsCycle = depthFirstTraverse(node, orderedJobs);
27 if (containsCycle) return new ArrayList<Integer>();
28 }
29 return orderedJobs;
30 }
31
32 public static boolean depthFirstTraverse(JobNode node, List<Integer> orderedJobs) {
33 if (node.visited) return false;
34 if (node.visiting) return true;
35 node.visiting = true;
36 for (JobNode prereqNode : node.prereqs) {
37 boolean containsCycle = depthFirstTraverse(prereqNode, orderedJobs);
38 if (containsCycle) return true;
39 }
40 node.visited = true;
41 node.visiting = false;
42 orderedJobs.add(node.job);
43 return false;
44 }
45
46 static class JobGraph {
47 public List<JobNode> nodes;
48 public Map<Integer, JobNode> graph;
49
50 public JobGraph(List<Integer> jobs) {
51 nodes = new ArrayList<JobNode>();
52 graph = new HashMap<Integer, JobNode>();
53 for (Integer job : jobs) {
54 addNode(job);
55 }
56 }

```
---

## Test Cases

```
Test Case 1
{"jobs": [1, 2, 3, 4], "deps": [[1, 2], [1, 3], [3, 2], [4, 2], [4, 3]]}
Test Case 2
{
  "jobs": [1, 2, 3, 4, 5, 6, 7, 8],
  "deps": [
    [3, 1],
    [8, 1],
    [8, 7],
    [5, 7],
    [5, 2],
    [1, 4],
    [1, 6],
    [1, 2],
    [7, 6]
  ]
}
Test Case 3
{
  "jobs": [1, 2, 3, 4, 5, 6, 7, 8],
  "deps": [
    [3, 1],
    [8, 1],
    [8, 7],
    [5, 7],
    [5, 2],
    [1, 4],
    [6, 7],
    [1, 2],
    [7, 6]
  ]
}
Test Case 4
{
  "jobs": [1, 2, 3, 4, 5, 6, 7, 8],
  "deps": [
    [3, 1],
    [8, 1],
    [8, 7],
    [5, 7],
    [5, 2],
    [1, 4],
    [1, 6],
    [1, 2],
    [7, 6],
    [4, 6],
    [6, 2],
    [2, 3]
  ]
}
Test Case 5
{
  "jobs": [1, 2, 3, 4, 5, 6, 7, 8],
  "deps": [[1, 2], [2, 3], [3, 4], [4, 5], [5, 6], [6, 7], [7, 8], [8, 1]]
}
Test Case 6
{
  "jobs": [1, 2, 3, 4, 5, 6, 7, 8, 9],
  "deps": [[1, 2], [2, 3], [3, 4], [4, 5], [5, 6], [7, 6], [7, 8], [8, 1]]
}
Test Case 7
{
  "jobs": [1, 2, 3, 4, 5, 6, 7, 8],
  "deps": [[1, 2], [3, 5], [4, 6], [3, 6], [1, 7], [7, 8], [1, 8], [2, 8]]
}
Test Case 8
{
  "jobs": [1, 2, 3, 4, 5, 6, 7, 8],
  "deps": [
    [1, 2],
    [1, 3],
    [1, 4],
    [1, 5],
    [1, 6],
    [1, 7],
    [2, 8],
    [3, 8],
    [4, 8],
    [5, 8],
    [6, 8],
    [7, 8]
  ]
}
Test Case 9
{
  "jobs": [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
  "deps": [
    [1, 2],
    [1, 3],
    [1, 4],
    [1, 5],
    [1, 6],
    [1, 7],
    [2, 8],
    [3, 8],
    [4, 8],
    [5, 8],
    [6, 8],
    [7, 8],
    [2, 3],
    [2, 4],
    [5, 4],
    [7, 6],
    [6, 2],
    [6, 3],
    [6, 5],
    [5, 9],
    [9, 8],
    [8, 0],
    [4, 0],
    [5, 0],
    [9, 0],
    [2, 0],
    [3, 9],
    [3, 10],
    [10, 11],
    [11, 12],
    [2, 12]
  ]
}
Test Case 10
{
  "jobs": [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
  "deps": [
    [1, 2],
    [1, 3],
    [1, 4],
    [1, 5],
    [1, 6],
    [1, 7],
    [2, 8],
    [3, 8],
    [4, 8],
    [5, 8],
    [6, 8],
    [7, 8],
    [2, 3],
    [2, 4],
    [5, 4],
    [7, 6],
    [6, 2],
    [6, 3],
    [6, 5],
    [5, 9],
    [9, 8],
    [8, 0],
    [4, 0],
    [5, 0],
    [9, 0],
    [2, 0],
    [3, 9],
    [3, 10],
    [10, 11],
    [11, 12],
    [12, 2]
  ]
}
Test Case 11
{"jobs": [1, 2, 3, 4, 5], "deps": []}
Test Case 12
{"jobs": [1, 2, 3, 4, 5], "deps": [[1, 4], [5, 2]]}


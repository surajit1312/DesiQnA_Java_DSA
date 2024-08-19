# Graph. :-> Data structure which consists of nodes and edges.

### Edge :-> Bond connecting any 2 nodes. 

### Undirected Edge:- Edge without direction is called an undirected edge.

### Directed Edge:- If the edge is having direction then it is called a directed edge. 

### Undirected Graph:- Graph with undirected edge is called an undirected graph. 

### Directed Graph:- Graph with directed edges is called directed graph. 

#### 2 Directed edges can create undirected edges.

x—-----y(undirected) = (x—->y directed) + (y—->x directed) 

N = number of nodes in graph; 
M = number of edges; 

How do we represent a graph in C++/Java/Py ->

Matrix Representation :- 
B[i][j] = 1 

Means; directed edge is there from i->j.


#### Matrix Representation:- 

Take input of graph; then tell for each node “i” how many nodes are directly connected to it 


C++ https://ideone.com/6Xina4.
Java. https://ideone.com/oXm5kN. 
Py https://ideone.com/q4qlWs.  

Space.-> O(N x N).

#### Adjacency List Representation:- 

Array of arrays. 


Take the graph; for each node “i” how many nodes are directly connected to it 

C++ https://ideone.com/bpDBbh. 
Java. https://ideone.com/RIVq6E. 
Py https://ideone.com/36dbmJ 

Time.-> O(N).
Space.-> O(N+2*M) :-> O(N+M.)

Adjacent List ->

N and M are kind of equivalent to each other :->

1<=N,M<=100000

Matrix:-> If nodes are less and edges are way too many then use matrix; it called as dense graph. 

1<=N<=100
1<=M<=1000000

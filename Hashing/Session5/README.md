# Sum of Range with Queries (Q = [{ l, r }...])

 Find Sum of Range  [l……….r] where(l<=r) using Prefix sum. 



## Brute Force:- 

For each l and r, start our i pointer from l and i will go till r and for each i, we will update our sum by doing sum = sum + arr[i]. Finally, print this sum.


Pseudo Code:- https://ideone.com/cSDWLN

C++ - https://ideone.com/CigXOc
Java - https://ideone.com/fwz8UW
Py - https://ideone.com/kMCbSz

Time Complexity - O(N*Q) 
For each query of l and r, we will call this getSum(), so Time Complexity will be O(n*q) where, q is the size of queries array containing different l and r values.

Space Complexity - O(1)

## Optimised Approach:- 

For given array, construct a prefix array of size n, and prefix[i] = prefix[i-1] + arr[i]. After creating this prefix Array.

For any given l and r, 
Sum of the elements in arr in the Range of [l … r] = Prefix[r] - prefix[l-1]

Pseudo Code:- https://ideone.com/QaBpAq

C++ - https://ideone.com/QrJt18
Java - https://ideone.com/qvZF9P
Py - https://ideone.com/ilf2gL




Time Complexity - O(N+Q) 
O(n) for creating Prefix Array
O(q) for Traversing Queries 

Space Complexity - O(N) Because of Prefix Array

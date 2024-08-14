# Count of Pairs with absolute difference K

Count all i,j pairs where i < j and abs(b[i]-b[j]) = k [k>=0] 

## Brute Force Approach:- 

Use 2 Nested For Loops and for every i, start j from i+1, because j>i(given in problem). Check if Absolute Difference between b[i] and b[j] == k, cnt++. Finally Print this Count of All Valid Pairs.


Pseudo Code:- https://ideone.com/xdoLF6

C++ - https://ideone.com/2ufyWR
Java - https://ideone.com/622jVU
Py - https://ideone.com/SQ14vU

Time Complexity - O(n^2)
Space Complexity - O(1)

## Optimised Approach:- 

Just fixing b[j] and for every b[j] count the frequency of how many times b[i] has come.
B[i] will be calculated using following 2 formulas:-

B[i] = b[j] + k
B[i] = b[j] - k

Pseudo Code:- https://ideone.com/4Hd8Ws

C++ - https://ideone.com/K5X84f
Java - https://ideone.com/NLQpnj
Py - https://ideone.com/GXYxhh


Time Complexity - O(n)
Space Complexity - O(n)

# Count Pair Sum

Count all the (i,j) Pairs such that b[i] + b[j] == k (count of such pairs.) [i<j] 


## Brute Force Approach:- 

Iterate over all i and j and check if(arr[i] + arr[j] == k), increment cnt by 1. At the end, print this total Count

Pseudo Code:- https://ideone.com/YNhzfL
 
C++ - https://ideone.com/WW0EoE
Java - https://ideone.com/xlQHyb
Py - https://ideone.com/BZoFLc


## Optimised Approach:- 

At each Index i, we will find the Complementary Element We need. Now, we will check if this Complementary Element is present in Map Already, we will do cnt++. We will now update entry of our current index element in map.

Pseudo Code - https://ideone.com/ziZkMX

C++ - https://ideone.com/6Iv0ho
Java - https://ideone.com/PG8b5R
Py - https://ideone.com/Iwao8S

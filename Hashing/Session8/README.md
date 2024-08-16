# Count of Shortest/Largest Sub-Arrays with Sum K

Find count of shortest/largest subarrays with sum k in given array


## Brute Force Approach:- 

Use 2 Nested For loops, i will denote starting point of subarray and j will denote point of subarray, now we will check if sum of elements of current subarray is equal to k, we will compare its length with maxSize and minSize and update the count Accordingly

Pseudo Code - https://ideone.com/ZADHIE


C++ - https://ideone.com/gANUjN
Java - https://ideone.com/pz5bY2
Py - https://ideone.com/glWPJY


## Optimised Approach:- 

First Calculate size of Largest subarray and Smallest Subarray with sum of Elements as k using Maps. Now, just calculate the count of those subarrays which have size as calculated above and sum of elements as k.

Pseudo Code - https://ideone.com/1bS2xC


C++ - https://ideone.com/ViRvTA
Java - https://ideone.com/7BqsO6
Py - https://ideone.com/7iC26p

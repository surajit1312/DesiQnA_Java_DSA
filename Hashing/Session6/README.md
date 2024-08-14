# Number of Sub-Arrays with Sum K

Find count of number of subarrays with sum ==  k 

## Brute force approach:- 

Use 2 Nested For loops. Check for every i and j the sum of subarray Starting at Index I and ending at Index J and if this sum comes out to be equal to K then do count++

Pseudo Code - https://ideone.com/72UPXg

C++ - https://ideone.com/pvkJO6
Java - https://ideone.com/2En6Sm
Py - https://ideone.com/76m57l


Time Complexity - O(N*N)
Space Complexity - O(1)

## Optimised Approach:- 

Maintain the Prefix sum array and for every index J we will calculate X which will be equal to sum of elements till index j - k. Now, do cnt = cnt + freq[x]
 And update freq of current sum as freq[currentSum]++


Time Complexity - O(N)
Space Complexity - O(N)

Pseudo Code - https://ideone.com/sEtny0

C++ - https://ideone.com/6r6NEF
Java - https://ideone.com/eN29dk
Py - https://ideone.com/Va6LEz

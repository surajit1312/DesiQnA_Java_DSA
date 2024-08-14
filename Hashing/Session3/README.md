# Count of Pairs with difference K

Count All ((i,j) pairs such that b[i] - b[j] == k (count of such pairs.) [i<j] 


## Brute Force Approach:-

Just Run 2 Nested For loops and for each i, start the j pointer from i+1 because (j>i). Now check the difference between arr[i] and arr[j]

Diff = arr[i] - arr[j]

If this Diff == k, we will increase the count of valid pairs. Cnt++

Pseudo Code:- https://ideone.com/aJtexO

C++ - https://ideone.com/7iPAkU
Java - https://ideone.com/W4XGNB
Py - https://ideone.com/4Up9IW

Time Complexity:- O(N^2)
Space Complexity:- O(1)

## Optimised Approach:- 

Instead of Running 2 Nested For loops, we will create a Hashmap to Store the Occurences of the Elements which we have encountered in the past. At each index i, we will calculate the Required Element, = (arr[i]+k), we wil check if it is present in hashmap, we will do cnt = cnt + freq[requiredElement]. We will update the frequency for current element in hashmap.

Pseudo Code:- https://ideone.com/bS7uLK

C++ - https://ideone.com/7QeL29
Java - https://ideone.com/unkYm1
Py - https://ideone.com/XWQp3m



Time Complexity:- O(N)
Space Complexity:- O(N)

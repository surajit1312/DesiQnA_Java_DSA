# Hashing

A technique used to store the numbers with their frequencies in easy manner 


## Question :- You are given an array of size “n” ; you are also given “Q” queries for each of the query please tell how many times a given number occurs in the array 


Logic - https://ideone.com/4u4p13. 

C++ https://ideone.com/OFfbRZ. 
Java. https://ideone.com/NlBzKH.  
Py https://ideone.com/8JooNJ. 

Time Complexity :- O(N + N*Q) = O(N*(1+Q)) ====O(N*Q)
Took O(1) size. = You did not use any extra space; apart from the input array we don’t count the space taken by the input array in coding questions. 

### Optimize and reduce the time complexity by using hashing concept 

Let’s put a constraint in the array :- All the numbers in the array will be from 0 to 50 only  

Each query will also ask frequency of numbers from 0 to 50 only 

#### Hashing Trick

Use one more extra array Hash[51] ; where Hash[i] will tell you how many times the number “i” come in array[]-> original array 

Hash[] is a temporary array which stores the details of the the main array


Logic https://ideone.com/Uynxrg 

C++ https://ideone.com/KdA6j3. 
Java. https://ideone.com/Xz9DUu. 
Py https://ideone.com/au1oNg 

Time complexity is O(N+Q) which is much less than and better than O(N*Q)

Space Complexity :- O(maximum number in the original array) = O(50) = size of the hash array 

The space complexity can be very big if elements in the array big like 10^6 or 10^7 or 10^8 in that case you will have to make hash[] of size [10^6] or [10^7] or [10^8] which will be very inefficient because it takes lots; of space!

Final Solution:- Use HashMap instead of Hash array (Key,Value) Pair Mapping 

Use HashMap Data structure!

It is exactly the same as Hashing array but it saves space! 

Hashmap only takes O(N) space in the worst case! Whereas Hashing array takes O(max element in array space)




C++ https://ideone.com/cuUnQT 
Java. https://ideone.com/X62BGv. 
Py https://ideone.com/FUmWz6.  


TC :- O(N+Q) :- Insertion operation in a Hashmap has average O(1) time complexity and printing hashmap[i] also takes O(1) time on average. 

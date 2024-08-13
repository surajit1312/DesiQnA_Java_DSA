# Max. Min. Frequency of Number

We are given an Array of Numbers. We have to find and print any Number with Maximum Frequency and Minimum Frequency.

## Example Testcase:-

Arr = [3, 2, 3, 2, 4, 3]

Frequencies of Elements of Array are:-

3 - 3
2 - 2
4 - 1

Maximum Frequency:- Element is 3, Frequency is 3
Minimum Frequency:- Element is 4, Frequency is 1

## Brute Force Approach:-
C++ - https://onecompiler.com/cpp/42duddtf4
Java - https://onecompiler.com/java/42jzsts9t
Py - https://onecompiler.com/python/42jzsyvux


Brute Force Approach will work in O(N^2) because of 2 Nested For Loops

## Optimized Approach:- Use Hashmap to Store the Frequencies of Elements where key will be the Array Element and Value will be the Frequency of Array Element and Update our Maximum and Minimum Frequencies Accordingly.

Pseudo Code:- https://onecompiler.com/cpp/42duebjfx

C++ - Code
Java - https://ideone.com/MNpPDw
Py - https://onecompiler.com/python/42fe778ws

Time Complexity - O(nlogn)
Space Complexity - O(n)

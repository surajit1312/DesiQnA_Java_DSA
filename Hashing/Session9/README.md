# Leetcode 242. Valid Anagram

Problem Link - https://leetcode.com/problems/valid-anagram/

Observation - The Number of times a Particular Character is coming in String 1, Same no. of times it should come in string 2 also.
Reason -> It is mentioned in the problem statement that we cannot add or remove any characters from string 1, we can just rearrange it’s characters

Understanding of the Problem → We want to check if count of all characters is Equal in both Strings, then these strings will be called Anagrams

## Brute Force - 

Sorting Strings

Code - https://leetcode.com/problems/valid-anagram/submissions/886124300/

Time Complexity - O(NLogn)
Space Complexity - O(1) +  Space Complexity Used in Sorting Depending upon your Programming Language.

## Optimization - 1

Using 2 Hashmaps

C++ - https://leetcode.com/problems/valid-anagram/submissions/1349270594/

Java - https://leetcode.com/problems/valid-anagram/submissions/1349354034/

PY - https://leetcode.com/problems/valid-anagram/submissions/1349354234/


## Optimisation - 2

Using only 1 Hashmap

C++ - https://leetcode.com/problems/valid-anagram/submissions/1349269602/

Java - https://leetcode.com/problems/valid-anagram/submissions/1349316088/

Py  - https://leetcode.com/problems/valid-anagram/submissions/1349318190/

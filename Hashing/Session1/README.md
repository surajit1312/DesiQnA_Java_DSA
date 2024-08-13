# Equal numbers in an array at a distance <= k

Check if there are any two Equal numbers in an array at a distance less than or equal to k


## Brute Force :- 

Just Use 2 For loops and check if distance between any 2 Equal elements is less than or equal to k, print(yes), otherwise, we will print (no)

Pseudo Code - https://ideone.com/4Df8eb


C++ - https://ideone.com/YogIDN
Java - https://ideone.com/8MV5RS
Py - https://ideone.com/keWsIx



## Optimised using Hashmaps:- 

For every element, we need to check only the last Occurence or the Last index where this element has occurred before. We can use a hashmap which will tell us the Last occurrence where this element has occurred. 

We just need to calculate the distance between current Occurence and Last Occurence of Current Element.

If this Distance <= k, we have found a valid pair. We will return true. Otherwise, We will return false because we are now sure that we have not found any valid pair of equal elements whose distance btw them is <= k.

Pseudo code - https://ideone.com/ZCkYoo


C++ - https://ideone.com/tub18g
Java - https://ideone.com/lHHBBd
Py - https://ideone.com/p28Mdr

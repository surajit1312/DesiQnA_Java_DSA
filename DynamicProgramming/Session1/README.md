# Query Sum of all numbers till index 

## We are given an array of integers(a[n]) . We are given multiple queries of the form : (0, i) which means we need to output the sum of all numbers from index - ‘0’ to index ‘i’ of the array.


So, most of us have heard about this term “DP” a lot and have seen people in fear as soon as they listen to it.

I used to fear DP a lot too , but then I found the easiest way to master it :-) 

I will share my way :-) 

I will make you fall in love with this topic . 

### Important points:-

1. To be good at DP, all you have to do is solve classical DP-problems and their variations.

2. Recognize patterns and improve upon your thinking skills in DP.

3. Love DP, it will love you back !

There are many variations of DP and I’ll discuss them all one by one so you can become a pro!

### Introduction to DP :-

To find solution to a problem, we divide the problem into sub-problems, find answers to those sub-problems , combine them to get the original answer!

That’s it!

Example:- Say I ask you to calculate :- (1+2+3+4+5) You do this:-   

1)Break it into sub-problems : (1+2)+(3+4)+(5)

2) Find answers to those sub-problems: (3) + (7) + (5) 

3) Combine them to get the answer to the original problem : 15.


That’s what we call dynamic programming !(Only keep this definition of dp in mind as a beginner , we will evolve it as we become pro in future tutorials) :-)

### My personal trick :-

-->dp[i] usually mean the best answer to the problem till the i’th index of the array.

-->Obviously, final answer will be dp[n](where 'n' is the size of the array)


-->We cannot calculate dp[n] directly, we first need to calculate dp[1],dp[2],… and combine their results to find the value of dp[n] :-)

### Problem-1 : We are given an array of integers(a[n]) . We are given multiple queries of the form : (1, i) which means we need to output the sum of all numbers from index- ‘1’ to index ‘i’ of the array.

Analysis : Running a loop for each query[O(N)] and finding the sum is a good idea but not very efficient as it takes O(N*Q) time.

Let us create a dp-array of size ‘n’.

-->dp[1]=sum of all numbers from (1,1)

-->dp[2]=sum of all numbers from (1,2)…

and so on.

Say, a[5]={4,5,3,2,1}…(assume 1-based-indexing here) So, dp[1]=4(pretty easy)…..(1)

dp[2]=4+5=9………(2)

dp[3]=4+5+3=12…..(3) and so on.

So, for any index ‘i’ ,

dp[i]=a[i]+dp[i-1],

Example:-

dp[3] = a[3] + dp[3–1] = a[3] + dp[2]= 3 + 9 =12 ….(which is same as equation…(3))


Piece of code(Java) :- Refer the code

This took O(N) time!

Voila! We did it!

So, now for all the queries, all we gotta do is output the value of dp[i], which we have already pre-computed :-)

Time taken:- O(N+Q) [ O(N) for pre-computation, as we answered each query in O(1), total time taken was O(Q) ]


So you get the basic idea of DP is to make a recurrence relation ,and then run a loop ,and calculate(pre-compute) the values :-)

My aim is to start this series from a very beginner level and make you reach the advanced level :-)

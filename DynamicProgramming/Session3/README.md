# Maximum Subset Array Sum of Non-Adjacent Elements in an Array

Aim of this series:- “ To make you fall in love with Dynamic Programming. To show you the actual beauty of this topic. To go from beginner level to master level.”

## Some of the common tricks we have learned as of now :

-->1. Usually, we create a dp-array , and dp[i] means the maximum sum(best-answer) we could get till index-’i’ of the array.


-->2. We need to find a recurrence relation, in simple words, we need to create a formula for dp[i] in terms of

dp[i-1],dp[i-2],….etc…

3. We run a for loop, which calculates dp[1],dp[2]…..and finally dp[n].

4. dp[n] means the answer for the whole array.

Last time, we discussed this problem :-

Given an array of integers(positive as well as negative) ,select some elements from this array(select a subset) such that:-

1. Sum of those elements is maximum(Sum of the subset is maximum).


2. No two elements in the subset should be consecutive.

Example :- {2,4,6,7,8}

Answer:- {2+6+8=16}

Now, let's solve a harder variation of this problem, which will make our understanding strong.

## Modified Version : We are given ‘2’ arrays . Select some elements from both of these arrays (select a subset) such that:-

### 1. Sum of those elements is maximum(Sum of the subset is maximum).

### 2. No 2 elements in the subset should be consecutive.(Note:-If you select, say the 5th element from Array-1, then you are not allowed to select 4th element from either Array-1 or Array-2 nor are you allowed to select the 5th element from Array -2 all of them are considered consecutive

#### Example:->

Array 1(a1) : {1,5,3,21234}

Array 2(a2) : {-4509,200,3,40}

Answer:- (200+21234=21434)

#### Common Trick : We create a dp-array , and dp[i] means the maximum sum we could get till index-’i’ of both the arrays in this case.

For the above example,

dp[1] = 1(1) , [This is the best answer you could get if size of both the arrays was one]

dp[2]= 200(200),[This is the best answer you could get if size of both the arrays was two]

dp[3]=200(200), [This is the best answer you could get if size of the arrays was three]………lets call this equation-(1)…

dp[4]=21434(200+21234), [This is the best answer you could get if size of both the arrays was four]

Say, I have calculated dp[1], dp[2] and dp[3] by pure observation. Now, I have to calculate dp[4].

So I have only two choices:-

#### i)Include the 4'th element (of either array-1 or array-2, if I do this, I can’t include the 3rd element(from both the arrays) as consecutive elements are not allowed, so,

dp[4]= (max(a1[4],a2[4])) + dp[2])…..(answer will be 4th element plus the best answer till index ‘2’ of the arrays)

#### ii)Exclude the 4th element, we don’t select it! So the previous answer is the current answer, we don’t change anything,

dp[4]=dp[3],

Final answer is the maximum of two choices :---> dp[4]=maximum(max(a1[4],a2[4])+dp[2],dp[3]) =maximum(max(40,21234)+200,200)

=maximum(21234+200,200)

=maximum(21434,200)

=21434…..(verify this with equation…(1))

Voila, we did it !!!

So,the recurrence relation for this problem is, for any ‘i’ ,

dp[i]=max( max(a1[i],a2[i]) +dp[i-2],dp[i-1])

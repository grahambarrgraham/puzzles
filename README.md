# puzzles

Repo for solutions to various algorithm programming puzzles from topcoder etc.

## AB

### Problem Statement
 You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:

 The string has exactly N characters, each of which is either 'A' or 'B'.
 The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
 If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.

### Solutions coded
* Exhaustive - generates all possible combinations of n As and Bs, and picks first one that has k pairs.  Very slow.
* Iterative - Starts with n/2 'A's followed by n/2 'B's and iteratively shuffles 'A's one at a time through the 'B's until there are k pairs.
* Best - Starts with n/2 As followed by n/2 Bs, similar to Iterative, but computes positions, rather than shuffling one at a time.

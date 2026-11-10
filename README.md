[![Instagram](https://img.shields.io/badge/Instagram-lacopydepastel-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://instagram.com/lacopydepastel)
[![YouTube](https://img.shields.io/badge/YouTube-%40rvorine-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://youtube.com/@rvorine)

# Partition Labels (LeetCode 763)

## Problem

Split string `s` into as many parts as possible so that **each letter appears in at most one part**. Return the sizes of the parts. Joining the parts in order must give back `s`.

Example:

```
Input:  "ababcbacadefegdehijhklij"     Output: [9, 7, 8]
        // "ababcbaca", "defegde", "hijhklij"
Input:  "eccbbbbdec"                   Output: [10]
Input:  "a"                            Output: [1]
```

## Solution

**Greedy with last occurrences.**

1. One pass to record the **last index** of every letter.
2. Scan left to right, keeping `end` — the farthest last-occurrence of any letter seen in the current part: `end = max(end, last[ch])`.
3. When the scan index `i` reaches `end`, every letter in this part has finished, so nothing later can belong to it. Cut here, record `end - start + 1`, and start the next part at `i + 1`.

Cutting at the earliest safe point gives the maximum number of parts.

Walk through `"ababcbaca..."`: `a` last appears at index 8, so the first part must extend to 8; `b` (5) and `c` (7) fall inside it. At `i = 8` the part closes with size 9.

**Time:** O(n) — two passes.
**Space:** O(1) — a table of at most 26 letters.

## Implementations

| Language | File |
|---|---|
| Python | [`python/partition_labels.py`](python/partition_labels.py) |
| Java | [`java/PartitionLabels.java`](java/PartitionLabels.java) |
| Kotlin | [`kotlin/PartitionLabels.kt`](kotlin/PartitionLabels.kt) |
| JavaScript | [`javascript/partitionLabels.js`](javascript/partitionLabels.js) |
| C# | [`csharp/PartitionLabels.cs`](csharp/PartitionLabels.cs) |

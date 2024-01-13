<!---
Copyright (C) 2024 Christopher Siems - All Rights Reserved

You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have been included this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
--->

# Longest Substring Without Repeating Characters - Time Complexity Optimized

## Intuition

The Longest substring Without Repeating Characters problem requires us to find the length of the longest substring within a string, `s`, that does not have any repeating characters. To devise an algorithm to solve this problem, let us consider what we know.

- If `s` is `null` or has a length of `0`, `0` can be returned.

- If `s` has a length of `1`, `1` can be returned.

- A set can be used to keep track of characters currently in the substring, as sets do not allow repeated characters.

- An integer variable can be used to store the length of the longest substring yet found.

- A sliding window algorithm can be used to keep track of the current substring.

- We can use a for-loop with two control variables to manipulate the sliding window.

- We can increase the end of the window until we find a repeated character then remove the repeated character from the set and increase the front of the window.

- `Math.max()` can be used to determine if the current substring is longer than the previous longest substring.

## Approach

1. Check if `s` is null or has a length of `0`, return `0` if so.

2. Check if the length of `s` is `1`, return `1` if so.

3. Create a set of characters, `seen`, to store characters currently in the substring.

4. Create an integer variable to store the length of the longest substring yet seen.

5. Open a for-loop with two control variables `front` and `back`, where `back` is less than the length of `s` and `front` is less than or equal to `back`, leave out the increment step of the for-loop signature. The for-loop will contain several statements.

    1. Check if `seen` contains the character at index `back`, if so remove the character at index `front` from `seen` and increment `front`.

    2. Otherwise, check if the distance from `front` to `back` is greater than `length`, if so set `length` equal to `back - front + 1`, add the character at index `back`, and increment back.

6. Return `length`.

## Complexity

### Time complexity

$O(n)$. In the worst case scenario, this algorithm's for-loop iterates $2n$ times, where $n$ is the length of `s`. All other operations take constant time. $O$ notation ignores coefficients, so the time complexity of this algorithm is $O(n)$.

### Space complexity

$O(n)$. `seen` grows linearly with the number of characters in `s`, thus, space complexity of this algorithm is $O(n)$.

## Code

```Java
import java.util.Set;
import java.util.HashSet;

public class Solution {
  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }
    Set<Character> seen = new HashSet<Character>();
    int length = 0;
    for (int front = 0, back = 0; back < s.length();) {
      if (seen.contains(s.charAt(back))) {
        seen.remove(s.charAt(front));
        front++;
        continue;
      }
      length = Math.max(length, (back - front) + 1);
      seen.add(s.charAt(back));
      back++;
    }
    return length;
  }
}
```

## Notes

- The import statement in this code is unnecessary in LeetCode and will cause slowdown.

###### Copyright (C) 2024 Christopher Siems - All Rights Reserved

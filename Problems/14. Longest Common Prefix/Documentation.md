<!---
Copyright (C) 2024 Christopher Siems - All Rights Reserved

You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have been included this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
--->

# Longest Common Prefix

## Intuition

The Longest Common Prefix problem requires us to find the longest substring common to the start of all strings in an inputted array of strings, `strs`. To devise an algorithm to solve this problem, let us consider what we know.

- If `strs` is `null` or empty, the longest common prefix is `""` and can be returned.

- If `strs.length` equals 1, the longest common prefix is the totality of `strs[0]` and can be returned.

- `Arrays.sort(strs)` can sort `strs` alphabetically.

- Empty strings are sorted to the front of alphabetical arrays and are common prefixes of all strings, if one exists at the front of the sorted `strs` it can be returned.

- An integer can be used to store the length of the computed common prefix

- Only the first and last strings in the sorted `strs` need to be compared as those two will be the must dissimilar, thus if a common prefix can be found between them, it is common to all in `strs`.

- Strings can be compared character by character

## Approach

1. Check if `strs` is `null` or has a length of 0 and return `""` if so.

2. Check if the length of `strs` is 1 and return `strs[0]` if so.

3. Sort `strs` with `Arrays.sort(strs)`.

4. Check if `strs[0]` is `""` and return `""` if so.

5. Create an integer variable, `length`, initialized to `0`.

6. Open a while-loop with an if-statement inside it and `length < strs[0].length()` as its condition.

    1. Check if the character at index `length` of the first and last strings in `strs` are the same. If they are increment length, otherwise end the while loop.

7. return `strs[0].substring(0, length)`.

## Complexity

### Time complexity

$O(n\log (n))$. `Arrays.sort()` takes $O(n\log (n))$ time to complete, where $n$ is the number of elements in `strs`, which is the dominant runtime of any of the parts of this algorithm. Since $O$ notation is only concerned with the dominant term our time complexity is $O(n\log (n))$.

### Space complexity

$O(1)$. This algorithm uses a constant amount of memory regardless of input size. So the space complexity of the algorithm is $O(1)$.

## Code

```Java
import java.util.Arrays;

public class Solution {
  public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    Arrays.sort(strs);
    if (strs[0].equals("")) {
      return "";
    }
    int length = 0;
    while (length < strs[0].length()) {
      if (strs[0].charAt(length) == strs[strs.length - 1].charAt(length)) {
        length++;
        continue;
      }
      break;
    }
    return strs[0].substring(0, length);
  }
}
```

## Notes

- This algorithm is fully optimized for both time and space complexities.

- The import statement in this code is unnecessary in LeetCode and will cause slowdown.

###### Copyright (C) 2024 Christopher Siems - All Rights Reserved

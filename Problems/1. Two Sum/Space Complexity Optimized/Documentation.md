<!---
Copyright (C) 2024 Christopher Siems - All Rights Reserved

You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have been included this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
--->

# Two Sum - Space Complexity Optimized

## Intuition

The Two Sum problem requires us to find two integers in an array, `nums`, of integers that sum to a target integer, `target`, and return an array containing the indices of said two integers. To devise an approach to solving this problem, let us consider what we know.

- We are working with an indexed data structure, `nums`, so traversing the structure can be easily accomplished with a for-loop.

- To keep memory usage as low as possible we need to use a low and unchanging number of data pieces. This means we should not create extra variables or data structures when it is not necessary to do so.

With these ideas in mind, let us begin to formulate an approach.

## Approach

Because we are not implementing any sort of data structure that would allow us to avoid doing so, we will need to use a nested for-loop to find our desired integer. In our approach we will have an outer for-loop that will loop through `nums` and an inner for-loop that will loop from the current integer of the outer for-loop through the rest of `nums`. Inside this inner for-loop we will check to see if each integer in `nums` sums to `target` with the current integer of the outer for-loop. If it does we can return a new integer array of the indices of the outer for-loop's integer and the inner for-loop's integer. If the outer for-loop is completed with nothing returned we may return `null`. This algorithm will find the first two integers in `nums` that sum to `target`.

## Complexity

### Time complexity

$O(n^2)$. In the worst-case scenario `nums` will be iterated over $\sum^n_{i = 1} i = \frac{n(n-1)}{2} = \frac{n^2-n}{2}$ times. By convention, $O$ notation ignores all but the dominant term, $n^2$, and ignores coefficients. So our algorithm has a time complexity of $O(n^2)$.

### Space complexity

$O(1)$. Our algorithm uses a static number of data pieces, only two for-loop variables and the two pieces of input data, `nums` and `target`. So our algorithm will use a constant, $O(1)$, amount of memory.

## Code

```
public class Solution {
  public static int[] twoSum(int[] nums, int target) {
    for (int index1 = 0; index1 < nums.length - 1; index1++) {
      for (int index2 = index1 + 1; index2 < nums.length; index2++) {
        if (nums[index1] + nums[index2] == target) {
          return new int[] {index1, index2};
        }
      }
    }
    return null;
  }
}
```

## Notes

- LeetCode's memory usage calculations are finicky and will produce differing numbers each time the solution is submitted, regardless, memory used is constant with this algorithm

###### Copyright (C) 2024 Christopher Siems - All Rights Reserved
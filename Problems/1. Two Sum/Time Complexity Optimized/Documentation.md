<!---
Copyright (C) 2024 Christopher Siems - All Rights Reserved

You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have been included this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
--->

# Two Sum - Time Complexity Optimized

## Intuition

The Two Sum problem requires us to find two integers in an array, `nums`, of integers that sum to a target integer, `target`, and return an array containing the indices of said two integers. To devise an approach to solving this problem, let us consider what we know.

- We need to keep track of integers and their associated indices, because we need to associate pieces of data with other pieces of data we can probably use a hash table.

- We are working with an indexed data structure, `nums`, so traversing the structure can be easily accomplished with a for-loop.

- When comparing an integer in `nums` to `target`, the number we need to add to said integer is equivalent to the `target` minus the integer.

With these ideas in mind, let us begin to formulate an approach.

## Approach

1. Create a hash table to store values of `nums` already examined as keys and their indices as values. With this structure for the hash table we can call the `get()` method with our desired value as the argument and get the index of that value in the array, as long as that value has been examined by the algorithm prior.

2. Use a for-loop to iterate through the array from front to back. In the body of said for-loop we need to do a few things.

    1. Find the `complement` of the current integer in `nums` that makes `target` when summed with the current integer.

    2. Check if `complement` is already a valid key in the hash table. If it is, we have found our two integers and can call `get(complement)` on the hash table to retrieve `complement`'s index, then we can return an array of `complement`'s index and the current integer in `nums`' index.

    3. If `complement` is not a valid key in the hash table, we add the current value and index to the hash table as a key-value pair and iterate to the next integer in the array.

3. In the event there is no pair of indices returned within the for-loop, we can return `null`.

This algorithm will find the first two integers in an array that sum to `target`, but there is a change we can make to further optimize time complexity. Instead of iterating from the front of the array to the back of the array, we can use a two pointer approach and create two for-loop variables. One variable iterating forward through the array, `front`, and one variable iterating backward through the array, `back`. With the for-loop terminating when `front` takes on a value greater than `back`. With these new variables we can change the body of the for-loop.

1. Compute the `complement` of `front` and check if it is present in the hash table, returning an array of `complement`'s index and `front`'s index if `complement` is present in the hash table.

2. Compute the `complement` of `back` and check if it is present in the hash table, returning and array of `complement`'s index and `back`'s index if `complement` is present in the hash table.

3. Check if `front` and `back` are complements of each other, returning an array of both of their indices if so.

4. If we are yet to find the two integers that sum to `target`, we add both `front` and `back`, along with their associated indices, to the hash table as key-value pairs.

This alteration of the original algorithm will result in the for-loop running half as many times as before.

## Complexity

### Time complexity

$O(n)$. In the worst case scenario our algorithm will run its for-loop $\frac{n}{2}$ times and all other operations in our algorithm take constant, $O(1)$, time. By convention, coefficients are ignored when computing the time complexity of a algorithm so our algorithm's time complexity is $O(n)$. Our unoptimized algorithm has the same time complexity, but in practice, the optimized algorithm will operate quicker.

### Space complexity

$O(n)$. The amount of memory our algorithm uses scales linearly with the size of `nums`, so our algorithm's space complexity is $O(n)$.

## Code

```Java
import java.util.Map;
import java.util.HashMap;

public class Solution {
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> complements = new HashMap<Integer, Integer>();
    for (int front = 0, back = nums.length - 1; front <= back; front++, back--) {
      int complement = target - nums[front];
      if (complements.containsKey(complement)) {
        return new int[] {complements.get(complement), front};
      }
      complement = target - nums[back];
      if (complements.containsKey(complement)) {
        return new int[] {complements.get(complement), back};
      }
      if (complement == nums[front]) {
        return new int[] {front, back};
      }
      complements.put(nums[front], front);
      complements.put(nums[back], back);
    }
    return null;
  }
}
```

## Notes

- Import statements are unnecessary in LeetCode and cause slowdown, the included import is best ignored when using this algorithm in LeetCode

###### Copyright (C) 2024 Christopher Siems - All Rights Reserved

# Two Sum - Time Complexity Optimized

## Intuition

The Two Sum problem requires us to find two integers in an array, _nums_, of integers that sum to a target integer, _target_, and return an array containing the indices of said two integers. To devise an approach to solving this problem, let us consider what we know. We need to keep track of integers and their associated indices, because we need to associate pieces of data with other pieces of data we can probably use a hash table. We are working with an indexed data structure, _nums_, so traversing the structure can be easily accomplished with a for-loop. When comparing an integer in _nums_ to _target_, the number we need to add to said integer is equivalent to the _target_ minus the integer. With these ideas in mind, let us begin to formulate an approach.

## Approach

We should first create a hash table to store values of _nums_ already examined as keys and their indices as values. With this structure for the hash table we can call the _get()_ method with our desired value as the argument and get the index of that value in the array, as long as that value has been examined by the algorithm prior. Let us use a for-loop to iterate through the array from front to back. In the body of said for-loop we need to do a few things. First, it would be useful find the _compliment_ of the current integer in _nums_ that makes _target_ when summed with the current integer. Second, we need to check if _compliment_ is already a valid key in the hash table. If it is, we have found our two integers and can call _get(compliment)_ on the hash table to retrieve _compliment_'s index, then we can return an array of _compliment_'s index and the current integer in _nums_' index. Third, if _compliment_ is not a valid key in the hash table, we add the current value and index to the hash table as a key-value pair and iterate to the next integer in the array. In the event there is no pair of indices returned within the for-loop, we can return _null_. This algorithm will find the first two integers in an array that sum to _target_.

This is the basic idea of our solution, but there is a change we can make to further optimize time complexity. Instead of iterating from the front of the array to the back of the array, we can use a two pointer approach and create two for-loop variables. One variable iterating forward through the array, _front_, and one variable iterating backward through the array, _back_. With the for-loop terminating when _front_ takes on a value greater than _back_. With these new variables we can change the body of the for-loop. First, we may compute the _compliment_ of _front_ and check if it is present in the hash table, returning an array of _compliment_'s index and _front_'s index if _compliment_ is present in the hash table. Second, we may compute the _compliment_ of _back_ and check if it is present in the hash table, returning and array of _compliment_'s index and _back_'s index if _compliment_ is present in the hash table. Third, we check if _front_ and _back_ are compliments of eachother, returning an array of both of their indices if so. Fourth, if we are yet to find the two integers that sum to _target_, we add both _front_ and _back_, along with their associated indices, to the hash table as key-value pairs. This alteration of the original algorithm will result in the for-loop running half as many times as before.

## Complexity

### Time complexity

$O(n)$. In the worst case scenario our algorithm will run its for-loop $\frac{n}{2}$ times and all other operations in our algorithm take constant, $O(1)$, time. By convention, coefficients are ignored when computing the time complexity of a algorithm so our algorithm's time complexity is $O(n)$. Our unoptimized algorithm has the same time complexity, but in practice, the optimized algorithm will operate quicker.

### Space complexity

$O(n)$. The amount of memory our algorithm uses scales linearly with the size of _nums_, so our algorithm's space complexity is $O(n)$.

## Code

```
import java.util.HashMap;

public class Solution {
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> compliments = new HashMap<Integer, Integer>();
    for (int front = 0, back = nums.length - 1; front <= back; front++, back--) {
      int compliment = target - nums[front];
      if (compliments.containsKey(compliment)) {
        return new int[] {compliments.get(compliment), front};
      }
      compliment = target - nums[back];
      if (compliments.containsKey(compliment)) {
        return new int[] {compliments.get(compliment), back};
      }
      if (compliment == nums[front]) {
        return new int[] {front, back};
      }
      compliments.put(nums[front], front);
      compliments.put(nums[back], back);
    }
    return null;
  }
}
```

## Notes

- Import statements are unnessesary in LeetCode and cause slowdown, the included import is best ignored when using this algorithm in LeetCode
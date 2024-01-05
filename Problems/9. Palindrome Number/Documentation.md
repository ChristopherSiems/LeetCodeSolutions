<!---
Copyright (C) 2024 Christopher Siems - All Rights Reserved

You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have been included this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
--->

# Palindrome Number

## Intuition

The Palindrome Number problem requires us to determine if a given integer `x` is a palindrome and return `true` if it is. To devise and approach, let us consider what we know. 

- A negative integer is not a palindrome as it will start with `-` but will not end with a `-`.

- A non-zero integer that ends with a `0` cannot be a palindrome as leading zeros are not allowed in integers.

- For a number to be a palindrome its first half must be equivalent to its second half reversed.

- The one's place of an integer can be isolated by using `% 10` on an integer.

- The one's place of an integer can be removed from an integer by using `/ 10` on an integer.

- Integers with an odd number of digits can have their middle digit ignored as it will always be in the same place, even when the integer is reversed.

With these ideas in mind, let us begin to formulate an approach.

## Approach

1. Check if our special cases apply, the number is negative or is non-zero and ends in a `0`. If they do return `false`.

2. Create an integer variable, `reverse`, to store the reversed second half of `x`.

3. Use a while-loop with the condition of `x > reverse`. With two statements inside the body of the loop.

    1. In the first statement multiply the current value of `reverse` by 10 to create an empty one's place. Then add the one's place from `x` to `reverse`.

    2. Remove the one's place from `x`.

4. Return `true` if `x` is the same as `reverse` or `x` is the same as `reverse % 10`.

This algorithm will return `true` if the given integer is a palindrome and `false` otherwise.

## Complexity

### Time complexity

$O(n)$. Our algorithm will run a while-loop $\frac{n}{2}$ times to construct `reverse`, all of the while-loop's inner statements are preformed in $O(1)$ time. Since coefficients are ignored in $O$ notation, time complexity is $O(n)$.

### Space complexity

$O(1)$. This algorithm uses constant space in memory, the two variable `x` and `reverse`. Therefore, space complexity is $O(1)$.

## Code

```
public class Solution {
  public static boolean isPalindrome(int x) {
    if ((x < 0) || (x != 0 && ((x % 10) == 0))) {
      return false;
    }
    int reverse = 0;
    while (x > reverse) {
      reverse = reverse * 10 + x % 10;
      x /= 10;
    }
    return x == reverse || x == (reverse / 10);
  }
}
```

## Notes

- This algorithm is fully optimized for best time and space complexities

###### Copyright (C) 2024 Christopher Siems - All Rights Reserved
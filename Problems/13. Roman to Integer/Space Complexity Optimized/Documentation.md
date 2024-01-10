<!---
Copyright (C) 2024 Christopher Siems - All Rights Reserved

You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have been included this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
--->

# Roman to Integer  - Space Complexity Optimzed

## References

Roman Numeral | Arabic Numeral
---|---
I | 1
IV | 4
V | 5
IX | 9
X | 10
XL | 40
L | 50
XC | 90
C | 100
CD | 400
D | 500
CM | 900
M | 1000

## Intuition

The Roman to Integer problem requires us to convert a string of Roman numerals to an integer. To devise an algorithm to solve this problem, let us consider what we know.

- Two character Roman numerals are equivalent to the second character's value with the first character's value subtracted from it.

- We need to return the total value of the given string, `s`, so we should create an integer variable, `sum`, to store the running total.

- `s` is an indexed piece of data, a string, and can be iterated through with a for-loop.

- If we iterate backward through `s` we can catch characters who's values must be subtracted from `sum`

- If the value of the current character multiplied by four is less than the current value of `sum` then we need to subtract the value of the current character from `sum`.

- The individual characters in `s` may only be of a few types, thus we can examine the current character with a switch-case statement.

## Approach

1. Create a variable to store the running total of the values of the characters of `s`.

2. Open a for-loop with a switch-case statement inside that iterates backwards the length of `s`.

    1. Make the control variable for the switch-case statement `s.charAt(index)`.

    2. Make seven case statements for each one character Roman numeral.

        1. In the requisite case statements, include a test to see if four multiplied by the value of `s.charAt(index)` is less than `sum`. If it is, subtract the value of `s.charAt(index)` from `sum`.

        2. Otherwise, add the value of `s.charAt(index)` to `sum`.

3. Return `sum`.

This algorithm will find the value of a Roman numeral string with only two declared integer variables.

## Complexity

### Time complexity

$O(n)$. In the worst case scenario this algorithm's for-loop will iterate $n$ times, where $n$ is the length of `s`. As well, the switch-case statement will check 7 cases. So, at worst, it will take $7n$ steps to complete the for-loop. But with $O$ notation coefficients are ignored, so, the time complexity of this algorithm is $O(n)$.

### Space complexity

$O(1)$. This algorithm uses a constant and minimum amount of data and, thus, space complexity is $O(1)$.

## Code

```Java
public class Solution {
  public static int romanToInt(String s) {
    int sum = 0;
    for (int index = s.length() - 1; index >= 0; index--) {
      switch (s.charAt(index)) {
      case 'I':
        if (4 < sum) {
          sum -= 1;
          break;
        }
        sum += 1;
        break;
      case 'V':
        sum += 5;
        break;
      case 'X':
        if (40 < sum) {
          sum -= 10;
          break;
        }
        sum += 10;
        break;
      case 'L':
        sum += 50;
        break;
      case 'C':
        if (400 < sum) {
          sum -= 100;
          break;
        }
        sum += 100;
        break;
      case 'D':
        sum += 500;
        break;
      case 'M':
        sum += 1000;
        break;
      }
    }
    return sum;
  }
}
```

###### Copyright (C) 2024 Christopher Siems - All Rights Reserved

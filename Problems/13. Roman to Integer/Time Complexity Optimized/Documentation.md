<!---
Copyright (C) 2024 Christopher Siems - All Rights Reserved

You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have been included this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
--->

# Roman to Integer

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

- Mappings from Roman numerals to their arabic numeral counterparts may be stored in a hash table to be accessed in constant time.

- We need to return the total value of the given string, `s`, so we should create an integer variable, `sum`, to store the running total.

- If we iterate through `s` backwards, then we can use the property that the current value of `sum` will always be less than or equal to the value of the next character to be examined, unless that character is part of a two character Roman numeral.

- To detect two character Roman numerals we need to keep track of the value of the previous character, we can use an integer variable, `previous`.

## Approach

1. Build a hash table containing every one character Roman numeral.

2. Create the integer variables `sum` and `previous`, initialize both variables to `0`.

3. Open a for-loop that iterates backwards through `s` with a few actions within its body.

    1. Check if the value of the current character is less than the value of `previous` and if it is subtract the value of the current character from `sum`.

    2. Otherwise, add the value of the current character to `sum`, and set the `previous` to the value of the current character.

4. Return `sum`.

This algorithm will return the value of the inputted Roman numeral string as an integer variable of Arabic numerals.

## Complexity

### Time complexity

$O(n)$. The algorithm's for-loop will always iterate $n$ times, where $n$ is the length of the inputted string. Every other action is preformed in constant, $O(1)$ time. Therefore, the time complexity of this algorithm is $O(n)$.

### Space complexity

$O(1)$. The computation done by this algorithm uses a constant amount of data, so space complexity is constant, $O(1)$.

## Code

```Java
import java.util.HashMap;

public class Solution {
  public static int romanToInt(String s) {
    Map<Character, Integer> values = new HashMap<Character, Integer>();
    values.put('I', 1);
    values.put('V', 5);
    values.put('X', 10);
    values.put('L', 50);
    values.put('C', 100);
    values.put('D', 500);
    values.put('M', 1000);
    int sum = 0;
    int previous = 0;
    for (int index = s.length() - 1; index >= 0; index--) {
      int value = values.get(s.charAt(index));
      if (value < previous) {
        sum -= value;
        continue;
      }
      sum += value;
      previous = value;
    }
    return sum;
  }
}
```

## Notes

- The import statement in this code is unnecessary in LeetCode and will cause slowdown

###### Copyright (C) 2024 Christopher Siems - All Rights Reserved

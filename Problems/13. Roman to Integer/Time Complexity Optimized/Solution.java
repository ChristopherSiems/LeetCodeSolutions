/**
 * Copyright (C) 2024 Christopher Siems - All Rights Reserved
 *
 * You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have
 * been included with this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
 */

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
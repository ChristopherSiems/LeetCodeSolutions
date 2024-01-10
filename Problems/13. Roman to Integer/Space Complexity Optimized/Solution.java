/**
 * Copyright (C) 2024 Christopher Siems - All Rights Reserved
 *
 * You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have
 * been included this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
 */

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
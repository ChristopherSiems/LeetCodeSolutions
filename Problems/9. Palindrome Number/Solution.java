/**
 * Copyright (C) 2024 Christopher Siems - All Rights Reserved
 *
 * You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have
 * been included this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
 */

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
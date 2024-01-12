/**
 * Copyright (C) 2024 Christopher Siems - All Rights Reserved
 *
 * You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have
 * been included this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
 */

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

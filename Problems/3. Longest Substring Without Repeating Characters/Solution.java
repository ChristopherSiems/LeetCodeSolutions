/**
 * Copyright (C) 2024 Christopher Siems - All Rights Reserved
 *
 * You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have
 * been included this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
 */

import java.util.Set;
import java.util.HashSet;

public class Solution {
  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }
    Set<Character> seen = new HashSet<Character>();
    int length = 0;
    for (int front = 0, back = 0; back < s.length();) {
      if (seen.contains(s.charAt(back))) {
        seen.remove(s.charAt(front));
        front++;
        continue;
      }
      length = Math.max(length, (back - front) + 1);
      seen.add(s.charAt(back));
      back++;
    }
    return length;
  }
}
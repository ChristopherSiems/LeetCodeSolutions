/**
 * Copyright (C) 2024 Christopher Siems - All Rights Reserved
 *
 * You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have
 * been included with this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
 */

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
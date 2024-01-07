/**
 * Copyright (C) 2024 Christopher Siems - All Rights Reserved
 *
 * You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have
 * been included with this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
 */

public class Solution {
  public static int[] twoSum(int[] nums, int target) {
    for (int index1 = 0; index1 < nums.length - 1; index1++) {
      for (int index2 = index1 + 1; index2 < nums.length; index2++) {
        if (nums[index1] + nums[index2] == target) {
          return new int[] {index1, index2};
        }
      }
    }
    return null;
  }
}
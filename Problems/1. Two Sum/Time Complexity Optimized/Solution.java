import java.util.HashMap;

public class Solution {
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> compliments = new HashMap<Integer, Integer>();
    for (int front = 0, back = nums.length - 1; front <= back; front++, back--) {
      int compliment = target - nums[front];
      if (compliments.containsKey(compliment)) {
        return new int[] {compliments.get(compliment), front};
      }
      compliment = target - nums[back];
      if (compliments.containsKey(compliment)) {
        return new int[] {compliments.get(compliment), back};
      }
      if (compliment == nums[front]) {
        return new int[] {front, back};
      }
      compliments.put(nums[front], front);
      compliments.put(nums[back], back);
    }
    return null;
  }
}
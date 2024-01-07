/**
 * Copyright (C) 2024 Christopher Siems - All Rights Reserved
 *
 * You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have
 * been included this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
 */

public class Solution {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode head = new ListNode();
    ListNode current = head;
    while (l1 != null || l2 != null || carry != 0) {
      int sum = carry;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      carry = sum / 10;
      current.next = new ListNode(sum % 10, null);
      current = current.next;
    }
    return head.next;
  }
}
<!---
Copyright (C) 2024 Christopher Siems - All Rights Reserved

You may use, distribute, and modify this code under the terms of the GNU General Public License 3, which should have been included this file. If not visit: https://www.gnu.org/licenses/gpl-3.0.en.html
--->

# Add Two Numbers

## References

```Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
```

## Intuition

The Add Two Numbers problem requires us to find the sum of two non-empty linked lists representing non-negative integers in reverse order of digits and return the head node of the linked list. To devise an approach, let us consider what we know.

- Because each node only stores one digit, we will need an integer variable to store the ten's place digit if the sum of the two current nodes exceed 9.

- We need to return the head of the resulting linked list, so we should create a `ListNode` instance to keep track of the head, `head`.

- Linked lists are unindexed data structures, so it would be more convenient to use a while-loop to iterate over the linked lists than a for-loop.

- Each node in the linked list that we need to return contains the one's place digit of the sum of two current nodes of the given linked lists, we should use an integer variable to keep track of this sum.

- The given linked lists may differ in length, so we must handle the cases where we reach the end of a linked list and not try to get data from a `null` value.

- The ten's place of a two digit integer can be found by applying `/ 10` to an integer.

- The one's place of an integer can be found by applying `% 10` to an integer.

- The tail node in a linked list points to `null`.

With these ideas in mind, let us begin to formulate an approach.

## Approach

1. Create instances of the necessary data variables and objects.

    1. Create an integer, `carry`, for the carried digit and initialize it to be `0`.

    2. Create a ListNode, `head`, for the head of the returned linked list and initialize `head` with a new empty constructor ListNode.

    3. Create another ListNode, `current`, to keep track of the current node being worked with.

2. Open a while-loop with the condition that `l1` is not `null` or `l2` is not `null` or `carry` is not `0`. This while-loop will iterate through the linked list.

    1. Create an integer variable, `sum`, and initialize it to be `carry`.

    2. Add `l1.val` to sum if `l1` is not `null` and set `l1` to be `l1.next`.

    3. Do the previous step but for `l2`.

    4. Set `carry` to `sum / 10`.

    5. Set `current.next` to be a new ListNode with a `val` of `sum % 10` and a `next` of `null`.

    6. Set `current` to `current.next`.

3. Return `head.next`.

This algorithm will return the sum of the two linked lists inputted into it as linked lists in reverse order of digits.

## Complexity

### Time complexity

$O(n)$. In the worst case scenario, the while-loop will iterate $n + 1$ times, where $n$ is the number of nodes in the longer inputted linked list and the $1$ comes from the potential for the last summation to produce a carried digit. By the conventions of $O$ notation, the dominant term, $n$, is the only term that matters. So the time complexity of this algorithm is $O(n)$.

### Space complexity

$O(n)$. This algorithm will create a new linked list of, at worst, $n + 2$ length, where $n$ is the length of the longer inputted linked list and the $2$ comes from the empty head node created along with the potential tail node created by a carried digit from the final summation. By the conventions of $O$ notation, the dominant term, $n$, is the only term that matters. So the time complexity of this algorithm is $O(n)$.

## Code

```Java
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
```

## Notes

- This algorithm is both time complexity and space complexity optimized

###### Copyright (C) 2024 Christopher Siems - All Rights Reserved

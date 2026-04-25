package zest;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            length++;
            if(length > 2*10_000){
                throw new IllegalArgumentException("List length must be smaller than 2 * 10^4");
            }
            if(head.val < -100_000 || head.val > 100_000) {
                throw new IllegalArgumentException("List Node Values must be in range [-100000, 100000]");
            }
            list.add(head.val);
            head = head.next;
        }
        return sortedArrayToBST(list, 0, list.size() - 1);
    }

    private TreeNode sortedArrayToBST(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = sortedArrayToBST(list, start, mid - 1);
        root.right = sortedArrayToBST(list, mid + 1, end);
        return root;
    }
}

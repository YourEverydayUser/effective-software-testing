package zest;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ConvertSortedListToBinarySearchTreeTest {

    @Test
    public void testNull() {
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();

        TreeNode root = solution.sortedListToBST(null);

        assertThat(root).isNull();
    }

    @Test
    public void testOneElement() {
        int value = -10;
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(value);

        TreeNode root = solution.sortedListToBST(head);

        assertThat(root.val).isEqualTo(value);
        assertThat(root.right).isNull();
        assertThat(root.left).isNull();
    }

    @Test
    public void testTwoElements() {
        int value1 = -10;
        int value2 = 3;
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(-10);
        head.next = new ListNode(3);

        TreeNode root = solution.sortedListToBST(head);

        assertThat(root.val).isEqualTo(value1);
        assertThat(root.right.val).isEqualTo(value2);
        assertThat(root.left).isNull();
        assertThat(root.right.right).isNull();
        assertThat(root.right.left).isNull();
    }

    @Test
    public void testMultipleElements() {
        int value1 = -10;
        int value2 = -3;
        int value3 = 0;
        int value4 = 7;
        int value5 = 9;
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(value1);
        head.next = new ListNode(value2);
        head.next.next = new ListNode(value3);
        head.next.next.next = new ListNode(value4);
        head.next.next.next.next = new ListNode(value5);

        TreeNode root = solution.sortedListToBST(head);

        assertThat(root.val).isEqualTo(value3);
        if (root.left.val == value1) {
            assertThat(root.left.right.val).isEqualTo(value2);
            assertThat(root.left.left).isNull();
        } else {
            assertThat(root.left.val).isEqualTo(value2);
            assertThat(root.left.left.val).isEqualTo(value1);
            assertThat(root.left.right).isNull();
        }
        if (root.right.val == value4) {
            assertThat(root.right.right.val).isEqualTo(value5);
            assertThat(root.right.left).isNull();
        } else {
            assertThat(root.right.val).isEqualTo(value5);
            assertThat(root.right.left.val).isEqualTo(value4);
            assertThat(root.right.right).isNull();
        }
    }

    @Test
    public void testTooLongList() {

        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(-10);
        ListNode tail = head;
        int length = 20001;
        for (int i = 1; i < length; i++) {
            ListNode newNode = new ListNode(i);
            tail.next = newNode;
            tail = newNode;
        }

        assertThatThrownBy(() -> {
            solution.sortedListToBST(head);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("List length must be smaller than 2 * 10^4");

    }

    @Test
    public void testLongList() {
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(-10);
        ListNode tail = head;
        int length = 20000;
        for (int i = 1; i < length; i++) {
            ListNode newNode = new ListNode(i);
            tail.next = newNode;
            tail = newNode;
        }
        TreeNode root = solution.sortedListToBST(head);
        assertThat(root).isNotNull();
    }

    @Test
    public void testTooSmallElement() {
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(-100_001);

        assertThatThrownBy(() -> {
            solution.sortedListToBST(head);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("List Node Values must be in range [-100000, 100000]");
    }

    @Test
    public void testSmallElement() {
        int value = -100_000;
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(value);

        TreeNode root = solution.sortedListToBST(head);

        assertThat(root.val).isEqualTo(value);
    }

    @Test
    public void testTooBigElement() {
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(100_001);

        assertThatThrownBy(() -> {
            solution.sortedListToBST(head);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("List Node Values must be in range [-100000, 100000]");
    }

    @Test
    public void testBigElement() {
        int value = 100_000;
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(value);

        TreeNode root = solution.sortedListToBST(head);

        assertThat(root.val).isEqualTo(value);
    }

    @Test
    public void checkInvariant() {
        int value1 = -10;
        int value2 = -3;
        int value3 = 0;
        int value4 = 7;
        int value5 = 9;
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(value1);
        head.next = new ListNode(value2);
        head.next.next = new ListNode(value3);
        head.next.next.next = new ListNode(value4);
        head.next.next.next.next = new ListNode(value5);

        solution.sortedListToBST(head);

        assertThat(head.val).isEqualTo(value1);
        assertThat(head.next.val).isEqualTo(value2);
        assertThat(head.next.next.val).isEqualTo(value3);
        assertThat(head.next.next.next.val).isEqualTo(value4);
        assertThat(head.next.next.next.next.val).isEqualTo(value5);
        assertThat(head.next.next.next.next.next).isNull();
    }

    @Property
    public void testRange(
            @ForAll
            @IntRange(min = -100_000, max = 100_000) int value
    ) {
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(value);

        TreeNode root = solution.sortedListToBST(head);

        assertThat(root.val).isEqualTo(value);
    }

    @Property
    public void testRangeTooSmall(
            @ForAll
            @IntRange(min = Integer.MIN_VALUE, max = -100_001) int value
    ) {
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(value);

        assertThatThrownBy(() -> {
            solution.sortedListToBST(head);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("List Node Values must be in range [-100000, 100000]");
    }

    @Property
    public void testRangeTooBig(
            @ForAll
            @IntRange(min = 100_001) int value
    ) {
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(value);

        assertThatThrownBy(() -> {
            solution.sortedListToBST(head);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("List Node Values must be in range [-100000, 100000]");
    }

    @Property
    public void testRangeList(
            @ForAll
            @IntRange(max = 2 * 10_000) int length
    ) {
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(-10);
        ListNode tail = head;
        for (int i = 1; i < length; i++) {
            ListNode newNode = new ListNode(i);
            tail.next = newNode;
            tail = newNode;
        }
        TreeNode root = solution.sortedListToBST(head);
        assertThat(root).isNotNull();
    }

    @Property
    public void testRangeListTooLong(
            @ForAll
            @IntRange(min = 20_001, max = 999_999) int length
    ) {
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(-10);
        ListNode tail = head;
        for (int i = 1; i < length; i++) {
            ListNode newNode = new ListNode(i);
            tail.next = newNode;
            tail = newNode;
        }

        assertThatThrownBy(() -> {
            solution.sortedListToBST(head);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("List length must be smaller than 2 * 10^4");
    }

}

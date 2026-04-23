package zest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInArray {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 100_000;

    public List<Integer> findDuplicates(int[] nums) {
        validate(nums);

        int length = nums.length;
        // make a copy so we don't mutate the caller's array
        int[] snapshot = Arrays.copyOf(nums, length);
        int[] work = Arrays.copyOf(nums, length);

        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int index = Math.abs(work[i]) - 1;
            if (index < 0 || index >= length) {
                throw new IllegalArgumentException("Index at pos " + i + " not in valid range 0 ... " + length);
            }

            if (nums[index] < 1 || nums[index] > length) {
                throw new IllegalArgumentException(
                        "nums[" + index + "] must be in [1, " + length + "], got " + nums[index]);
            }

            if (work[index] < 0) {
                duplicates.add(Math.abs(work[i]));
            } else {
                work[index] = -work[index];
            }
        }

        if (duplicates.size() > length / 2) {
            throw new IllegalStateException(
                "Post-condition violated: duplicates.size() exceeds nums.length / 2");
        }

        if (!Arrays.equals(snapshot, nums)) {
            throw new IllegalStateException("Invariant violated: input array was mutated");
        }

        return duplicates;
    }

    private static void validate(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums array must not be null");
        }

        if (nums.length < MIN_LENGTH || nums.length > MAX_LENGTH) {
            throw new IllegalArgumentException(
                "nums length must be in [" + MIN_LENGTH + ", " + MAX_LENGTH + "], got " + nums.length);
        }
    }
}

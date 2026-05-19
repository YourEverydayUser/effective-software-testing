package zest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) throw new IllegalArgumentException("intervals must not be null");
        if (intervals.length > 10000) throw new IllegalArgumentException("intervals length must be in [0, 10^4]");
        for (int[] interval : intervals) {
            if (interval == null || interval.length != 2) throw new IllegalArgumentException("each interval must have exactly 2 elements");
            if (interval[0] > interval[1]) throw new IllegalArgumentException("start must be <= end");
        }

        if (intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
package common;

public class Range {
    public int from;
    public int to;

    public Range(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int size() {
        return to - from;
    }

    public static Range from(int[] arr) {
        return new Range(0, arr.length);
    }

    public Range subRangeTo(int to) {
        return new Range(from, absoluteIndex(to));
    }

    public Range subRangeFrom(int from) {
        return new Range(absoluteIndex(from), to);
    }

    public Range subRange(int from, int to) {
        return new Range(absoluteIndex(from), absoluteIndex(to));
    }

    public int absoluteIndex(int index) {
        return from + index;
    }

}

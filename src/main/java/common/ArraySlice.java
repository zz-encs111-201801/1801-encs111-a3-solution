package common;

import java.util.Iterator;

public class ArraySlice {
    private int[] arr;
    public Range range;

    public ArraySlice() {

    }

    public ArraySlice(ArraySlice slice) {
        this.arr = slice.arr;
        this.range = slice.range;
    }

    public static ArraySlice from(int[] arr) {
        ArraySlice slice = new ArraySlice();
        slice.arr = arr;
        slice.range = Range.from(arr);
        return slice;
    }

    public int size() {
        return range.size();
    }

    public int get(int index) {
        return arr[range.absoluteIndex(index)];
    }

    public void set(int index, int value) {
        arr[range.absoluteIndex(index)] = value;
    }

    public void fill(Iterable<Integer> values) {
        int index = 0;
        for (int value : values) {
            if (index >= size()) {
                break;
            }

            set(index, value);
            index += 1;
        }
    }

    public void swap(int index1, int index2) {
        int temp = get(index1);
        set(index1, get(index2));
        set(index2, temp);
    }

    public ArraySlice subSliceTo(int to) {
        ArraySlice slice = new ArraySlice(this);
        slice.range = slice.range.subRangeTo(to);
        return slice;
    }

    public ArraySlice subSliceFrom(int from) {
        ArraySlice slice = new ArraySlice(this);
        slice.range = slice.range.subRangeFrom(from);
        return slice;
    }

    public ArraySlice subSlice(int from, int to) {
        ArraySlice slice = new ArraySlice(this);
        slice.range = slice.range.subRange(from, to);
        return slice;
    }
}

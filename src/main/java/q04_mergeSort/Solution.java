package q04_mergeSort;

import common.ArraySlice;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public void mergeSort(int[] arr) {
        ArraySlice slice = ArraySlice.from(arr);
        LinkedList<Integer> sorted = mergeSort(slice);
        slice.fill(sorted);
    }

    private LinkedList<Integer> mergeSort(ArraySlice slice) {

        // base cases
        if (slice.size() == 0) {
            return new LinkedList<>();
        }

        if (slice.size() == 1) {
            LinkedList<Integer> list = new LinkedList<>();
            list.addLast(slice.get(0));
            return list;
        }

        // partition
        int mid = slice.range.size() / 2;
        LinkedList<Integer> leftList = mergeSort(slice.subSliceTo(mid));
        LinkedList<Integer> rightList = mergeSort(slice.subSliceFrom(mid));

        // combine
        return merge(leftList, rightList);
    }

    private LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> list = new LinkedList<>();

        while (!list1.isEmpty() && !list2.isEmpty()) {
            LinkedList<Integer> selectedList = list1.getFirst() < list2.getFirst() ? list1 : list2;
            list.addLast(selectedList.removeFirst());
        }
        list.addAll(list1);
        list.addAll(list2);
        return list;
    }
}

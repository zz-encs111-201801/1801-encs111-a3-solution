package q02_quickSelect;

import common.ArraySlice;

public class Solution {
    public int getAtRank(int[] arr, int rank){
        if (arr.length == 0) {
            return -1;
        }

        return getAtRank(ArraySlice.from(arr), rank);
    }

    private int getAtRank(ArraySlice slice, int rank) {
        if (slice.size() == 1) {
            return slice.get(0);
        }

        int pivotIndex = partition(slice);
        if (pivotIndex == rank) {
            return slice.get(rank);

        } else if (pivotIndex > rank) {
            ArraySlice subSlice = slice.subSliceTo(pivotIndex);
            int subRank = rank;
            return getAtRank(subSlice, subRank);

        } else {
            ArraySlice subSlice = slice.subSliceFrom(pivotIndex + 1);
            int subRank = rank - pivotIndex - 1;
            return getAtRank(subSlice, subRank);
        }
    }

    private int partition(ArraySlice slice) {
        int pivot = slice.get(0);

        int j = 0;
        for (int i = 1; i < slice.size() ; i++) {
            int value = slice.get(i);

            if ( value < pivot ) {
                j += 1;
                slice.swap(i, j);
            }
        }

        slice.swap(0, j);

        return j;
    }
}

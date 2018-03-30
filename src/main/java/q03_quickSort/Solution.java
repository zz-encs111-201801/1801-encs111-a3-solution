package q03_quickSort;

import common.ArraySlice;

public class Solution {
    public void quickSort(int[] arr) {
        ArraySlice slice = ArraySlice.from(arr);
        quickSort(slice);
    }

    private void quickSort(ArraySlice slice) {
        if (slice.size() <= 1) {
            return;
        }

        int pivotIndex = partition(slice);
        ArraySlice leftSlice = slice.subSliceTo(pivotIndex);
        ArraySlice rightSlice = slice.subSliceFrom(pivotIndex + 1);
        quickSort(leftSlice);
        quickSort(rightSlice);
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


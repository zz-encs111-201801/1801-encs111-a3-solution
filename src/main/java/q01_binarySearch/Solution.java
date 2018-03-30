package q01_binarySearch;

public class Solution {
    public boolean contains(int[] arr, int value){

        // special case
        if (arr.length == 0) {
            return false;
        }

        // oop
        this.arr = arr;
        this.value = value;

        // initial call
        return contains(0, arr.length);
    }

    private int[] arr;
    private int value;

    private boolean contains(int fromIndex, int toIndex) {

        // base case
        if (toIndex <= fromIndex) {
            return false;
        }

        int middleIndex = (toIndex + fromIndex) / 2;

        int middleValue = arr[middleIndex];
        if (middleValue == value) {
            return true;
        }

        if (value > middleValue) {
            return contains(middleIndex + 1, toIndex);
        } else {
            return contains(fromIndex, middleIndex);
        }
    }
}

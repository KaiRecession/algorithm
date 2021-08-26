package binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,99};
        BinarySearch binarySearch = new BinarySearch();

        System.out.println(binarySearch.binarySearch(nums, 3));
    }
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 这个等于号、减一、加一三个就是灵魂啊！
        while (left <= right) {
            int mid = nums[(left+right)/2];
            if (mid == target) {
                return (left+right)/2;
            }else if (mid > target) {
                right = (left+right)/2-1;
            }else {
                left = (left+right)/2+1;
            }
        }
        return -1;
    }
}

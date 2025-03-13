class Solution {

    public int maximumCount(int[] nums) {
        int negCount = binarySearchFirstZero(nums); 
        int posCount = nums.length - binarySearchFirstPositive(nums); 
        return Math.max(negCount, posCount);
    }
    private static int binarySearchFirstZero(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) left = mid + 1;
            else right = mid;
        }
        return left; 
    }

    private static int binarySearchFirstPositive(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
       int left = 0, right = queries.length, ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeZero(nums.clone(), queries, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }   
    private boolean canMakeZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        
        for (int i = 0; i < k; i++) {
            int li = queries[i][0], ri = queries[i][1], vali = queries[i][2];
            diff[li] -= vali;
            if (ri + 1 < n) diff[ri + 1] += vali;
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            nums[i] += sum;
            if (nums[i] > 0) return false;
        }
        
        return true;
    }
}
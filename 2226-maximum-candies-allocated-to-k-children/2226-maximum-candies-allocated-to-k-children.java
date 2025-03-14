class Solution {
    public int maximumCandies(int[] candies, long k) {
        long total = 0;
        for (int candy : candies) {
            total += candy;
        }
        if (total < k) return 0;
        int left = 1, right = Arrays.stream(candies).max().getAsInt();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long count = 0;

            for (int candy : candies) {
                count += candy / mid;
            }

            if (count >= k) {
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }
        return right;
        
    }
}
class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] a = {-1,-1};
        int min = 1000001;
        boolean []prime =  new boolean[right-left+1];

        for(int i = left; i<=right; i++) prime[i-left] = true;

        for(int i = 2; i<=Math.sqrt(right); i++){
                for(int j = Math.max(i*i, (left + i -1)/i*i); j<=right; j+=i){
                prime[j-left] = false;
                }
        }
        int prev = -1;
        for(int i = Math.max(2, left); i<=right; i++){
                if(prime[i -left]){
                    if(prev != -1 && (i-prev)<min){
                    min = i - prev;
                    a[0] = prev;
                    a[1] = i;
                }
                prev = i;
            }
            
        }
        return a;
    }
}
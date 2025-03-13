class Solution {
    public double e(int[] points){
        return Math.sqrt(points[0]*points[0]+ points[1]*points[1]);
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] a = new int[k][2];

        for(int i = 0; i < k;i++){
           a[i] = points[i];
        }
        
        for(int i = k ; i < points.length; i++){
            for(int j = 0; j<k;j++){
                if(e(points[i])<e(a[j])){
                    int x = a[j][0];
                    int y = a[j][1];
                    a[j][0] = points[i][0];
                    a[j][1] = points[i][1];
                    points[i][0] = x;
                    points[i][1] = y;
                }
            }
        }
        return a;
    }
}
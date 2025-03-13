class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> na = new ArrayList<>();
        int[] temp = new int[1001];
        Arrays.fill(temp, 0);
        for(int i = 0; i< nums.length; i++){
            for(int j = 0; j<nums[i].length; j++){
                temp[nums[i][j]]++;
            }
        }
        for(int i = 0; i< 1001; i++){
            if(temp[i] == nums.length){
                na.add(i);
            }
        }
        return na;
    }
}
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int c = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i< colors.length - 1; i++){
            if(colors[i] == colors[i+1]) deque.offer(i);
        }
        if(colors[colors.length-1] == colors[0]) deque.offer(colors.length-1);
        if(!deque.isEmpty()){
            int conlai = colors.length - (deque.peekLast() + 1);
            boolean start = true;
            int prev = -1;
            while(!deque.isEmpty()){
                int current = deque.poll();
                if(start){
                    if(current-prev + conlai >= k){
                        c+=current-prev + conlai - k +1 ;
                    }
                    start = false;
                }else{
                    if(current-prev >= k){
                        c+=current-prev - k+1;
                    }
                }
                prev = current;
            }
        }else{
            c+=colors.length;
        }
        
        return c;
    }
}
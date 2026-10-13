class BusBooking {
    int n;
    boolean arr[][];
    int cost[][];
    int curr;
    int count;
    public BusBooking(int n) {
        this.n = n;
        arr = new boolean[n][4];
        for(int i = 0;i<n;i++)
            Arrays.fill(arr[i],false);
        cost = new int[n][4];
        curr = 0;
        count = 0;
    }
    
    public void toggle(String seat) {
        int c = 0;
        if(seat.charAt(0)=='A')
            c = 0;
        else if(seat.charAt(0)=='B')
            c = 1;
        else if(seat.charAt(0)=='C')
            c = 2;
        else
            c = 3;
        int r = Integer.valueOf(seat.substring(1,seat.length()))-1;
        if(c==1 || c==2){
            if(arr[r][c]){
                curr = curr - cost[r][c];
                cost[r][c] = 0;
                arr[r][c] = false;
                count--;
            }
            else{
                curr = curr + 1;
                cost[r][c] = 1;
                arr[r][c] = true;
                count++;
            }
        }
        else{
            if(c==0){
                if(arr[r][c]==false){
                    if(arr[r][c+1]){
                        curr = curr + 3;
                        cost[r][c] = 3;
                        arr[r][c] = true;
                        count++;
                    }
                    else{
                        curr = curr + 1;
                        cost[r][c] = 1;
                        arr[r][c] = true;
                        count++;
                    }
                }
                else{
                    curr = curr - cost[r][c];
                    cost[r][c] = 0;
                    arr[r][c] = false;
                    count--;
                }
            }
            else{
                if(arr[r][c]==false){
                    if(arr[r][c-1]){
                        curr = curr + 3;
                        cost[r][c] = 3;
                        arr[r][c] = true;
                        count++;
                    }
                    else{
                        curr = curr + 1;
                        cost[r][c] = 1;
                        arr[r][c] = true;
                        count++;
                    }
                }
                else{
                    curr = curr - cost[r][c];
                    cost[r][c] = 0;
                    arr[r][c] = false;
                    count--;
                }
            }
        }
    }
    
    public int getTotalTime() {
        return curr;
    }
    
    public int getMinTime() {
        return count;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */
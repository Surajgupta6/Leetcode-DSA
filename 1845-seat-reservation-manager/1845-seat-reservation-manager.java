class SeatManager {
    PriorityQueue<Integer> minHeap;
    int size;
    int current = 1;
    public SeatManager(int n) {
        this.minHeap = new PriorityQueue<>();
        this.size=n;
    }
    
    public int reserve() {
        if(!minHeap.isEmpty()){
            return minHeap.poll();
        }
        int value = current;
        current++;
        return value;
    }
    
    public void unreserve(int seatNumber) {
        minHeap.offer(seatNumber);
        return ;
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
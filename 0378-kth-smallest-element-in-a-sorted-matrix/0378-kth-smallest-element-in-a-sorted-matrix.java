class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.offer(new int[] { 0, 0, matrix[0][0] });
        matrix[0][0] = -1;
        int result = -1;
        while (k > 0) {
            int[] top = minHeap.poll();
            int currRow = top[0];
            int currCol = top[1];
            result = top[2];
            if (currRow + 1 < n && matrix[currRow + 1][currCol] != -1) {
                minHeap.offer(new int[] { currRow + 1, currCol, matrix[currRow + 1][currCol] });
                matrix[currRow + 1][currCol] = -1;
            }
            if (currCol + 1 < n && matrix[currRow][currCol + 1] != -1) {
                minHeap.offer(new int[] { currRow, currCol + 1, matrix[currRow][currCol + 1] });
                matrix[currRow][currCol + 1] = -1;
            }
            k--;
        }
        return result;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        List<Integer> list = new ArrayList<>();
        int[] freq = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }
        while (!pq.isEmpty()) {

            int size = pq.size();
            List<int[]> temp = new ArrayList<>();
            boolean executed = false;
            for (int i = 0; i < size; i++) {
                int[] top = pq.poll();
                int start = Math.max(0, list.size() - n);
                boolean blocked = false;
                for (int j = start; j < list.size(); j++) {
                    if (top[0] == list.get(j)) {
                        blocked = true;
                        break;
                    }
                }
                if (!blocked) {
                    list.add(top[0]);
                    top[1]--;
                    if (top[1] > 0) {
                        temp.add(top);
                    }
                    executed = true;
                    break;
                }
                temp.add(top);
            }
            for (int[] task : temp) {
                pq.offer(task);
            }
            if (!executed) {
                list.add(-1);
            }
        }

        return list.size();
    }
}
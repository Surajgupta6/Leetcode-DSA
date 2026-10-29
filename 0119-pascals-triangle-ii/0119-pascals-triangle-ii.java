class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0)
            return new ArrayList(List.of(1));
        if (rowIndex == 1)
            return new ArrayList(List.of(1, 1));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            result.add(1);
        }
        int i = 2;
        while (i <= rowIndex) {
            for (int j = i-1; j > 0; j--) {
                int first = result.get(j-1);
                int second = result.get(j);
                int newValue = first + second;
                result.set(j, newValue);
            }
            i++;
        }
        return result;
    }
}
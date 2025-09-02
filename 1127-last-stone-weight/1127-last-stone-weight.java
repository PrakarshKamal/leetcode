class Solution {
    public int lastStoneWeight(int[] stones) {
        
        List<Integer> arr = new ArrayList<>();
        for (int stone : stones) {
            arr.add(stone);
        }

        while (arr.size() > 1) {
            Collections.sort(arr, Collections.reverseOrder());

            int y = arr.remove(0); // largest
            int x = arr.remove(0); // next largest
            int curr = y - x;

            if (curr != 0) {
                arr.add(curr);
            }
        }
        
        if (arr.isEmpty()) {
            return 0;
        }
        return arr.get(0);
    }
}
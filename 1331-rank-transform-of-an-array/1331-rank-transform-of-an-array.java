//TC: O(n log n)
//SC: O(n)

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int n = arr.length;
        
        int[] temp = Arrays.copyOf(arr, n); // O(n)
        
        Map<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(temp); // O(n log n)
        
        // temp = reverse(temp);
        
        int rank = 1;
        for (int num : temp) { // O(n)
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }
    
//     private int[] reverse(int[] arr) {
//         int start = 0;
//         int end = arr.length - 1;
        
//         while (start < end) {
//             int temp = arr[start];
//             arr[start] = arr[end];
//             arr[end] = temp;
            
//             start++;
//             end--;
//         }
//         return arr;
//     }
}
// O(n) time, O(1) space
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < n; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (gasSum < costSum) return -1; // not possible
        
        int total = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            total = total + gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                start = i+1;
            }
        }
        return start;
    }
}
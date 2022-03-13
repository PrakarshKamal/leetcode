class Solution {
    
    int result = 0;
    
    public int countArrangement(int n) {
        
        int[] perm = new int[n+1];
        
        evalArrangements(perm, 1, n);
        
        return result;
    }
    
    private void evalArrangements(int[] perms, int index, int n) {
        
        // base case
        if (index == perms.length) {
            result++;
            return;
        }
        
        for (int i = 1; i <= perms.length-1; i++) {
            
            // action
            if (perms[i] == 0 && (i % index == 0 || index % i == 0)) {
                perms[i] = 1; // appending
                
                // recurse
                evalArrangements(perms, index+1, n);
                
                // backtrack
                perms[i] = 0; // removing
            }
        }
    }
}
class Solution {
    // Using Queue, O(n^2) worst case, O(n) space
    public int countStudents(int[] students, int[] sandwiches) {
        // Queue<Integer> q = new LinkedList<>();

        // for (int student : students) {
        //     q.offer(student);
        // }

        // int count = 0;
        // int i = 0;
        // while (!q.isEmpty() && count < q.size()) {
        //     if (q.peek() == sandwiches[i]) {
        //         q.poll();
        //         i++;
        //         count = 0;
        //     }
        //     else {
        //         q.offer(q.poll());
        //         count++;
        //     }
        // }
        // return q.size();

        // Counting approach, O(n) time, O(1) space
        int zeroCount = 0;
        int oneCount = 0;

        for (int student : students) {
            if (student == 0) {
                zeroCount++;
            }
            else {
                oneCount++;
            }
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (zeroCount == 0) {
                    return oneCount;
                }
                else {
                    zeroCount--;
                }
            }
            else {
                if (oneCount == 0) {
                    return zeroCount;
                }
                else {
                    oneCount--;
                }
            }
        }
        return 0;
    }
}
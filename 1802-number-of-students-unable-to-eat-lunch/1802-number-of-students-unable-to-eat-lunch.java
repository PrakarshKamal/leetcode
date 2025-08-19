class Solution {
    // Using Queue, O(n^2) worst case, O(n) space
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();

        for (int student : students) {
            q.offer(student);
        }

        int count = 0;
        int i = 0;
        while (!q.isEmpty() && count < q.size()) {
            if (q.peek() == sandwiches[i]) {
                q.poll();
                i++;
                count = 0;
            }
            else {
                q.offer(q.poll());
                count++;
            }
        }
        return q.size();
    }
}
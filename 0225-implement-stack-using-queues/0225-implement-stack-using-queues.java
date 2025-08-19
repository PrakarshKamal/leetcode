class MyStack {

    // Two Queue approach O(n) push, O(1) pop, top for time, O(n) space
    // Queue<Integer> q1;
    // Queue<Integer> q2;

    // public MyStack() {
    //     q1 = new LinkedList<>();
    //     q2 = new LinkedList<>();
    // }
    
    // public void push(int x) {
    //     while (!q1.isEmpty()) {
    //         q2.offer(q1.poll());
    //     }

    //     q1.offer(x);

    //     while (!q2.isEmpty()) {
    //         q1.offer(q2.poll());
    //     }
    // }
    
    // public int pop() {
    //     int x = q1.poll();
    //     return x;
    // }
    
    // public int top() {
    //     int x = q1.peek();
    //     return q1.peek();
    // }
    
    // public boolean empty() {
    //     return q1.isEmpty() && q2.isEmpty();
    // }

    // One Queue approach, O(n) for push, O(1) pop, top time, O(n) space
    Queue<Integer> q1;

    public MyStack() {
        q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
        for (int i = 0; i < q1.size() - 1; i++) {
            q1.offer(q1.poll());
        }
    }
    
    public int pop() {
        int x = q1.poll();
        return x;
    }
    
    public int top() {
        int x = q1.peek();
        return x;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
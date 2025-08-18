class ListNode {
    String val;
    ListNode next;
    ListNode prev;

    public ListNode(String val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    public ListNode(String val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class BrowserHistory {

    ListNode curr;

    public BrowserHistory(String homepage) {
        curr = new ListNode(homepage);
    }
    
    public void visit(String url) {
        curr.next = new ListNode(url, null, curr);
        curr = curr.next;
    }
    
    public String back(int steps) {
        while (curr.prev != null && steps > 0) {
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        while (curr.next != null && steps > 0) {
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
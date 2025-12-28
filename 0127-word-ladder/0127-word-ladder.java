class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        // beginWord should be there in graph
        wordList.add(beginWord);
        int n = wordList.size();

        // Build graph
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isConnected(wordList.get(i), wordList.get(j))) {
                    graph.computeIfAbsent(wordList.get(i), value -> new ArrayList<>()).add(wordList.get(j));
                    graph.computeIfAbsent(wordList.get(j), value -> new ArrayList<>()).add(wordList.get(i));
                }
            }
        }
        // BFS
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(beginWord, 1));
        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            String curr = q.peek().getKey();
            int level = q.peek().getValue();
            q.poll();

            if (curr.equals(endWord)) {
                return level;
            }

            for (String word : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(word)) {
                    visited.add(word);
                    q.offer(new Pair<>(word, level+1));
                }
            }
        }
        return 0;
    }
    public boolean isConnected(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
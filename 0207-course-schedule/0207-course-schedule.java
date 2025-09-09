class Solution {
    
    Map<Integer, List<Integer>> map = new HashMap<>(); // course -> prereq[] map
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // initially setting to empty lists
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        // building the adj list
        for (int[] prereq : prerequisites) {
            int src = prereq[0];
            int dst = prereq[1];
            map.get(src).add(dst);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) {
            return false; // cycle detected since course already in set
        }

        if (map.get(course).isEmpty()) {
            return true;
        }

        visited.add(course);

        for (int prereq : map.get(course)) {
            if (!dfs(prereq)) {
                return false; // if we find a course which can't be completed, return false
            }
        }

        visited.remove(course); // course can be taken but remove from set as we have already visited it
        map.put(course, new ArrayList<>());
        return true;
    }
}
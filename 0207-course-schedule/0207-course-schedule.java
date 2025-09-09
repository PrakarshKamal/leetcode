class Solution {
    
    Map<Integer, List<Integer>> map = new HashMap<>(); // course -> prereq[] map
    Set<Integer> visiting = new HashSet<>(); // nodes in current DFS path
    Set<Integer> visited = new HashSet<>(); // nodes already processed

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
        if (visiting.contains(course)) {
            return false; // cycle detected since course already in set
        }
        if (visited.contains(course)) {
            return true; // already checked that course can be completed
        }

        visiting.add(course);

        for (int prereq : map.get(course)) {
            if (!dfs(prereq)) {
                return false; // if we find a course which can't be completed, return false
            }
        }

        visiting.remove(course); // course can be taken but remove from set as we have already visited it
        visited.add(course); // add to visited confirming we can take this course
        return true;
    }
}
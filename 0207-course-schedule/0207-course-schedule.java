// class Solution {
//     // DFS O(V + E) time, O(V + E) space
//     Map<Integer, List<Integer>> map = new HashMap<>(); // course -> prereq[] map
//     Set<Integer> visiting = new HashSet<>(); // nodes in current DFS path
//     Set<Integer> visited = new HashSet<>(); // nodes already processed

//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         // initially setting to empty lists
//         for (int i = 0; i < numCourses; i++) {
//             map.put(i, new ArrayList<>());
//         }

//         // building the adj list
//         for (int[] prereq : prerequisites) {
//             int src = prereq[0];
//             int dst = prereq[1];
//             map.get(src).add(dst);
//         }

//         for (int course = 0; course < numCourses; course++) {
//             if (!dfs(course)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private boolean dfs(int course) {
//         if (visiting.contains(course)) {
//             return false; // cycle detected since course already in set
//         }
//         if (visited.contains(course)) {
//             return true; // already checked that course can be completed
//         }

//         visiting.add(course);

//         for (int prereq : map.get(course)) {
//             if (!dfs(prereq)) {
//                 return false; // if we find a course which can't be completed, return false
//             }
//         }

//         visiting.remove(course); // course can be taken but remove from current dfs path
//         visited.add(course); // add to visited confirming we can take this course
//         return true;
//     }
// }

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        // build adj list
        for (int[] prereq : prerequisites) {
            int src = prereq[0];
            int dest = prereq[1];
            graph.get(src).add(dest);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!dfs(i, numCourses, graph, visiting, visited)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int curr, int numCourses, Map<Integer, List<Integer>> graph, boolean[] visiting, boolean[] visited) {
        visiting[curr] = true;

        for (int neighbor : graph.get(curr)) {
            if (visiting[neighbor]) {
                return false;
            }
            if (!visited[neighbor]) {
                if(!dfs(neighbor, numCourses, graph, visiting, visited)) {
                    return false;
                }
            }
        }
        visiting[curr] = false;
        visited[curr] = true;
        return true;
    }
}
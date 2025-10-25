// Last updated: 10/25/2025, 12:07:09 AM
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Set<Node> visitedNode = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visitedNode.add(node);
        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();
            Node clonedNode = new Node(pollNode.val);
            map.put(pollNode, clonedNode);
            List<Node> thisNeighbors = pollNode.neighbors;
            for (Node neighbor : thisNeighbors) {
                if (!visitedNode.contains(neighbor)) {
                    visitedNode.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        for (Node thisNode : visitedNode) {
            for (Node neighbor : thisNode.neighbors) {
                map.get(thisNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
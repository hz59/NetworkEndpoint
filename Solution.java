import java.util.*;
import java.io.*;
import java.math.*;
import java.util.HashMap;

class Solution {

    static HashMap<String, Solution> nodes = new HashMap<>();
    int nodeIndex;
    Solution nextNode;

    public int getNodeIndex() {
      return this.nodeIndex;
    }

    public void setNodeIndex(int nodeIndex) {
      this.nodeIndex = nodeIndex;
    }

    public Solution getNextNode() {
      return this.nextNode;
    }

    public void setNextNode(Solution nextNode) {
      this.nextNode = nextNode;
    }

    public static int findNetworkEndpoint(int startNodeId, int[] fromIds, int[] toIds) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
       for (Integer fromId : fromIds) {
      if (nodes.get(String.valueOf(fromId)) == null && fromId != null) {
        Solution node = new Solution();
        node.setNodeIndex(fromId);
        nodes.put(String.valueOf(fromId), node);
      }
    }

    for (Integer toId : toIds) {
      if (nodes.get(String.valueOf(toId)) == null && toId != null) {
        Solution node = new Solution();
        node.setNodeIndex(toId);
        nodes.put(String.valueOf(toId), node);
      }
    }

    int i = 0;
    for (Integer fromId : fromIds) {
      if (toIds[i] != 0) {
        nodes.get(String.valueOf(fromId)).setNextNode(nodes.get(String.valueOf(toIds[i])));
      }
      i++;
    }

    Solution finalNode = nodes.get(String.valueOf(startNodeId));
    while (finalNode.getNextNode() != null) {
      if (finalNode.getNextNode() != null
          && finalNode.getNextNode().getNodeIndex() == startNodeId) {
        break;
      }
      finalNode = finalNode.getNextNode();
    }

    return finalNode.getNodeIndex();
  }

    /* Ignore and do not change the code below */
    // #region main
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int startNodeId = in.nextInt();
        int n = in.nextInt();
        int[] fromIds = new int[n];
        for (int i = 0; i < n; i++) {
            fromIds[i] = in.nextInt();
        }
        int[] toIds = new int[n];
        for (int i = 0; i < n; i++) {
            toIds[i] = in.nextInt();
        }
        PrintStream outStream = System.out;
        System.setOut(System.err);
        int endPointId = findNetworkEndpoint(startNodeId, fromIds, toIds);
        System.setOut(outStream);
        System.out.println(endPointId);
    }
    // #endregion
}

import java.util.*;
class TreeNode{
  TreeNode left;
  TreeNode right;
  int val;
  TreeNode(int x){
    val = x;
    left = null;
    right = null;
  }
}
class Pair{
  int level;
  TreeNode node;
  Pair(TreeNode root, int x){
    node = root;
    level = x;
  } 
}
class Main{
  /*
    have a queue with pair type consists of index, treeNode. Have a HashMap to add/update the index(level) against arralist of nodes based on level.
    each time peek eleement will remove from queue and it's left and right added.
    keep and update minLevel and maxLevel each iteration until queue size becomes 0.
    travel over minL & maxL in hashMap and get them in the order.
  */
  static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root){
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    Queue<Pair> q = new LinkedList<>();
    q.offer(new Pair(root, 0));
    HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
    int minL = 0, maxL =0;
    while(q.size() > 0){
      Pair front = q.peek();
      q.poll();
      TreeNode node = front.node;
      int level = front.level;
      minL = Math.min(minL, level);
      maxL = Math.max(maxL, level);
      if(!hm.containsKey(level)){
        hm.put(level, new ArrayList<Integer>());
      }
        hm.get(level).add(node.val);
      if(node.left != null){
        q.offer(new Pair(node.left, level-1));
      }
      if(node.right != null){
        q.offer(new Pair(node.right, level+1));
      }
      }
    for(int i=minL; i<=maxL; i++){
        if(hm.containsKey(i)){
          result.add(hm.get(i));
        }
    }
    return result;
  }
  public static void main(String[] args){
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(6);
    ArrayList<ArrayList<Integer>> result = verticalOrderTraversal(root);
    System.out.print(result);
  }
}

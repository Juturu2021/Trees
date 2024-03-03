import java.util.*;
class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x){
    val = x;
    left = null;
    right = null;
  }
}
class Main{
  static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A){
    //printing or adding the elements using pre order traversal
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(A);
    while(q.size()>0){
      ArrayList<Integer> list = new ArrayList<>();
      int n = q.size();
      for(int i=0; i<n; i++){
        TreeNode front = q.peek();
        q.poll();
        list.add(front.val);
        if(front.left != null){
          q.offer(front.left);
        }
        if(front.right != null){
          q.offer(front.right);
        }
      }
      result.add(list); 
    }
    return result;
  }
  public static void main(String[] args){
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(6);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(3);
      
      ArrayList<ArrayList<Integer>> result = levelOrder(root);
      
      System.out.println(result);
  }
}

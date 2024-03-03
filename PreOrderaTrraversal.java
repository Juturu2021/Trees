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
class PreOrderTraversal{
  static void preOrder(TreeNode root, ArrayList<Integer> result){
    if(root == null){
      return;
    }
    result.add(root.val);
    preOrder(root.left, result);
    preOrder(root.right, result);
  }
  static ArrayList<Integer> preOrderTraversal(TreeNode root){
    ArrayList<Integer> result = new ArrayList<>();
    preOrder(root, result);
    return result;
  }
  public static void main(String[] args){
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    ArrayList<Integer> preOrderResult = preOrderTraversal(root);
    System.out.println("Pre order Traversal:" +  preOrderResult);
    //output : Pre order Traversal:" +  [1,2,3]
  }
}

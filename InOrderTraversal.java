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
class InOrderTraversal{
  static void inOrder(TreeNode root, ArrayList<Integer> result){
    if(root == null){
      return;
    }
    inOrder(root.left, result);
    result.add(root.val);
    inOrder(root.right, result);
  }
  static ArrayList<Integer> inOrderTraversal(TreeNode root){
    ArrayList<Integer> result = new ArrayList<>();
    inOrder(root, result);
    return result;
  }
  public static void main(String[] args){
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    ArrayList<Integer> inOrderResult = inOrderTraversal(root);
    System.out.println("The inorder output is:" + inOrderResult);
    //output: The inorder output is:" [2,1,3]
  }
}

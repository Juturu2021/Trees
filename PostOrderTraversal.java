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
class Pair{
  TreeNode node;
  int task;
  Pair(TreeNode root){
    node = root;
    task =1;
  }
}

class Main{
  static ArrayList<Integer> postOrderTraversal(TreeNode root){
    ArrayList<Integer> result = new ArrayList<>();
    Stack<Pair> st = new Stack<>();
    Pair p = new Pair(root);
    st.push(p);

    while(st.size()>0){
      Pair top = st.peek();
      if(top.task ==1){
        top.task++;
        if(top.node.left != null){
            Pair temp = new Pair(top.node.left);
            st.push(temp);
        }
      }
      else if(top.task ==2){
        top.task++;
        if(top.node.right != null){
            Pair temp = new Pair(top.node.right);
            st.push(temp);
        }
      }
      else if(top.task == 3){
        top.task++;
        result.add(top.node.val);
      }
      else{
        st.pop();
      }
    }
    return result;
  }
  public static void main(String[] args){
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    ArrayList<Integer> postOrderresult = postOrderTraversal(root);
    System.out.println("The post order traversal is:" + postOrderresult);
  }
}

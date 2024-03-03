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
  static TreeNode helper(ArrayList<Integer> inOrder, int iStart, int iEnd, ArrayList<Integer> postOrder, int pStart, int pEnd, HashMap<Integer, Integer> hm){
      if(iStart > iEnd || pStart > pEnd){
      return null;
    }
    int rootData = postOrder.get(pEnd);
    TreeNode root = new TreeNode(rootData);
    int rootIndex = hm.get(rootData);
    int leftElementsList = rootIndex - iStart;
    root.left = helper(inOrder, iStart, rootIndex-1, postOrder, pStart, leftElementsList+pStart-1, hm);
    root.right = helper(inOrder, rootIndex+1, iEnd, postOrder, leftElementsList+pStart, pEnd-1, hm);
    return root;
  }
  static void printPreorder(TreeNode node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.val + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }
  public static void main(String[] args){
    ArrayList<Integer> list1 = new ArrayList<>();
    list1.add(6);
    list1.add(1);
    list1.add(3);
    list1.add(2);

    ArrayList<Integer> list2 = new ArrayList<>();
    list2.add(6);
    list2.add(3);
    list2.add(2);
    list2.add(1);

    int iStart = 0;
    int iEnd = list1.size()-1;
    int pStart = 0;
    int pEnd = list2.size()-1;

    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i=0; i<list1.size(); i++){
      hm.put(list1.get(i), i);
    }
    TreeNode result = helper(list1, iStart, iEnd, list2, pStart, pEnd, hm);
    System.out.print("The output is:  ");
    printPreorder(result);
  }
}

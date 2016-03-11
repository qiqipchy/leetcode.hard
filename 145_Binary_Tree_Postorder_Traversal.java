import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null)
			return list;
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode parent = stack.peek();
			if (parent.left == null) {
				if (parent.right == null)
					list.add(stack.pop().val);
				else {
					stack.push(parent.right);
					parent.right = null;
				}
			} else {
				stack.push(parent.left);
				parent.left = null;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode root = new TreeThing().buildTree(null, nums);
		System.out.println(new Solution().postorderTraversal(root));
	}
}

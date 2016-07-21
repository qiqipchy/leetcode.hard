import java.util.LinkedList;
import java.util.Queue;

public class Codec {

	// Encodes a tree to a single string.
	// 倒过来的过程；
	public String serialize(TreeNode root) {
		long time = System.currentTimeMillis();
		if (root == null)
			return "";
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<String> res = new LinkedList<String>();
		queue.add(root);
		res.add(String.valueOf(root.val));
		TreeNode parent;
		String string = "";

		while (!queue.isEmpty()) {

			if (res.peek().equals("null")) {
				string += "null,";
				res.poll();
				continue;
			}
			string += res.poll() + ",";
			parent = queue.poll();
			if (parent.left != null) {
				queue.add(parent.left);
				res.add(String.valueOf(parent.left.val));
			} else
				res.add("null");
			if (parent.right != null) {
				queue.add(parent.right);
				res.add(String.valueOf(parent.right.val));
			} else
				res.add("null");
		}
		System.out.println(string);
		System.out.println(System.currentTimeMillis() - time + "ser");
		return string;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.length() == 0)
			return null;
		if (!data.contains(","))
			return new TreeNode(Integer.parseInt(data));

		long time = System.currentTimeMillis();
		TreeNode root = null;
		String[] datas = data.split(",");
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		root = new TreeNode(Integer.parseInt(datas[0]));
		queue.add(root);
		TreeNode parent = null;

		int i = 1;
		// 注意这里的条件，当然还是使用queue队列，但是需要注意跟遍历的区别;
		//这里的先决条件是数据的长度；
		while (i < datas.length) {
			parent = queue.poll();
			if (i < datas.length && !datas[i].equals("null")) {
				TreeNode left = new TreeNode(Integer.parseInt(datas[i++]));
				parent.left = left;
				queue.add(left);
			} else
				i++;
			if (i < datas.length && !datas[i].equals("null")) {
				TreeNode right = new TreeNode(Integer.parseInt(datas[i++]));
				parent.right = right;
				queue.add(right);
			} else
				i++;
		}
		System.out.println(System.currentTimeMillis() - time + "des");
		return root;
	}
}

public class BST {
	// search in bst
	// recursive way of search in bst
	public TreeNode searchBstRecur(TreeNode root, int target) {
	  //based case and terminal condition
	  if (root == null || root.key == target) {
	    return root;
	  }
	  if (root.key < target) {
		return searchBstRecur(root.right, target);
	  } else {
		return searchBstRecur(root.left, target);
	  }
	}
	// iterative
	public TreeNode searchBstIter(TreeNode root, int target) {
		TreeNode cur = root;
		// cur!= null || cur.key != target combine corner case checking 
		// with terminal condition together, created a very elegant syntax.
		while (cur != null || cur.key != target) {
			if (cur.key < target) {
				cur = cur.right;
			} else {
				cur = cur.left;
			}
		}
		return cur;
	}
	// insert in bst
	// insert recursively
	public TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			TreeNode newNode = new TreeNode(key);
			return newNode;
		}
		if (root.key < key) {
			root.right = insert(root.right, key);
		} else if (root.key > key) {
			root.left = insert(root.left, key);
		}
		return root;
	}
	// insert iteratively
	public TreeNode insertIter(TreeNode root, int key){
		if (root == null){
			return new TreeNode(key);
		}
		TreeNode pre = null;
		TreeNode cur = root;
		while (cur != null) {
			pre = cur;
			if (cur.key < key) {
				cur = cur.right;
			} else if (cur.key > key){
				cur = cur.right;
			} else {
				return root;
			}
		}
		// post processing.
		if (pre.key < key) {
			pre.right = new TreeNode(key);
		} else if (pre.key > key) {
			pre.left = new TreeNode(key);
		}
    return root;
	}
}

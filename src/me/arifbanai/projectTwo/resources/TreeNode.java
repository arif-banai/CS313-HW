package me.arifbanai.projectTwo.resources;

public class TreeNode<K extends Comparable<K>, V> {
	public K key;
	public V val;

	public TreeNode<K, V> left;
	public TreeNode<K, V> right;

	public int sizeOfLeftSubTree;
	public int sizeOfRightSubTree;

	public TreeNode() {
		key = null;
		val = null;
		left = null;
		right = null;
	}

	public TreeNode(K key, V val) {
		this.key = key;
		this.val = val;
		this.left = null;
		this.right = null;
	}

	public TreeNode(K key, V val, TreeNode<K, V> left, TreeNode<K, V> right) {
		this.key = key;
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public void insert(K key, V val) {
		if(key == this.key) {
			//Ignore duplicates
			return;
		}
		
		//If the node to be added should be the left child and there is none, then add it there
		//If it should be the right child and there is none, then add it there
		//If it cannot be placed in the correct spot, traverse deeper into the correct subtree
		if(key.compareTo(this.key) < 0) {
			
			//This ensures the node updates its subtree size
			// in case the node to be added must be placed deeper in the tree
			//This can only be done if duplicates are not even a possibility.
			//This can be broken if a duplicate is attempted to be placed
			this.sizeOfLeftSubTree++;
			
			if(left == null) {
				left = new TreeNode<K,V>(key, val);
				return;
			}
			
			left.insert(key, val);
		} else if(key.compareTo(this.key) > 0) {
			
			//Again, if a duplicate is attempted to be added, this field will be broken
			this.sizeOfRightSubTree++;
			
			if(right == null) {
				right = new TreeNode<K,V>(key, val);
				return;
			}
			
			right.insert(key, val);
		}
	}
	

	//Definition: The "target" node is the node to deleted
	//This method works by removing the link to the "target" node
	// from its parent node, which removes the node from the tree
	public TreeNode<K, V> remove(TreeNode<K, V> parent, K key) {
		if (key.compareTo(this.key) < 0) {
			if (this.left != null) {
				// The node to remove is in the left subtree
				return left.remove(this, key);
			}

			// The node to remove is not in the tree
			return null;
		} else if (key.compareTo(this.key) > 0) {
			if (this.right != null) {
				// The node to remove is in the right subtree
				return right.remove(this, key);
			}

			// The node to remove is not in the tree
			return null;
		} else {
			// At this point, we have found the node to remove
			// A copy of the target node is made to return after removal is complete
			TreeNode<K,V> target = this;
			
			// We must then check if the node has two children
			// If it does not have two children, removing the node is
			// 	easier if it does not have two children
			if (this.left != null && this.right != null) {
				// Duplicate the key and value from the smallest node
				// 	in the right subtree into the target node, which effectively
				// 	replaces the target node. Then, the node from which the
				//  key and value were duped from is deleted, restoring the BST property
				TreeNode<K, V> temp = this.right.smallestNode();
				this.key = temp.key;
				this.val = temp.val;
				
				return this.right.remove(this, key);
			} 
			
			//Check if the target node is the left or right child of the parent node
			else if(parent.left == this) {
				if(this.left != null) {
					//If the target node has a left child, point the parent to it
					parent.left = this.left;
				} else {
					//If the left child is null, then point the parent to the right child.
					//If the right child exists, we have ensured no extra nodes are lost.
					//If the right child is null, then the target node is a leaf.
					//Therefore the parent has nothing to point to in the first place.
					parent.left = this.right;
				}
				
				parent.sizeOfLeftSubTree--;
		
				//Removal complete, return the target node
				return target;
			} else if(parent.right == this) {
				if(this.left != null) {
					parent.right = this.left;
				} else {
					parent.right = this.right;
				}
				
				return target;
			} else {
				//This should be unreachable under normal conditions
				return null;
			}
		}
	}


	public TreeNode<K, V> smallestNode() {
		if (left == null) {
			return this;
		} else {
			return left.smallestNode();
		}
	}

	public TreeNode<K, V> largestNode() {
		if (right == null) {
			return this;
		} else {
			return right.smallestNode();
		}
	}
}

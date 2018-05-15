package me.arifbanai.projectTwo;

import me.arifbanai.projectTwo.resources.Map;
import me.arifbanai.projectTwo.resources.TreeNode;

public class BSTMap<K extends Comparable<K>,V> implements Map<K, V> {
	
	protected int size;
	
	private TreeNode<K, V> root;
	
	public BSTMap() {
		root = null;
		size = 0;
	}
	
	private void insertNode(K key, V val) {
		//If the tree has no root, the tree 
		if(root == null) {
			root = new TreeNode<K,V>(key, val);
		} else {
			root.insert(key, val);
		}
		
		
	}
	
	private V getVal(K key) {
		TreeNode<K,V> temp = root;
		
		while(temp != null) {
			
			//If compareTo returns 0, then key and temp.key are equal
			if(key.compareTo(temp.key) == 0) {
				return temp.val;
			} else if(key.compareTo(temp.key) < 0) {
				temp = temp.left;
			} else if(key.compareTo(temp.key) > 0) {
				temp = temp.right;
			}
		}
		
		//Returns null if the node containing <key> is not found
		return null;
	}
	
	private void removeNode(K key) {
		
		//If the tree is empty, there is nothing to remove
		if(root == null) {
			return;
		}
		
		//Handle the case where the root is to be removed
		if(key.equals(root.key)) {
			//<temp> acts as the parent to the root (even though it doesn't have one)
			//	as the remove method requires a <parent> argument
			TreeNode<K,V> temp = new TreeNode<K,V>();
			temp.right = root;
			
			root.remove(temp, key);
			root = temp.right;
		} else {
			//The node to remove is not the root
			//Since root has no parent, the <parent> argument is null
			root.remove(null, key);
		}
	}

	@Override
	public void put(K key, V value) {
		insertNode(key, value);
	}

	@Override
	public V get(K key) {
		return getVal(key);
	}

	@Override
	public void remove(K key) {
		removeNode(key);
	}

	@Override
	public int size() {
		if(root != null) {
			//Updates the <size> field while returning the size
			return size = root.sizeOfLeftSubTree + root.sizeOfRightSubTree + 1;
		}
		
		return size = 0;
	}

	@Override
	public boolean isEmpty() {
		//Calling the method size() ensures the <size> field is updated before
		//	the boolean check is performed
		return size() == 0;
	}

}

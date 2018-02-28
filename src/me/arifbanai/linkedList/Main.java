package me.arifbanai.linkedList;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0; i < 10; i++) {
			ListNode<Integer> node = new ListNode<Integer>((int)(Math.random() * 100) + 1);
			
			System.out.println(node.data);
			
			list.prepend(node);
		}
		System.out.println("Size of <list>: " + list.size());
		
		System.out.println("-----------------");
		
		for(ListNode<Integer> current = list.first.next; current != null; current = current.next) {
			System.out.println(current.data);
		}

	}

}

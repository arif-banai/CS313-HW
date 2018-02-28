import me.arifbanai.linkedList.LinkedList;
import me.arifbanai.linkedList.ListNode;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0; i < 10; i++) {
			ListNode<Integer> node = new ListNode<Integer>((int)(Math.random() * 100) + 1);
			
			System.out.println(node.getData());
			
			list.prepend(node);
		}
		System.out.println("Size of <list>: " + list.size());
		
		System.out.println("-----------------");
		
		for(ListNode<Integer> current = list.getFirst().getNext(); current != null; current = current.getNext()) {
			System.out.println(current.getData());
		}

	}

}

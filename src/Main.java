import me.arifbanai.linkedList.LinkedList;
import me.arifbanai.linkedList.ListNode;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0; i < 3; i++) {
			ListNode<Integer> node = new ListNode<Integer>((int)(Math.random() * 100) + 1);
			
			System.out.println(node.getData());
			
			list.append(node);
		}
		System.out.println("Size of <list>: " + list.size());
		System.out.println("First real node: " + list.getFirst().getData());
		System.out.println("Last node: " + list.getLast().getData());
		
		System.out.println("-----------------");
		
		for(ListNode<Integer> current = list.getFirst(); current != null && current.getData() != null; current = current.getNext()) {
			System.out.println(current.getData());
		}

	}

}

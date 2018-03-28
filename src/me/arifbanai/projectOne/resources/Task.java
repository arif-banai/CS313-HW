package me.arifbanai.projectOne.resources;

public class Task implements Comparable<Task> {
	public int id;
	public int priority;

	@Override
	public int compareTo(Task other) {
		if(this.priority > other.priority)
			return 1;
		else if(this.priority < other.priority)	
			return -1;
		else 
			return 0;
	}
	
	public String toString() {
		return priority + "";
	}
}

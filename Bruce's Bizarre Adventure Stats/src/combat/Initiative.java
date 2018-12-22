package combat;
import character.Character;
import java.io.*;
public class Initiative {

	private class Node{
		private Character data;
		private int init;
		private Node next;
		private Node(Character data, Node next) {
			this.data = data;
			this.next = next;
		}
		private Node(Character data) {this(data,null);}		
	}
	private Node head;
	private int size;
	public Initiative(){//Dummy Head Node
		this.head = new Node(null);
		this.size = 0;
	}
	public boolean isEmpty() {return this.size == 0;}
	public void addFirst(Character elem) {
		if(elem == null || elem.getName().isEmpty()) {
			System.out.println("Character cannot be entered.");
			return;
		}
		else if(this.size == 0) {
			this.head.next = new Node(elem);
		}
		else {
			Node retract = this.head.next, cur = this.head;
			cur.next = new Node(elem);
			cur = cur.next;
			cur.next = retract;
		}
		this.size++;
	}
	public void addLast(Character elem) {
		if(this.size == 0)
			return;
		Node cur = this.head;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = new Node(elem);
		this.size++;
	}
	public void addSorted(Character elem) {
		if(this.size == 0)
			addFirst(elem);
		else if(this.head.next.data.getInit() < elem.getInit()) {
			addFirst(elem);
		}
		else {
			Node cur = this.head.next;
			while(cur.next != null && elem.getInit() <= cur.next.data.getInit()) {
				cur = cur.next;
			}
			Node retract = cur.next;
			cur.next = new Node(elem);
			cur = cur.next;
			cur.next = retract;
			this.size++;
		}
	}
	public String remove(final String name) {
		if(this.size == 0)
			return "";
		Node cur = this.head.next,prev = this.head;
		while(cur != null) {
			if(name.equals(cur.data.getName())) {
				prev.next = cur.next;
				this.size--;
				return name;
			}
			prev = cur;
			cur = cur.next;
		}
		return "";
	}
	public Character removeLast() {
		if(this.size == 0)
			return null;
		Node cur = this.head.next, prev = this.head;
		while(cur.next != null) {
			prev = cur;
			cur = cur.next;
		}
		Character result = cur.data;
		prev.next = cur.next;
		this.size--;
		return result;
	}
	public Character removeFirst() {
		if(this.size == 0)
			return null;
		Character result = this.head.next.data;
		Node cur = this.head.next, prev = this.head;
		prev.next = cur.next;
		this.size--;
		return result;
	}
	public void moveUp() {
		Character toLast = removeFirst();
		addLast(toLast);
	}
	public Character characterTurn() {return this.head.next.data;}
	public void listOrder() {
		Node cur = this.head.next;
		System.out.println("--- Order ---");
		while(cur != null) {
			System.out.println(cur.data.getName() + ": " + cur.data.getInit());
			cur = cur.next;
		}
	}
	public String upNext() {
		if(this.size == 1)
			return "No one else is in combat.";
		else
			return "Up Next: " + this.head.next.next.data.getName();
	}
	public Character find(String name) {
		Node cur = this.head.next;
		while(cur != null) {
			if(cur.data.getName().equals(name))
				return cur.data;
			cur = cur.next;
		}
		return null;
	}
	public void changeCharacter(Character elem) {
		Node cur = this.head.next;
		while(cur != null) {
			if(cur.data.getName().equals(elem.getName()))
				cur.data = elem;
			cur = cur.next;
		}
	}
	public static void main(String [] args) throws FileNotFoundException{
		Initiative theList = new Initiative();
		theList.addFirst(new Character("Jimmy"));
		theList.addFirst(new Character("Timmy"));
		theList.moveUp();
	}
}

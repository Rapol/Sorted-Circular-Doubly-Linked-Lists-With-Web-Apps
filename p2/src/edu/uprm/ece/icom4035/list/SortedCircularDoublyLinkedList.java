package edu.uprm.ece.icom4035.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * SortedCircularDoublyLinkedList implements SortedList<E>
 */
public class SortedCircularDoublyLinkedList<E extends Comparable<E>> implements SortedList<E> {
	
	private class Node{
		private E value;
		private Node next;
		private Node prev;
		
		public E getValue() {
			return value;
		}
		public void setValue(E value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
	}
	
	private class CircularDoublyListIterator implements Iterator<E>{

		private Node nextNode;
		public CircularDoublyListIterator(){
			this.nextNode=header.getNext();
		}
		public CircularDoublyListIterator(int index){
			if(index<0 || index>=currentSize){
				throw new IndexOutOfBoundsException();
			}
			int counter=0;
			for(this.nextNode=header.getNext();counter<index;nextNode=nextNode.getNext(),counter++);
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return this.nextNode!=header;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if(this.hasNext()){
				E result = this.nextNode.getValue();
				this.nextNode=this.nextNode.getNext();
				return result;
			}
			else{
				throw new NoSuchElementException();
			}
		}
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	}
	
	private class CircularDoublyReverseListIterator implements ReverseIterator<E>{

		private Node prevNode;
		
		public CircularDoublyReverseListIterator(){
			Node temp=null;
			for(temp=header.getNext();temp.getNext()!=header;temp=temp.getNext());
			this.prevNode=temp;
		}
		public CircularDoublyReverseListIterator(int index){
			if(index<0 || index>=currentSize){
				throw new IndexOutOfBoundsException();
			}
			int counter=0;
			for(this.prevNode=header.getNext();counter<index;this.prevNode=this.prevNode.getNext(),counter++);
		}
		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return this.prevNode!=header;
		}
		@Override
		public E previous() {
			// TODO Auto-generated method stub
			if(this.hasPrevious()){
				E result=this.prevNode.getValue();
				this.prevNode=this.prevNode.getPrev();
				return result;
			}
			else{
				throw new NoSuchElementException();
			}
		}
	}
	private int currentSize;
	private Node header;
	
	//Default Constructor
	public SortedCircularDoublyLinkedList(){
		this.currentSize=0;
		this.header=new Node();
		this.header.setNext(this.header);
		this.header.setPrev(this.header);
	}
	
	//Iterator Method 
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new CircularDoublyListIterator();
	}

	/**Add method
	 * @param obj element to be added to the DLL
	 */
	@Override
	public boolean add(E obj) {
		// TODO Auto-generated method stub
		if(obj == null){
			return false;
		}
		if(this.currentSize==0){
			Node newNode=new Node();
			newNode.setValue(obj);
			this.header.setNext(newNode);
			this.header.setPrev(newNode);
			newNode.setPrev(this.header);
			newNode.setNext(this.header);
			this.currentSize++;
			return true;
		}
		else{
			Node temp=null;
			for(temp=this.header.getNext();temp!=this.header;temp=temp.getNext()){
				if(obj.compareTo(temp.getValue())<=0){
					Node newNode=new Node();
					newNode.setNext(temp);
					newNode.setPrev(temp.getPrev());
					newNode.setValue(obj);
					temp.getPrev().setNext(newNode);
					temp.setPrev(newNode);
					this.currentSize++;
					return true;
				}
			}
			if(temp==this.header){
				Node newNode=new Node();
				newNode.setNext(temp);
				newNode.setPrev(temp.getPrev());
				newNode.setValue(obj);
				temp.getPrev().setNext(newNode);
				temp.setPrev(newNode);
				this.currentSize++;
				return true;
			}
		}
		return false;
	}

	/**
	 * @return current size
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.currentSize;
	}

	/** Remove method to remove the first occurence of the obj
	 * @return if the obj was removed
	 * @param obj to be removed on the first ocurrence
	 */
	@Override
	public boolean remove(E obj) {
		// TODO Auto-generated method stub
		if(obj==null){
			return false;
		}
		Node temp=null;
		for(temp=this.header.getNext();temp!=this.header;temp=temp.getNext()){
			if(temp.getValue().equals(obj)){
				temp.getPrev().setNext(temp.getNext());
				temp.getNext().setPrev(temp.getPrev());
				temp.setNext(null);
				temp.setPrev(null);
				temp.setValue(null);
				this.currentSize--;
				return true;
			}
		}
		return false;
	}

	/** Remove an element at an specific index
	 * @param int index to be removed
	 * @return return boolean if value is removed or not
	 */
	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		if(index<0 || index>=this.currentSize){
			throw new IndexOutOfBoundsException();
		}
		Node temp=null;
		int counter=0;
		for(temp=this.header.getNext();counter<index;temp=temp.getNext(),counter++);
		temp.getPrev().setNext(temp.getNext());
		temp.getNext().setPrev(temp.getPrev());
		temp.setNext(null);
		temp.setPrev(null);
		temp.setValue(null);
		this.currentSize--;
		return true;
	}

	/**
	 * Remove all repetion of an object
	 * @param E obj to be remove
	 * @return int removed counter
	 */
	@Override
	public int removeAll(E obj) {
		// TODO Auto-generated method stub
		if(obj==null){
			return 0;
		}
		int counter=0;
		while(this.contains(obj)){
			this.remove(obj);
			counter++;
		}
		return counter;
	}

	/**First element of de List
	 * @return E value of the first node of the List
	 */
	@Override
	public E first() {
		// TODO Auto-generated method stub
		if(this.isEmpty()){
			return null;
		}
		return this.header.getNext().getValue();
	}

	/** Last element of the List
	 * @return E value of the last node of the List
	 */
	@Override
	public E last() {
		// TODO Auto-generated method stub
		if(this.isEmpty()){
			return null;
		}
		return this.header.getPrev().getValue();
	}

	/**Get an specific node on the List
	 * @param index node to be returned
	 * @return E element at the specific node
	 */
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if(index<0 || index>=this.currentSize){
			throw new IndexOutOfBoundsException();
		}
		Node temp=this.header.getNext();
		for(int counter=0;counter<index;counter++,temp=temp.getNext());
		return temp.getValue();
	}

	/**Clear the whole List
	 * 
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		while(!this.isEmpty()){
			this.remove(0);
		}
	}

	/** Verify if a element is on the List or not
	 * @param E element to compare
	 * @return if it is on the List or not
	 */
	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		if(e == null){
			return false;
		}
		Node temp=null;
		for(temp=this.header.getNext();temp!=this.header;temp=temp.getNext()){
			if(temp.getValue().equals(e)){
				return true;
			}
		}
		return false;
	}

	/**Verify if the List is empty or not
	 * @return if the list is empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.currentSize==0;
	}

	/**Index iterator
	 *@param int index to start interation
	 */
	@Override
	public Iterator<E> iterator(int index) {
		// TODO Auto-generated method stub
		return new CircularDoublyListIterator(index);
	}

	/**fistIndex of the parameter at the List
	 * @param element to verify its first index
	 * @return the first index of the obj, -1 if not found
	 */
	@Override
	public int firstIndex(E e) {
		// TODO Auto-generated method stub
		if(e == null){
			return -1;
		}
		Node temp=null;
		int counter=0;
		for(temp=this.header.getNext();temp!=this.header;temp=temp.getNext(),counter++){
			if(temp.getValue().equals(e)){
				return counter;
			}
		}
		return -1;
	}

	/**lastIndex of the parameter at the List
	 * @param element to verify its last index on the List
	 * @return the last index of the obj, -1 if not found
	 */
	@Override
	public int lastIndex(E e) {
		// TODO Auto-generated method stub
		if(e == null){
			return -1;
		}
		Node temp=null;
		int counter=0;
		int lastseen=-1;
		for(temp=this.header.getNext();temp!=this.header;temp=temp.getNext(),counter++){
			if(temp.getValue().equals(e)){
				lastseen=counter;
			}
		}
		return lastseen;
	}

	/**
	 * reverse iterator of the List
	 */
	@Override
	public ReverseIterator<E> reverseIterator() {
		// TODO Auto-generated method stub
		return new CircularDoublyReverseListIterator();
	}

	/**
	 * ReverseIterator from an specific index
	 * @param int index for starting the iteration
	 */
	@Override
	public ReverseIterator<E> reverseIterator(int index) {
		// TODO Auto-generated method stub
		return new CircularDoublyReverseListIterator(index);
	}

}

package Wheel_Of_Fortune;

public class Link_list {
	
	private Node head;
	private Node tail;
	
	public Link_list() {
		this.head = null;
	}
	
	public boolean isEmpty()
	{
		if(head==null)
			return true;
		else
			return false;
	}
	
	public boolean isFull()
	{
		Node temp= new Node();
		
		if(temp==null)
		{
			return true;
		}
		else
		{
			temp=null;
			return false;
		}
		
	}
	
	
	public void addToTail(Cards data)
	{
		if(isFull())
		{
			System.err.println("List is full");
		}
		else
		{
			Node nextCard= new Node();
			nextCard.setCardData(data);
		
			if(isEmpty())
			{
				head=nextCard;
				
			}
			else {
				 tail.setNextnode(nextCard);
			}
			tail=nextCard;
			tail.setNextnode(head);
		}				
	}
	
	public boolean addPuzzleToFront(puzzle data)
	{
		if(isFull())
		{
			System.out.println("List is full");
			return false;
		}
		else 
		{
			Node nextPuzzle = new Node();
			nextPuzzle.setPuzzleData(data);
			
			if(isEmpty())
			{
				head=nextPuzzle;
			}
			else
			{
				nextPuzzle.setNextnode(head);
				head=nextPuzzle;
			}
				
				return true;
		}
	}
				
	 public void addPlayer(Player data)
	 {
		 if(isFull())
		 {
			 System.out.println("List is full");
		 }
		 else
		 {
		 Node nextPlayer= new Node();
		 nextPlayer.setPlayerData(data);
		 
		 if(isEmpty())
		 {
			 head=nextPlayer;
		 }
		 else
		 {
			 tail.setNextnode(nextPlayer);
		 }
		 tail=nextPlayer;
		 tail.setNextnode(head);
		
	 }
	 }
		
	 public Node GetNode(int num)
	 {   Node current = head;
		 int index = 1;
		 if(isEmpty())
		 {
			 System.out.println("List is Empty");
		 } 
			 else
			 {
				 while(current.getNextnode() != null)
				 {
					 if(index == num)
					 {
						 return current; 
					 }
					 current=current.getNextnode();
					 index ++;
				 }
			 }
		return null;
	 }
	 
	 
	 
		public void display() {
			Node current = head;
			while(current  != null) {
			current.getPuzzleData().display();
			current = current.getNextnode();	
			}
		}
		
	
}
package Wheel_Of_Fortune;

public class Node {
	private Cards cardData;
	private Player playerData;
	private puzzle puzzleData;
	private Node nextnode;
	private Node previousnode;
	
	
	public Node() {
		super();
	}
	
	public Node(Cards cardData, Player playerData, puzzle puzzleData, Node nextnode, Node previousnode) {
		super();
		this.cardData = cardData;
		this.playerData = playerData;
		this.puzzleData = puzzleData;
		this.nextnode = nextnode;
		this.previousnode = previousnode;
	}
	
	
	public Node(Node copyNode) {
		super();
		this.cardData = copyNode.cardData;
		this.playerData = copyNode.playerData;
		this.puzzleData = copyNode.puzzleData;
		this.nextnode = copyNode.nextnode;
		this.previousnode = copyNode.previousnode;
		
	}

	public Cards getCardData() {
		return cardData;
	}

	public void setCardData(Cards cardData) {
		this.cardData = cardData;
	}

	public Player getPlayerData() {
		return playerData;
	}

	public void setPlayerData(Player playerData) {
		this.playerData = playerData;
	}

	public puzzle getPuzzleData() {
		return puzzleData;
	}

	public void setPuzzleData(puzzle puzzleData) {
		this.puzzleData = puzzleData;
	}

	public Node getNextnode() {
		return nextnode;
	}

	public void setNextnode(Node nextnode) {
		this.nextnode = nextnode;
	}

	public Node getPreviousnode() {
		return previousnode;
	}

	public void setPreviousnode(Node previousnode) {
		this.previousnode = previousnode;
	}

	
	
	
	
	
	
}

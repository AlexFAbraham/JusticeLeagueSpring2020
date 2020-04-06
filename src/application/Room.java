package application;

public class Room {
	private String roomID;
	private Boolean roomIsVisited;
	private String roomName;
	private String[] roomAround;
	private String roomDescription;
	
	// Default Constructor
	public Room() {
		roomID = "";
		roomIsVisited = false;
		roomName = "";
		roomAround = new String[] { "0", "0", "0", "0" };
		roomDescription = "";
	}
	
	// Constructor with fixed values
	public Room(String roomID, Boolean roomIsVisited, String roomName, String[] roomAround, String roomDescription) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomIsVisited = roomIsVisited;
		this.roomAround = roomAround;
		this.roomDescription = roomDescription;
	}
	
	// Getters
	public String getRoomID() {
		return roomID;
	}
	
	public Boolean getRoomIsVisited() {
		return roomIsVisited;
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public String[] getRoomAround() {
		return roomAround;
	}
	
	public String getRoomDescription() {
		return roomDescription;
	}
	
	// Setters
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	
	public void setRoomIsVisited(Boolean roomIsVisited) {
		this.roomIsVisited = roomIsVisited;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public void setRoomAround(String[] roomAround) {
		this.roomAround = roomAround;
	}
	
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
}

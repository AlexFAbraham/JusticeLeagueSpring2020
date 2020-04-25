package application;

public class Item {
	private String itemID;
	private String itemName;
	private String itemDescription;
	private String itemType;
	private int itemHealthAmount;
	private int itemAttackAmount;
	private int itemDefenseAmount;
	private String itemLocation;
	private Boolean itemIsPickedUp;
	private Boolean itemIsEquipped;
	private Boolean itemIsLocked;
	
	public Item() {
		itemID = "";
		itemName = "";
		itemDescription = "";
		itemType = "";
		itemHealthAmount = 0;
		itemAttackAmount = 0;
		itemDefenseAmount = 0;
		itemLocation = "";
		itemIsPickedUp = false;
		itemIsEquipped = false;
		itemIsLocked = false;
	}
	
	public Item(String itemName, String itemDescription, String itemType, int itemHealthAmount, int itemAttackAmount, int itemDefenseAmount) {
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
		this.itemHealthAmount = itemHealthAmount;
		this.itemAttackAmount = itemAttackAmount;
		this.itemDefenseAmount = itemDefenseAmount;
	}
	
	public Item(String itemID, String itemName, String itemDescription, String itemType, int itemHealthAmount, int itemAttackAmount, 
			int itemDefenseAmount, String itemLocation, Boolean itemIsPickedUp, Boolean itemIsEquipped, Boolean itemIsLocked) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
		this.itemHealthAmount = itemHealthAmount;
		this.itemAttackAmount = itemAttackAmount;
		this.itemDefenseAmount = itemDefenseAmount;
		this.itemLocation = itemLocation;
		this.itemIsPickedUp = itemIsPickedUp;
		this.itemIsEquipped = itemIsEquipped;
		this.itemIsLocked = itemIsLocked;
	}
	
	// Getters 
	public String getItemID() {
		return itemID;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public String getItemDescription() {
		return itemDescription;
	}
	
	public String getItemType() {
		return itemType;
	}
	
	public int getItemHealthAmount() {
		return itemHealthAmount;
	}
	
	public int getItemAttackAmount() {
		return itemAttackAmount;
	}
	
	public int getItemDefenseAmount() {
		return itemDefenseAmount;
	}

	public String getItemLocation() {
		return itemLocation;
	}
	
	public Boolean getItemIsPickedUp() {
		return itemIsPickedUp;
	}
	
	public Boolean getItemIsEquipped() {
		return itemIsEquipped;
	}
	
	public Boolean getItemIsLocked() {
		return itemIsLocked;
	}
	
	// Setters 
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	public void setItemHealthAmount(int itemHealthAmount) {
		this.itemHealthAmount = itemHealthAmount;
	}
	
	public void setItemAttackAmount(int itemAttackAmount) {
		this.itemAttackAmount = itemAttackAmount;
	}
	
	public void setItemDefenseAmount(int itemDefenseAmount) {
		this.itemDefenseAmount = itemDefenseAmount;
	}

	public void setItemLocation(String itemLocation) {
		this.itemLocation = itemLocation;
	}
	
	public void setItemIsPickedUp(Boolean itemIsPickedUp) {
		this.itemIsPickedUp = itemIsPickedUp;
	}	
	
	public void setItemIsEquipped(Boolean itemIsEquipped) {
		this.itemIsEquipped = itemIsEquipped;
	}	
	
	public void setItemIsLocked(Boolean itemIsLocked) {
		this.itemIsLocked = itemIsLocked;
	}	
}

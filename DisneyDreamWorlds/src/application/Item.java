package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

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
	
	public Item() {
		itemID = "";
		itemName = "";
		itemDescription = "";
		itemType = "";
		itemHealthAmount = 0;
		itemAttackAmount = 0;
		itemDefenseAmount = 0;
		itemIsPickedUp = false;
		itemLocation = "";
	}
	
	public Item(String itemName, String itemDescription, String itemType) {
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
	}
	
	public Item(String itemID, String itemName, String itemDescription, String itemType, 
			int itemHealthAmount, int itemAttackAmount, int itemDefenseAmount, String itemLocation, Boolean itemIsPickedUp) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
		this.itemHealthAmount = itemHealthAmount;
		this.itemAttackAmount = itemAttackAmount;
		this.itemDefenseAmount = itemDefenseAmount;
		this.itemLocation = itemLocation;
		this.itemIsPickedUp = itemIsPickedUp;
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
	
	public void itemCommandAction(String message, ImageView emojiImageView_2) {
		Text invalidCommandMessage = new Text(message);
		invalidCommandMessage.setTextAlignment(TextAlignment.CENTER);
		VBox invalidCommandBox = new VBox(10);
		invalidCommandBox.setAlignment(Pos.CENTER);
		
		Button okButton = new Button("OK");
		
		invalidCommandBox.getChildren().add(invalidCommandMessage);
		invalidCommandBox.getChildren().add(emojiImageView_2);
		invalidCommandBox.getChildren().add(okButton);
		
		Scene invalidCommandScene = new Scene(invalidCommandBox, 300, 150);
		Stage invalidCommandStage = new Stage();
		
		invalidCommandStage.setScene(invalidCommandScene);
		invalidCommandStage.show();
		
		okButton.setOnAction(f -> {
			invalidCommandStage.close();
		});
	}
	
}

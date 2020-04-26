package application;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Player {
	private String playerID;
	private String playerUsername;
	private String playerPassword;
	// private String playerEmail;
	private int playerCurrentHealth;
	private int playerTotalHealth;
	private int playerMinAttack;
	private int playerMaxAttack;
	private int playerDefense;
	private int playerScore;
	private ArrayList<Item> playerInventory;
	private ArrayList<Item> playerEquipment;
	private String playerLocation;
	
	public Player() {
		playerID = "";
		playerUsername = "";
		playerPassword = "";
		// 25
		playerCurrentHealth = 25;
		playerTotalHealth = 25;
		// 15-25
		playerMinAttack = 15;
		playerMaxAttack = 25;
		playerDefense = 10;
		playerScore = 0;
		playerInventory = new ArrayList<Item>();
		playerEquipment = new ArrayList<Item>();
		playerLocation = "R01";
	}
	
	public Player(String playerID, String playerUsername, String playerPassword, int playerCurrentHealth, int playerTotalHealth, int playerMinAttack, 
			int playerMaxAttack, int playerDefense, int playerScore, ArrayList<Item> playerInventory, ArrayList<Item> playerEquipment, String playerLocation) {
		this.playerID = playerID;
		this.playerUsername = playerUsername;
		this.playerPassword = playerPassword;
		this.playerCurrentHealth = playerCurrentHealth;
		this.playerTotalHealth = playerTotalHealth;
		this.playerMinAttack = playerMinAttack;
		this.playerMaxAttack = playerMaxAttack;
		this.playerDefense = playerDefense;
		this.playerScore = playerScore;
		this.playerInventory = playerInventory;
		this.playerEquipment = playerEquipment;
		this.playerLocation = playerLocation;
	}
	
	// Getters
	public String getPlayerID() {
		return playerID;
	}
	
	public String getPlayerUsername() {
		return playerUsername;
	}
	
	public String getPlayerPassword() {
		return playerPassword;
	}
	
	public int getPlayerCurrentHealth() {
		return playerCurrentHealth;
	}
	
	public int getPlayerTotalHealth() {
		return playerTotalHealth;
	}
	
	public int getPlayerMinAttack() {
		return playerMinAttack;
	}
	
	public int getPlayerMaxAttack() {
		return playerMaxAttack;
	}
	
	public int getPlayerDefense() {
		return playerDefense;
	}
	
	public int getPlayerScore() {
		return playerScore;
	}
	
	public ArrayList<Item> getPlayerInventory() {
		return playerInventory;
	}
	
	public ArrayList<Item> getPlayerEquipment() {
		return playerEquipment;
	}
	
	public String getPlayerLocation() {
		return playerLocation;
	}
	
	// Setters
	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}
	
	public void setPlayerUsername(String playerUsername) {
		this.playerUsername = playerUsername;
	}
	
	public void setPlayerPassword(String playerPassword) {
		this.playerPassword = playerPassword;
	}
	
	public void setPlayerCurrentHealth(int playerCurrentHealth) {
		this.playerCurrentHealth = playerCurrentHealth;
	}
	
	public void setPlayerTotalHealth(int playerTotalHealth) {
		this.playerTotalHealth = playerTotalHealth;
	}
	
	public void setPlayerMinAttack(int playerMinAttack) {
		this.playerMinAttack = playerMinAttack;
	}
	
	public void setPlayerMaxAttack(int playerMaxAttack) {
		this.playerMaxAttack = playerMaxAttack;
	}
	
	public void setPlayerDefense(int playerDefense) {
		this.playerDefense = playerDefense;
	}
	
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	
	public void setPlayerInventory(ArrayList<Item> playerInventory) {
		this.playerInventory = playerInventory;
	}
	
	public void setPlayerEquipment(ArrayList<Item> playerEquipment) {
		this.playerEquipment = playerEquipment;
	}
	
	public void setPlayerLocation(String playerLocation) {
		this.playerLocation = playerLocation;
	}
	
	// This function displays help/instructions about the game
	public void helpCommand(Stage stage, ImageView image, Rectangle2D screenBounds, String title) {
			GridPane gp = new GridPane();
			gp.setAlignment(Pos.CENTER);
			gp.setVgap(10);
			gp.setHgap(10);
			gp.setPadding(new Insets(10));
			
			Button okButton = new Button("Ok");
			gp.add(image, 0, 0);
			gp.add(okButton, 0, 1);
			
			GridPane.setHalignment(okButton, HPos.CENTER);
			
			Scene helpCommandScene = new Scene(gp, image.getBoundsInParent().getWidth(), image.getBoundsInParent().getHeight()+80);
			stage.setScene(helpCommandScene);
			stage.setTitle(title);
			stage.show();
			
			okButton.setOnAction(e -> {
				stage.close();
			});
		}
	
	// This function displays the map and the current player's location
	public void displayMap(Player player, Stage playerMapStage, ImageView mapImageView, ImageView locationImageView, Image puzzleImage, Image itemImage, Image monsterImage,
			ArrayList<Puzzle> puzzleArrayList, ArrayList<Item> itemArrayList, ArrayList<Monster> monsterArrayList) {
		// get the image of the map and location pin and add it to the scene
		try {
			Group root = new Group(); 
			
			//mapDisplay.getChildren().clear();
			
			Scene scene = new Scene(root, 520, 400);
			
			playerMapStage.setTitle("Map");
			playerMapStage.setScene(scene);
			playerMapStage.setResizable(false);
			
			Button okButton = new Button("Ok");
			okButton.setAlignment(Pos.CENTER);
			okButton.relocate(250, 350);
			
			okButton.setOnAction(e -> {
				playerMapStage.close();
			});
			
			root.getChildren().add(mapImageView);
			
			setObjectImages(itemArrayList, puzzleArrayList, monsterArrayList, itemImage, puzzleImage, monsterImage, root);
			
			root.getChildren().add(locationImageView);
			root.getChildren().add(okButton);
			
			ImageView itemSymbol = new ImageView(itemImage);
			root.getChildren().add(itemSymbol);
			itemSymbol.relocate(340, 300);
			itemSymbol.setFitWidth(20);
			itemSymbol.setFitHeight(20);
			Label itemLabel = new Label("Item");
			itemLabel.setStyle("-fx-font-size: 13px;" +
	  				 		   "-fx-font-weight: bold");
			root.getChildren().add(itemLabel);
			itemLabel.relocate(370, 300);
			
			ImageView puzzleSymbol = new ImageView(puzzleImage);
			root.getChildren().add(puzzleSymbol);
			puzzleSymbol.relocate(340, 330);
			puzzleSymbol.setFitWidth(20);
			puzzleSymbol.setFitHeight(20);
			Label puzzleLabel = new Label("Puzzle");
			puzzleLabel.setStyle("-fx-font-size: 13px;" +
	  				 		   "-fx-font-weight: bold");
			root.getChildren().add(puzzleLabel);
			puzzleLabel.relocate(370, 330);
			
			ImageView monsterSymbol = new ImageView(monsterImage);
			root.getChildren().add(monsterSymbol);
			monsterSymbol.relocate(340, 360);
			monsterSymbol.setFitWidth(20);
			monsterSymbol.setFitHeight(20);
			Label monsterLabel = new Label("Monster");
			monsterLabel.setStyle("-fx-font-size: 13px;" +
	  				 		   "-fx-font-weight: bold");
			root.getChildren().add(monsterLabel);
			monsterLabel.relocate(370, 360);

			playerMapStage.show();
			
			setLocationOfPlayerInMap(player.getPlayerLocation(), locationImageView);
		} 
		catch (Exception e)	{
				System.out.println("Map cannot be display");
		}
	}
	
	// This function set images for each object in map
	public void setObjectImages(ArrayList<Item> itemArrayList, ArrayList<Puzzle> puzzleArrayList, ArrayList<Monster> monsterArrayList, Image itemImage, Image puzzleImage, Image monsterImage, Group root) {
		for (int itemIndex = 0; itemIndex < itemArrayList.size(); itemIndex++) {
			if (itemArrayList.get(itemIndex).getItemIsPickedUp().equals(false) && itemArrayList.get(itemIndex).getItemIsLocked().equals(false))
				root.getChildren().add(setImageAtLocation(itemArrayList.get(itemIndex).getItemLocation(), new ImageView(itemImage)));
		}
		for (int puzzleIndex = 0; puzzleIndex < puzzleArrayList.size(); puzzleIndex++) {
			if (puzzleArrayList.get(puzzleIndex).getPuzzleIsLocked().equals(false))
				root.getChildren().add(setImageAtLocation(puzzleArrayList.get(puzzleIndex).getPuzzleLocation(), new ImageView(puzzleImage)));
		}
		for (int monsterIndex = 0; monsterIndex < monsterArrayList.size(); monsterIndex++) {
			if (monsterArrayList.get(monsterIndex).getMonsterIsDefeated().equals(false))
				root.getChildren().add(setImageAtLocation(monsterArrayList.get(monsterIndex).getMonsterLocation(), new ImageView(monsterImage)));
		}
	}
	
	// This function indicates what's found in each room
	public ImageView setImageAtLocation(String location, ImageView image) {
		image.setFitHeight(20);
		image.setFitWidth(20);
		
		switch(location) {
		case "R01":
			image.relocate(135, 280);   
			break;
		case "R02":
			image.relocate(147, 243);
			break;
		case "R03":
			image.relocate(205, 243);
			break;
		case "R04":
			image.relocate(147, 195);
			break;
		case "R05":
			image.relocate(205, 195);
			break;
		case "R06":
			image.relocate(87, 243);
			break;
		case "R07":
			image.relocate(32, 243);
			break;
		case "R08":
			image.relocate(32, 195);
			break;
		case "R09":
			image.relocate(87, 195);
			break;
		case "R10":
			image.relocate(87, 140);
			break;
		case "R11":
			image.relocate(147, 140);
			break;
		case "R12":
			image.relocate(87, 85);
			break;
		case "R13":
			image.relocate(147, 85);
			break;
		case "R14":
			image.relocate(205, 85);
			break;
		case "R15":
			image.relocate(205, 140);
			break;
		case "R16":
			image.relocate(262, 85);
			break;
		case "R17":
			image.relocate(262, 140);
			break;
		case "R18":
			image.relocate(262, 195);
			break;
		case "R19":
			image.relocate(262, 243);
			break;
		case "R20":
			image.relocate(320, 195);
			break;
		case "R21":
			image.relocate(320, 243);
			break;
		case "R22":
			image.relocate(380, 243);
			break;
		case "R23":
			image.relocate(437, 243);
			break;
		case "R24":
			image.relocate(437, 195);
			break;
		case "R25":
			image.relocate(380, 195);
			break;
		case "R26":
			image.relocate(380, 140);
			break;
		case "R27":
			image.relocate(320, 140);
			break;
		case "R28":
			image.relocate(380, 85);
			break;
		case "R29":
			image.relocate(320, 85);
			break;
		case "R30":
			image.relocate(310, 20);
			break;
		default:
			// code block	
		}
		
		return image;
	}
	
	// This function relocates the position of the player in the map
	public void setLocationOfPlayerInMap(String location, ImageView mvLocation) {
		// change location of the location pin to the player's current location
		switch(location) {
			case "R01":
				mvLocation.relocate(135, 280);   
				break;
			case "R02":
				mvLocation.relocate(137, 228);
				break;
			case "R03":
				mvLocation.relocate(195, 228);
				break;
			case "R04":
				mvLocation.relocate(137, 180);
				break;
			case "R05":
				mvLocation.relocate(195, 180);
				break;
			case "R06":
				mvLocation.relocate(77, 228);
				break;
			case "R07":
				mvLocation.relocate(22, 228);
				break;
			case "R08":
				mvLocation.relocate(22, 180);
				break;
			case "R09":
				mvLocation.relocate(77, 180);
				break;
			case "R10":
				mvLocation.relocate(77, 125);
				break;
			case "R11":
				mvLocation.relocate(137, 125);
				break;
			case "R12":
				mvLocation.relocate(77, 70);
				break;
			case "R13":
				mvLocation.relocate(137, 70);
				break;
			case "R14":
				mvLocation.relocate(195, 70);
				break;
			case "R15":
				mvLocation.relocate(195, 125);
				break;
			case "R16":
				mvLocation.relocate(252, 70);
				break;
			case "R17":
				mvLocation.relocate(252, 125);
				break;
			case "R18":
				mvLocation.relocate(252, 180);
				break;
			case "R19":
				mvLocation.relocate(252, 228);
				break;
			case "R20":
				mvLocation.relocate(310, 180);
				break;
			case "R21":
				mvLocation.relocate(310, 228);
				break;
			case "R22":
				mvLocation.relocate(370, 228);
				break;
			case "R23":
				mvLocation.relocate(427, 228);
				break;
			case "R24":
				mvLocation.relocate(427, 180);
				break;
			case "R25":
				mvLocation.relocate(370, 180);
				break;
			case "R26":
				mvLocation.relocate(370, 125);
				break;
			case "R27":
				mvLocation.relocate(310, 125);
				break;
			case "R28":
				mvLocation.relocate(370, 70);
				break;
			case "R29":
				mvLocation.relocate(310, 70);
				break;
			case "R30":
				mvLocation.relocate(310, 20);
				break;
			default:
				// code block	
		}
	}
	
	// This function checks the player's current inventory
	public void playerChecksInventory(Player player, ArrayList<Item> itemArrayList, ImageView emojiImageView_2, ImageView emojiImageView_3, ArrayList<String> generalCommandList, ArrayList<Room> roomArrayList, 
			Stage playerInventoryStage, Stage primaryStage, TableView<Item> tableView1, Rectangle2D screenBounds, Stage commandListStage, Stage inventoryHelpStage, ImageView commandListImageView, 
			ImageView inventoryHelpImageView, Stage invalidStage, TextField inventoryTextField, Stage playerMapStage, ImageView mapImageView, ImageView locationImageView, Image puzzleImage, Image itemImage, 
			Image monsterImage, ArrayList<Puzzle> puzzleArrayList, ArrayList<Monster> monsterArrayList) {

		// Inventory Label
		Label l1 = new Label("Your Inventory");
		l1.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		
		// Inventory Table
		//TableView<Item> tableView = new TableView<>();
		TableColumn<Item, String> nameColumn = new TableColumn<>("Item Name");
		TableColumn<Item, String> descriptionColumn = new TableColumn<>("Item Description");
		TableColumn<Item, String> typeColumn = new TableColumn<>("Item Type");
		TableColumn<Item, Integer> healthAmountColumn = new TableColumn<>("Health");
		TableColumn<Item, Integer> attackAmountColumn = new TableColumn<>("Attack");
		TableColumn<Item, Integer> defenseAmountColumn = new TableColumn<>("Defense");
		
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("itemDescription"));
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("itemType"));
		healthAmountColumn.setCellValueFactory(new PropertyValueFactory<>("itemHealthAmount"));
		attackAmountColumn.setCellValueFactory(new PropertyValueFactory<>("itemAttackAmount"));
		defenseAmountColumn.setCellValueFactory(new PropertyValueFactory<>("itemDefenseAmount"));
					
		nameColumn.setMinWidth(140);
		descriptionColumn.setMinWidth(300);
		typeColumn.setMinWidth(100);
		healthAmountColumn.setMinWidth(50);
		attackAmountColumn.setMinWidth(50);
		defenseAmountColumn.setMinWidth(50);
		
		tableView1.getColumns().clear();
		tableView1.setItems(getItems(player));
		tableView1.getColumns().addAll(nameColumn, descriptionColumn, typeColumn, healthAmountColumn, attackAmountColumn, defenseAmountColumn);
		tableView1.setColumnResizePolicy(tableView1.CONSTRAINED_RESIZE_POLICY);
		
		// Equipment Label
		Label l2 = new Label("Equipment");
		l2.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		
		// Equipment Table
		TableView<Item> tableView2 = new TableView<>();
		TableColumn<Item, String> nameColumn2 = new TableColumn<>("Item Name");
		TableColumn<Item, String> descriptionColumn2 = new TableColumn<>("Item Description");
		TableColumn<Item, String> typeColumn2 = new TableColumn<>("Item Type");
		TableColumn<Item, Integer> healthAmountColumn2 = new TableColumn<>("Health");
		TableColumn<Item, Integer> attackAmountColumn2 = new TableColumn<>("Attack");
		TableColumn<Item, Integer> defenseAmountColumn2 = new TableColumn<>("Defense");
		
		nameColumn2.setCellValueFactory(new PropertyValueFactory<>("itemName"));
		descriptionColumn2.setCellValueFactory(new PropertyValueFactory<>("itemDescription"));
		typeColumn2.setCellValueFactory(new PropertyValueFactory<>("itemType"));
		healthAmountColumn2.setCellValueFactory(new PropertyValueFactory<>("itemHealthAmount"));
		attackAmountColumn2.setCellValueFactory(new PropertyValueFactory<>("itemAttackAmount"));
		defenseAmountColumn2.setCellValueFactory(new PropertyValueFactory<>("itemDefenseAmount"));
		
		nameColumn2.setMinWidth(140);
		descriptionColumn2.setMinWidth(300);
		typeColumn2.setMinWidth(100);
		healthAmountColumn2.setMinWidth(50);
		attackAmountColumn2.setMinWidth(50);
		defenseAmountColumn2.setMinWidth(50);
		
		tableView2.setItems(getEquipment(player));
		tableView2.getColumns().addAll(nameColumn2, descriptionColumn2, typeColumn2, healthAmountColumn2, attackAmountColumn2, defenseAmountColumn2);
		tableView2.setColumnResizePolicy(tableView2.CONSTRAINED_RESIZE_POLICY);
					
		// Textfield
		//TextField text = new TextField();
		
		GridPane root = new GridPane();
		root.add(l1, 0, 0);
		//root.add(tableView, 0, 1);
		root.add(tableView1, 0, 1);
		root.add(l2, 0, 2);
		root.add(tableView2, 0, 3);
		root.add(inventoryTextField, 0, 4);
		
		root.setVgap(20);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(50,0,50,0));
		
		GridPane.setHalignment(l1, HPos.CENTER);
		GridPane.setHalignment(l2, HPos.CENTER);
		
		Scene scene = new Scene(root,screenBounds.getWidth()/2,screenBounds.getHeight()/2);
		playerInventoryStage.setScene(scene);
		playerInventoryStage.setTitle("Player Inventory");
		playerInventoryStage.show();
		
		inventoryTextField.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER)) {
				String userInputCommand = inventoryTextField.getText().toLowerCase();
				// This is needed for the drop subsystem
				// Two strings are neeed, the first is the command "drop"
				// Second, the item to be dropped selected by the player
				String action = "";
				String item = "";
				
				Boolean itemSpecified = false;
				Boolean itemExist = false;
				Boolean itemInInventory = false;
				Boolean itemInEquipment = false;
				Boolean itemEquippable = false;
				Boolean itemConsumable = false;
				Boolean itemSpace = false;
				int roomNumber = 0;
				
				// UserInputCommand will be divided in two words, if possible
				// This will track a "space" in the String UserInputCommand
				// If a "space" is tracked in the string, it will divide the string
				// in two words, first word would be from the first char to the char before the first "space"
				// the second word will be everything else (including all spaces after the first space)
				// However, if no "space" is tracked, it would mean the string UserInputCommand
				// is just one word, and that the second word just doesn't exist.
				try {
					action = userInputCommand.substring(0, userInputCommand.indexOf(' '));
					item = userInputCommand.substring(userInputCommand.indexOf(' ') + 1);
				}
				catch (Exception x) {
					action = userInputCommand;
					item = "";
				}
				
				if (action.equals("drop") || (action.equals("drop") && item.equals("+ item_name"))) {
					
					if (item != "") {
						itemSpecified = true;
						
						// If item does not exist
						for (int itemIndex = 0; itemIndex < itemArrayList.size(); itemIndex++) {
							if (itemArrayList.get(itemIndex).getItemName().toLowerCase().equals(item)) {
								itemExist = true;
								
								// If item not in inventory
								for (int inventoryIndex = 0; inventoryIndex < player.getPlayerInventory().size(); inventoryIndex++) {
									if (player.getPlayerInventory().get(inventoryIndex).getItemName().toLowerCase().equals(item)) {
										itemInInventory = true;
										
										// Loop through roomArrayList to get the room name of the current player location
										for (int roomIndex = 0; roomIndex < roomArrayList.size(); roomIndex++) {
											if (roomArrayList.get(roomIndex).getRoomID().equals(player.getPlayerLocation())) {
												
												item = player.getPlayerInventory().get(inventoryIndex).getItemName();
												
												roomNumber = roomIndex;
												
												player.getPlayerInventory().remove(inventoryIndex);											
												itemArrayList.get(itemIndex).setItemIsPickedUp(false);
												itemArrayList.get(itemIndex).setItemLocation(player.getPlayerLocation());	

												tableView1.setItems(getItems(player));
												
												// Updates monster images in map
												if (playerMapStage.isShowing()) {
													double x = playerMapStage.getX();
													double y = playerMapStage.getY();
													
													playerMapStage.close();
													displayMap(player, playerMapStage, mapImageView, locationImageView, puzzleImage, itemImage, monsterImage, puzzleArrayList, itemArrayList, monsterArrayList);
													
													playerMapStage.setX(x);
													playerMapStage.setY(y);
												}
											}
										}
									}
								}
							}
						}
					}
					displayDropCommandMessage(emojiImageView_2, emojiImageView_3, playerInventoryStage, roomArrayList, action, item, roomNumber, itemSpecified, itemExist, itemInInventory);
				}
				else if (action.equals("equip")) {
					if (item != "") {
						itemSpecified = true;
						// If item does not exist
						for (int itemIndex = 0; itemIndex < itemArrayList.size(); itemIndex++) {
							if (itemArrayList.get(itemIndex).getItemName().toLowerCase().equals(item)) {
								itemExist = true;
								// If item not in inventory
								for (int inventoryIndex = 0; inventoryIndex < player.getPlayerInventory().size(); inventoryIndex++) {
									if (player.getPlayerInventory().get(inventoryIndex).getItemName().toLowerCase().equals(item)) {
										itemInInventory = true;
										
										if (player.getPlayerInventory().get(inventoryIndex).getItemType().toLowerCase().equals("equippable")) {
											itemEquippable = true;
											
											if (player.getPlayerEquipment().size() < 1) {
												
												item = player.getPlayerInventory().get(inventoryIndex).getItemName();
												
												itemSpace = true;
												
												player.getPlayerInventory().get(inventoryIndex).setItemIsEquipped(true);
												
												// Stats Update
												player.setPlayerTotalHealth(player.getPlayerTotalHealth() + player.getPlayerInventory().get(inventoryIndex).getItemHealthAmount());
												player.setPlayerMinAttack(player.getPlayerMinAttack() + player.getPlayerInventory().get(inventoryIndex).getItemAttackAmount());
												player.setPlayerMaxAttack(player.getPlayerMaxAttack() + player.getPlayerInventory().get(inventoryIndex).getItemAttackAmount());
												player.setPlayerDefense(player.getPlayerDefense() + player.getPlayerInventory().get(inventoryIndex).getItemDefenseAmount());

												
												// Inventory and Equipment Update
												player.getPlayerEquipment().add(player.getPlayerInventory().get(inventoryIndex));
												player.getPlayerInventory().remove(inventoryIndex);
												tableView1.setItems(getItems(player));
												tableView2.setItems(getEquipment(player));
											}
										}
									}
								}
							}					
						}
					}	
					displayEquipCommandMessage(emojiImageView_2, emojiImageView_3, playerInventoryStage, action, item, itemSpecified, itemExist, itemInInventory, itemEquippable, itemSpace);	
				}
				else if (action.equals("unequip")) {
					if (item != "") {
						itemSpecified = true;
						// If item does not exist
						for (int itemIndex = 0; itemIndex < itemArrayList.size(); itemIndex++) {
							if (itemArrayList.get(itemIndex).getItemName().toLowerCase().equals(item)) {
								itemExist = true;
								// If item not in equipment
								for (int equipmentIndex = 0; equipmentIndex < player.getPlayerEquipment().size(); equipmentIndex++) {
									if (player.getPlayerEquipment().get(equipmentIndex).getItemName().toLowerCase().equals(item)) {
										
										item = player.getPlayerEquipment().get(equipmentIndex).getItemName();
										
										itemInEquipment = true;
										
										player.getPlayerEquipment().get(equipmentIndex).setItemIsEquipped(false);
										
										// Stats Update
										player.setPlayerTotalHealth(player.getPlayerTotalHealth() - player.getPlayerEquipment().get(equipmentIndex).getItemHealthAmount());
										player.setPlayerMinAttack(player.getPlayerMinAttack() - player.getPlayerEquipment().get(equipmentIndex).getItemAttackAmount());
										player.setPlayerMaxAttack(player.getPlayerMaxAttack() - player.getPlayerEquipment().get(equipmentIndex).getItemAttackAmount());
										player.setPlayerDefense(player.getPlayerDefense() - player.getPlayerEquipment().get(equipmentIndex).getItemDefenseAmount());
										
										// Inventory and Equipment Update
										player.getPlayerInventory().add(player.getPlayerEquipment().get(equipmentIndex));
										player.getPlayerEquipment().remove(equipmentIndex);
										tableView1.setItems(getItems(player));
										tableView2.setItems(getEquipment(player));
									}
								}
							}
						}
					}
					displayUnequipCommandMessage(emojiImageView_2, emojiImageView_3, playerInventoryStage, action, item, itemSpecified, itemExist, itemInEquipment);
				}
				else if (action.equals("consume") || action.equals("use")) {
					if (item != "") {
						itemSpecified = true;
						// If item does not exist
						for (int itemIndex = 0; itemIndex < itemArrayList.size(); itemIndex++) {
							if (itemArrayList.get(itemIndex).getItemName().toLowerCase().equals(item)) {
								itemExist = true;
								// If item not in inventory
								for (int inventoryIndex = 0; inventoryIndex < player.getPlayerInventory().size(); inventoryIndex++) {
									if (player.getPlayerInventory().get(inventoryIndex).getItemName().toLowerCase().equals(item)) {
										itemInInventory = true;
										
										if (player.getPlayerInventory().get(inventoryIndex).getItemType().toLowerCase().equals("consumable")) {
											
											item = player.getPlayerInventory().get(inventoryIndex).getItemName();
											
											itemConsumable = true;
											
											player.getPlayerInventory().get(inventoryIndex).setItemIsEquipped(true);
											
											// Stats Update
											player.setPlayerCurrentHealth(player.getPlayerCurrentHealth() + player.getPlayerInventory().get(inventoryIndex).getItemHealthAmount());
											player.setPlayerMinAttack(player.getPlayerMinAttack() + player.getPlayerInventory().get(inventoryIndex).getItemAttackAmount());
											player.setPlayerMaxAttack(player.getPlayerMaxAttack() + player.getPlayerInventory().get(inventoryIndex).getItemAttackAmount());
											player.setPlayerDefense(player.getPlayerDefense() + player.getPlayerInventory().get(inventoryIndex).getItemDefenseAmount());
											
											// If, when an item is consumed, current health exceeds total health, set current health equal to total health
											if (player.getPlayerCurrentHealth() > player.getPlayerTotalHealth())
												player.setPlayerCurrentHealth(player.getPlayerTotalHealth());
											
											// Inventory Update
											player.getPlayerInventory().remove(inventoryIndex);
											tableView1.setItems(getItems(player));
										}
									}
								}
							}					
						}
					}
					displayConsumeCommandMessage(emojiImageView_2, emojiImageView_3, playerInventoryStage, action, item, itemSpecified, itemExist, itemInInventory, itemConsumable);
				}
				else if (userInputCommand.equals("help")) {
					if (!inventoryHelpStage.isShowing())
						helpCommand(inventoryHelpStage, inventoryHelpImageView, screenBounds, "Inventory Help");
				}
				else if (userInputCommand.equals("commands") || userInputCommand.equals("command list")) {
					if (!commandListStage.isShowing())
						helpCommand(commandListStage, commandListImageView, screenBounds, "Command List");
				}
				// This function validates the command, if false, display invalid command message
				else if (player.validateCommand(userInputCommand, generalCommandList).equals(false)) {
					if (invalidStage.isShowing()) {
						invalidStage.close();
						displayInvalidCommandMessage(userInputCommand, emojiImageView_2, primaryStage, invalidStage);
					}
					else {
						displayInvalidCommandMessage(userInputCommand, emojiImageView_2, primaryStage, invalidStage);
					}
				}
				else {
					if (invalidStage.isShowing()) {
						invalidStage.close();
						displayInvalidCommandMessage("scenario command", emojiImageView_2, primaryStage, invalidStage);
					}
					else {
						displayInvalidCommandMessage("scenario command", emojiImageView_2, primaryStage, invalidStage);
					}
				}
				inventoryTextField.clear();
			}
		});
	}
	
	// Get Items in inventory to table view
	public ObservableList<Item> getItems(Player player) {
		ObservableList<Item> item = FXCollections.observableArrayList();
		
		for (int inventoryIndex = 0; inventoryIndex < player.getPlayerInventory().size(); inventoryIndex++) {
			item.add(new Item(player.getPlayerInventory().get(inventoryIndex).getItemName(), player.getPlayerInventory().get(inventoryIndex).getItemDescription(), player.getPlayerInventory().get(inventoryIndex).getItemType(),
					player.getPlayerInventory().get(inventoryIndex).getItemHealthAmount(), player.getPlayerInventory().get(inventoryIndex).getItemAttackAmount(), player.getPlayerInventory().get(inventoryIndex).getItemDefenseAmount()));		
		}
		
		return item;
	}
	
	// Get Items in equipment to table view
	public ObservableList<Item> getEquipment(Player player) {
		ObservableList<Item> item = FXCollections.observableArrayList();
		
		for (int equipmentIndex = 0; equipmentIndex < player.getPlayerEquipment().size(); equipmentIndex++) {
			item.add(new Item(player.getPlayerEquipment().get(equipmentIndex).getItemName(), player.getPlayerEquipment().get(equipmentIndex).getItemDescription(), player.getPlayerEquipment().get(equipmentIndex).getItemType(),
					player.getPlayerEquipment().get(equipmentIndex).getItemHealthAmount(), player.getPlayerEquipment().get(equipmentIndex).getItemAttackAmount(), player.getPlayerEquipment().get(equipmentIndex).getItemDefenseAmount()));		
		}
		
		return item;
	}
	
	// This function displays a message to the player
	// Whether the item has been sucessfully consumed or not
	public void displayConsumeCommandMessage(ImageView emojiImageView_2, ImageView emojiImageView_3, Stage playerInventoryStage, String action, String item,
				Boolean itemSpecified, Boolean itemExist, Boolean itemInInventory, Boolean itemConsumable) {
		ImageView emoji = emojiImageView_2;
		Stage itemDroppedStage = new Stage();
		Text message = new Text("");
		
		message.setTextAlignment(TextAlignment.CENTER);
		VBox itemBox = new VBox(10);
		itemBox.setAlignment(Pos.CENTER);
		Button okButton = new Button("OK");
		
		if (itemSpecified.equals(false)) {
			message.setText("Please specify\nWhat item would you like to drop");
			itemDroppedStage.setTitle("Unspecified");
		}
		else if (itemExist.equals(false)) {
			message.setText("The entered item doesn't exist");
			itemDroppedStage.setTitle("Invalid item");
		}
		else if (itemInInventory.equals(false)) {
			message.setText("The entered item is not in your inventory");
			itemDroppedStage.setTitle("Not in Inventory");
		}
		else if (itemConsumable.equals(false)) {
			message.setText("The entered item is not consumable");
			itemDroppedStage.setTitle("Not Consumable");
		}
		else {
			message.setText(item + " has been consumed");
			itemDroppedStage.setTitle("Item Consumed");
			emoji = emojiImageView_3;
		}
		
		itemBox.getChildren().add(message);
		itemBox.getChildren().add(emoji);
		itemBox.getChildren().add(okButton);
				
		Scene itemDroppedScene = new Scene(itemBox, 250, 150);
		
		itemDroppedStage.setResizable(false);
		
		itemDroppedStage.setX(playerInventoryStage.getX() + (playerInventoryStage.getWidth() - itemDroppedScene.getWidth())/2);
		itemDroppedStage.setY(playerInventoryStage.getY() + (playerInventoryStage.getHeight() - itemDroppedScene.getHeight())/2);
		
		itemDroppedStage.setScene(itemDroppedScene);
		itemDroppedStage.show();
		
		okButton.setOnAction(f -> {
			itemDroppedStage.close();
		});
	}
	
	// This function displays a message to the player
	// Whether the item has been successfully unequipped or not
	public void displayUnequipCommandMessage(ImageView emojiImageView_2, ImageView emojiImageView_3, Stage playerInventoryStage, String action, String item,
			Boolean itemSpecified, Boolean itemExist, Boolean itemInEquipment) {
		ImageView emoji = emojiImageView_2;
		Stage itemDroppedStage = new Stage();
		Text message = new Text("");
		
		message.setTextAlignment(TextAlignment.CENTER);
		VBox itemBox = new VBox(10);
		itemBox.setAlignment(Pos.CENTER);
		Button okButton = new Button("OK");
		
		if (itemSpecified.equals(false)) {
			message.setText("Please specify\nWhat item would you like to drop");
			itemDroppedStage.setTitle("Unspecified");
		}
		else if (itemExist.equals(false)) {
			message.setText("The entered item doesn't exist");
			itemDroppedStage.setTitle("Invalid item");
		}
		else if (itemInEquipment.equals(false)) {
			message.setText("The entered item is not in your inventory");
			itemDroppedStage.setTitle("Not in Inventory");
		}
		else {
			message.setText(item + " is now unequipped");
			itemDroppedStage.setTitle("Item Unequipped");
			emoji = emojiImageView_3;
		}
		
		itemBox.getChildren().add(message);
		itemBox.getChildren().add(emoji);
		itemBox.getChildren().add(okButton);
				
		Scene itemDroppedScene = new Scene(itemBox, 250, 150);
		
		itemDroppedStage.setResizable(false);
		
		itemDroppedStage.setX(playerInventoryStage.getX() + (playerInventoryStage.getWidth() - itemDroppedScene.getWidth())/2);
		itemDroppedStage.setY(playerInventoryStage.getY() + (playerInventoryStage.getHeight() - itemDroppedScene.getHeight())/2);
		
		itemDroppedStage.setScene(itemDroppedScene);
		itemDroppedStage.show();
		
		okButton.setOnAction(f -> {
			itemDroppedStage.close();
		});
	}
	
	// This function displays a message to the player
	// Whether the item has been successfully equipped or not
	public void displayEquipCommandMessage(ImageView emojiImageView_2, ImageView emojiImageView_3, Stage playerInventoryStage, String action, String item, 
				Boolean itemSpecified, Boolean itemExist, Boolean itemInInventory, Boolean itemEquippable, Boolean itemSpace) {
		ImageView emoji = emojiImageView_2;
		Stage itemDroppedStage = new Stage();
		Text message = new Text("");
		
		message.setTextAlignment(TextAlignment.CENTER);
		VBox itemBox = new VBox(10);
		itemBox.setAlignment(Pos.CENTER);
		Button okButton = new Button("OK");
		
		if (itemSpecified.equals(false)) {
			message.setText("Please specify\nWhat item would you like to drop");
			itemDroppedStage.setTitle("Unspecified");
		}
		else if (itemExist.equals(false)) {
			message.setText("The entered item doesn't exist");
			itemDroppedStage.setTitle("Invalid item");
		}
		else if (itemInInventory.equals(false)) {
			message.setText("The entered item is not in your inventory");
			itemDroppedStage.setTitle("Not in Inventory");
		}
		else if (itemEquippable.equals(false)) {
			message.setText("The entered item is not equippable");
			itemDroppedStage.setTitle("Not Equippable");
		}
		else if (itemSpace.equals(false)) {
			message.setText("An item is already equipped");
			itemDroppedStage.setTitle("No Space");
		}
		else {
			message.setText(item + " is now equipped");
			itemDroppedStage.setTitle("Item Equipped");
			emoji = emojiImageView_3;
		}
		
		itemBox.getChildren().add(message);
		itemBox.getChildren().add(emoji);
		itemBox.getChildren().add(okButton);
				
		Scene itemDroppedScene = new Scene(itemBox, 250, 150);
		
		itemDroppedStage.setResizable(false);
		
		itemDroppedStage.setX(playerInventoryStage.getX() + (playerInventoryStage.getWidth() - itemDroppedScene.getWidth())/2);
		itemDroppedStage.setY(playerInventoryStage.getY() + (playerInventoryStage.getHeight() - itemDroppedScene.getHeight())/2);
		
		itemDroppedStage.setScene(itemDroppedScene);
		itemDroppedStage.show();
		
		okButton.setOnAction(f -> {
			itemDroppedStage.close();
		});
	}
	
	// This function displays a message to the player
	// Whether the item has been successfully dropped or not
	public void displayDropCommandMessage(ImageView emojiImageView_2, ImageView emojiImageView_3, Stage playerInventoryStage, ArrayList<Room> roomArrayList,
				String action, String item, int roomIndex, Boolean itemSpecified, Boolean itemExist, Boolean itemInInventory) {
		ImageView emoji = emojiImageView_2;
		Stage itemDroppedStage = new Stage();
		Text message = new Text("");
		
		message.setTextAlignment(TextAlignment.CENTER);
		VBox itemBox = new VBox(10);
		itemBox.setAlignment(Pos.CENTER);
		Button okButton = new Button("OK");
		
		if (itemSpecified.equals(false)) {
			message.setText("Please specify\nWhat item would you like to drop");
			itemDroppedStage.setTitle("Unspecified");
		}
		else if (itemExist.equals(false)) {
			message.setText("The entered item doesn't exist");
			itemDroppedStage.setTitle("Invalid item");
		}
		else if (itemInInventory.equals(false)) {
			message.setText("The entered item is not in your inventory");
			itemDroppedStage.setTitle("Not in Inventory");
		}
		else {
			message.setText(item + " has been dropped in Room:\n" + roomArrayList.get(roomIndex).getRoomName());
			itemDroppedStage.setTitle("Item Dropped");
			emoji = emojiImageView_3;
		}
		
		itemBox.getChildren().add(message);
		itemBox.getChildren().add(emoji);
		itemBox.getChildren().add(okButton);
				
		Scene itemDroppedScene = new Scene(itemBox, 250, 150);
		
		itemDroppedStage.setResizable(false);
		
		itemDroppedStage.setX(playerInventoryStage.getX() + (playerInventoryStage.getWidth() - itemDroppedScene.getWidth())/2);
		itemDroppedStage.setY(playerInventoryStage.getY() + (playerInventoryStage.getHeight() - itemDroppedScene.getHeight())/2);
		
		itemDroppedStage.setScene(itemDroppedScene);
		itemDroppedStage.show();
		
		okButton.setOnAction(f -> {
			itemDroppedStage.close();
		});
	}
	
	// This function display an invalid command message
	// if the entered input is an invalid command
	public void displayInvalidCommandMessage(String userInputCommand, ImageView emojiImageView_1, Stage primaryStage, Stage invalidStage) {
		Text invalidCommandMessage = new Text("");
		
		if (userInputCommand.equals("move")) {
			invalidCommandMessage.setText("Please specify\nWhere would you like to move");
			invalidStage.setTitle("Move Error");
		}
		else if (userInputCommand.equals("empty inventory")) {
			invalidCommandMessage.setText("Inventory is empty");
			invalidStage.setTitle("Empty Inventory");
		}
		else if (userInputCommand.equals("no room")) {
			invalidCommandMessage.setText("No room in this direction!");
			invalidStage.setTitle("No room");
		}
		else if (userInputCommand.equals("nothing here")) {
			invalidCommandMessage.setText("Nothing found here...");
			invalidStage.setTitle("Nothing found");
		}
		else if (userInputCommand.equals("scenario command")) {
			invalidCommandMessage.setText("Invalid Command in this scenario");
			invalidStage.setTitle("Invalid");
		}
		else {
			invalidCommandMessage.setText("Invalid Command!");
			invalidStage.setTitle("Invalid");
		}
		
		invalidCommandMessage.setTextAlignment(TextAlignment.CENTER);
		VBox invalidCommandBox = new VBox(10);
		invalidCommandBox.setAlignment(Pos.CENTER);
		
		Button okButton = new Button("OK");
		
		invalidCommandBox.getChildren().add(invalidCommandMessage);
		invalidCommandBox.getChildren().add(emojiImageView_1);
		invalidCommandBox.getChildren().add(okButton);
				
		Scene invalidCommandScene = new Scene(invalidCommandBox, 250, 150);
		
		invalidStage.setResizable(false);
		
		invalidStage.setX(primaryStage.getX() + (primaryStage.getWidth() - invalidCommandScene.getWidth())/2);
		invalidStage.setY(primaryStage.getY() + (primaryStage.getHeight() - invalidCommandScene.getHeight())/2);
		
		invalidStage.setScene(invalidCommandScene);
		invalidStage.show();
		
		okButton.setOnAction(e -> {
			invalidStage.close();
		});
	}
	
	// This function displays the player's stats
	public void displayStats(ImageView emoji, Stage primaryStage, Player player, Stage statsStage) {
		Text m = new Text("Your Stats");
		m.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		
		Text statsMessage = new Text("Your username: " + player.getPlayerUsername() + "\n" +
									 "Your health: " + player.getPlayerCurrentHealth() + "/" + player.getPlayerTotalHealth() + "HP\n" + 
									 "Your attack: " + player.getPlayerMinAttack() + "-" + player.getPlayerMaxAttack() + "\n" + 
									 "Your defense: " + player.getPlayerDefense());
		
		statsStage.setTitle("Your Stats");
		
		statsMessage.setTextAlignment(TextAlignment.CENTER);
		VBox statsBox = new VBox(10);
		statsBox.setAlignment(Pos.CENTER);
		
		Button okButton = new Button("OK");
		
		statsBox.getChildren().addAll(m, statsMessage);
		statsBox.getChildren().add(emoji);
		statsBox.getChildren().add(okButton);
				
		Scene statsScene = new Scene(statsBox, 250, 200);
		
		statsStage.setResizable(false);
		
		statsStage.setX(primaryStage.getX() + (primaryStage.getWidth() - statsScene.getWidth())/2);
		statsStage.setY(primaryStage.getY() + (primaryStage.getHeight() - statsScene.getHeight())/2);
		
		statsStage.setScene(statsScene);
		statsStage.show();
		
		okButton.setOnAction(e -> {
			statsStage.close();
		});
	}
	
	// This function validates the player's input
	// whether the entered input is a valid command or not
	public Boolean validateCommand(String userInputCommand, ArrayList<String> commandList) {
		for (int i = 0; i < commandList.size(); i++) {
			if (userInputCommand.equals("move")) {
				return false;
			}
			else if (commandList.get(i).equals(userInputCommand)) {
				return true;
			}
		}		
		return false;
	}
	
	// This function takes the player's input and does something!
	public Boolean doMoveCommand(String userInput, TextField userInputTextField, Player player, Map map, ArrayList<Item> itemArrayList, ArrayList<Puzzle> puzzleArrayList, 
			ImageView emojiImageView_2, ArrayList<String> generalCommandList, Stage primaryStage, ImageView locationInMap, Stage invalidStage) {
		int direction = 0;
		
		if (userInput.equals("move north") || userInput.equals("north") || userInput.equals("n")) {
			direction = 0;
		}
		else if (userInput.equals("move east") || userInput.equals("east") || userInput.equals("e")) {
			direction = 1;
		}
		else if (userInput.equals("move south") || userInput.equals("south") || userInput.equals("s")) {
			direction = 2;
		}
		else if (userInput.equals("move west") || userInput.equals("west") || userInput.equals("w")) {
			direction = 3;
		}
		else {
			if (invalidStage.isShowing()) {
				invalidStage.close();
				displayInvalidCommandMessage("scenario command", emojiImageView_2, primaryStage, invalidStage);
			}
			else {
				displayInvalidCommandMessage("scenario command", emojiImageView_2, primaryStage, invalidStage);
			}
			
			return false;
		}
		return player.playerMoves(player, map, direction, locationInMap, primaryStage, emojiImageView_2, invalidStage);
	}

	// This function verifies if the player move is valid or not
	public Boolean playerMoves(Player player, Map map, int direction, ImageView locationInMap, Stage primaryStage, ImageView emojiImageView_2, Stage invalidStage) {
		// Convert player Location (String) to Int
		String index = player.getPlayerLocation();
		int indexLocation = Integer.parseInt(index.substring(1))-1;
			
		if (map.roomArrayList.get(indexLocation).getRoomAround()[direction].equals("R00")) {
			if (invalidStage.isShowing()) {
				invalidStage.close();
				displayInvalidCommandMessage("no room", emojiImageView_2, primaryStage, invalidStage);
			}
			else {
				displayInvalidCommandMessage("no room", emojiImageView_2, primaryStage, invalidStage);
			}
			return false;
		}
		else {
			player.setPlayerLocation(map.roomArrayList.get(indexLocation).getRoomAround()[direction]);
			
			setLocationOfPlayerInMap(player.getPlayerLocation(), locationInMap);
			
			return true;
		}
	}	
	
	// This function saves the progress of the player
	public void savePlayerGame (Player player, ArrayList<Item> itemArrayList, ArrayList<Puzzle> puzzleArrayList, ArrayList<Monster> monsterArrayList, Stage primaryStage, ImageView emoji) {
		File playerFile = new File(player.getPlayerUsername() + ".txt");
		
		if (playerFile.exists()) {
			playerFile.delete();
			
			try {
				playerFile.createNewFile();
				
				FileWriter playerFileWriter = new FileWriter(player.getPlayerUsername() + ".txt");
				
				playerFileWriter.write(player.getPlayerID() + "~");
				playerFileWriter.write(player.getPlayerUsername() + "~");
				playerFileWriter.write(player.getPlayerPassword() + "~");
				playerFileWriter.write(player.getPlayerCurrentHealth() + "~");
				playerFileWriter.write(player.getPlayerTotalHealth() + "~");
				playerFileWriter.write(player.getPlayerMinAttack() + "~");
				playerFileWriter.write(player.getPlayerMaxAttack() + "~");
				playerFileWriter.write(player.getPlayerDefense() + "~");
				playerFileWriter.write(player.getPlayerScore() + "~");
				playerFileWriter.write(player.getPlayerLocation() + "~\n");
				
				for (int itemIndex = 0; itemIndex < itemArrayList.size(); itemIndex++) {
					playerFileWriter.write(itemArrayList.get(itemIndex).getItemLocation() + "~");
					playerFileWriter.write(itemArrayList.get(itemIndex).getItemIsPickedUp() + "~");
					playerFileWriter.write(itemArrayList.get(itemIndex).getItemIsEquipped() + "~");
					playerFileWriter.write(itemArrayList.get(itemIndex).getItemIsLocked() + "~\n");
				}
				
				for (int puzzleIndex = 0; puzzleIndex < puzzleArrayList.size(); puzzleIndex++) {
					playerFileWriter.write(puzzleArrayList.get(puzzleIndex).getPuzzleAttempts() + "~");
					playerFileWriter.write(puzzleArrayList.get(puzzleIndex).getPuzzleIsSolved() + "~");
					playerFileWriter.write(puzzleArrayList.get(puzzleIndex).getPuzzleIsLocked() + "~\n");
				}
				
				for (int monsterIndex = 0; monsterIndex < monsterArrayList.size(); monsterIndex++) {
					playerFileWriter.write(monsterArrayList.get(monsterIndex).getMonsterCurrentHealth() + "~");
					playerFileWriter.write(monsterArrayList.get(monsterIndex).getMonsterIsDefeated() + "~\n");
				}
				
				playerFileWriter.close();
				
				displayProgressSaved(primaryStage, emoji);
			}
			catch(Exception e) {
				;
			}
		}
		
	}
	
	// Display a message, that indicates whether the progress was sucessfully saved or not
	public void displayProgressSaved(Stage primaryStage, ImageView emoji) {
		Text t = new Text("Your progress has been sucessfully saved!");
		t.setStyle("-fx-font-size: 13px;" +
				   "-fx-font-weight: bold");
		
		Button okButton = new Button("OK");
		
		VBox box = new VBox(10);
		box.setAlignment(Pos.CENTER);
		
		box.getChildren().add(t);
		box.getChildren().add(emoji);
		box.getChildren().add(okButton);
		
		Scene savedScene = new Scene(box, 300, 150);
		Stage savedStage = new Stage();
		
		savedStage.setX(primaryStage.getX() + (primaryStage.getWidth() - savedScene.getWidth())/2);
		savedStage.setY(primaryStage.getY() + (primaryStage.getHeight() - savedScene.getHeight())/2);
		
		savedStage.setScene(savedScene);
		savedStage.show();
		savedStage.setTitle("Progress Saved");
		
		okButton.setOnAction(e -> {
			savedStage.close();
		});
	}
	
}
